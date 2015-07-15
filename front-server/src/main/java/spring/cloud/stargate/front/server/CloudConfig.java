package spring.cloud.stargate.front.server;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import spring.cloud.stargate.client.config.ClientInstanceInjectionBeanFactoryPostProcessor;
import spring.cloud.stargate.client.metadata.SpringCloudMetadataResolver;

/**
 * @author chanwook
 */
//@Configuration
public class CloudConfig {

    @Bean
    public static ClientInstanceInjectionBeanFactoryPostProcessor processor(Environment env,
                                                                            LoadBalancerClient loadBalancerClient) {
        final ClientInstanceInjectionBeanFactoryPostProcessor bfpp =
                new ClientInstanceInjectionBeanFactoryPostProcessor("spring.cloud.stargate");
        final SpringCloudMetadataResolver metadataResolver = new SpringCloudMetadataResolver(env);
        bfpp.setMetadataResolver(metadataResolver);
        bfpp.setLoadBalancer(loadBalancerClient);
        return bfpp;
    }
}
