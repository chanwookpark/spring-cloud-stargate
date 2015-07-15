package spring.cloud.stargate.service.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chanwook
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
public class AccountServiceServer {

    public static void main(String[] args) {
        // Will configure using accounts-server.yml
        System.setProperty("spring.config.name", "accounts-server");

        SpringApplication.run(AccountServiceServer.class, args);
    }
}
