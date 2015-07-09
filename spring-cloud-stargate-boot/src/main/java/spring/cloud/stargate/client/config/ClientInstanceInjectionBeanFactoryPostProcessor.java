package spring.cloud.stargate.client.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import spring.cloud.stargate.client.annotation.APIClient;
import spring.cloud.stargate.client.metadata.APIMetadataResolver;

import java.util.Set;

/**
 * @author chanwook
 */
public class ClientInstanceInjectionBeanFactoryPostProcessor implements BeanFactoryPostProcessor, InitializingBean {

    private final Logger logger = LoggerFactory.getLogger(ClientInstanceInjectionBeanFactoryPostProcessor.class);

    private String basePackage;

    private APIMetadataResolver metadataResolver;

    public ClientInstanceInjectionBeanFactoryPostProcessor() {
    }

    public ClientInstanceInjectionBeanFactoryPostProcessor(String basePackage) {
        this.basePackage = basePackage;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false) {
                    @Override
                    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                        // return super.isCandidateComponent(beanDefinition);
                        // to include interface class
                        return beanDefinition.getMetadata().isIndependent();
                    }
                };
        scanner.addIncludeFilter(new AnnotationTypeFilter(APIClient.class, true, true));

        final Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents(basePackage);
        for (BeanDefinition definition : candidateComponents) {
            try {
                final String beanClassName = definition.getBeanClassName();
                final Class<?> clientClass = ClassUtils.forName(beanClassName, /* use default classLoader*/ null);

                // create proxy instance
                ProxyFactory proxy = new ProxyFactory();
                proxy.setInterfaces(clientClass);
                proxy.setTarget(new APIClientBean());
                proxy.addAdvice(new ClientExecutionInterceptor());

                // resolve bean name
                final APIClient clientAnnotation = clientClass.getAnnotation(APIClient.class);
                String beanName = StringUtils.hasText(clientAnnotation.value()) ? clientAnnotation.value() : beanClassName;

                //TODO refactoring..
                createMetadata(beanName);

                beanFactory.registerSingleton(beanName, proxy.getProxy());

                if (logger.isDebugEnabled()) {
                    logger.debug("Add Client instance [" + beanClassName + "]");
                }

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void createMetadata(String apiKey) {
        metadataResolver.getApiHost(apiKey);
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public void setMetadataResolver(APIMetadataResolver metadataResolver) {
        this.metadataResolver = metadataResolver;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (!StringUtils.hasText(basePackage)) {
            throw new RuntimeException("Needs scanning package(basePackage property)!");
        }
    }
}
