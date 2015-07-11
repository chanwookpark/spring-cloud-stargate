package spring.cloud.stargate.config.client.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import spring.cloud.stargate.client.config.ClientInstanceInjectionBeanFactoryPostProcessor;
import spring.cloud.stargate.client.metadata.SpringCloudMetadataResolver;

/**
 * @author chanwook
 */
@Configuration
public class CloudConfig {

    @Bean
    public static ClientInstanceInjectionBeanFactoryPostProcessor processor(Environment env) {
        final ClientInstanceInjectionBeanFactoryPostProcessor bfpp =
                new ClientInstanceInjectionBeanFactoryPostProcessor("spring.cloud.stargate");
        final SpringCloudMetadataResolver metadataResolver = new SpringCloudMetadataResolver(env);
        bfpp.setMetadataResolver(metadataResolver);
        return bfpp;
    }
}
