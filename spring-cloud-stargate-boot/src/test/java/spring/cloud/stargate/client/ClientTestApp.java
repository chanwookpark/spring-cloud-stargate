package spring.cloud.stargate.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.cloud.stargate.client.config.ClientInstanceInjectionBeanFactoryPostProcessor;

/**
 * @author chanwook
 */
@Configuration
@EnableAutoConfiguration
public class ClientTestApp {

    public static void main(String[] args) {
        SpringApplication.run(ClientTestApp.class, args);
    }

    @Bean
    public static ClientInstanceInjectionBeanFactoryPostProcessor processor() {
        return new ClientInstanceInjectionBeanFactoryPostProcessor("spring.cloud.stargate.client");
    }
}
