package spring.cloud.stargate.front.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.stargate.front.server.account.AccountServiceConfig;

/**
 * @author chanwook
 */
@SpringBootApplication
@ComponentScan(useDefaultFilters = false)
@EnableDiscoveryClient
@RestController
@Import({WebConfig.class, AccountServiceConfig.class})
public class FrontServerApp {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "front-server");
        SpringApplication.run(FrontServerApp.class, args);
    }

    @RequestMapping("/check")
    public String check() {
        return "OK!";
    }

}
