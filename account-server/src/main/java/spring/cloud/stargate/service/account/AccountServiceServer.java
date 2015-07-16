package spring.cloud.stargate.service.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chanwook
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AccountServiceServer {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "accounts-service");

        SpringApplication.run(AccountServiceServer.class, args);
    }
}
