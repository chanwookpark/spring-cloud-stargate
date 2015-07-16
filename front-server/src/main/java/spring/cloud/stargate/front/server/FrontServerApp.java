package spring.cloud.stargate.front.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chanwook
 */
@SpringBootApplication
// 왜 이렇게 직접 지정하냐면 ribbon 가이드에 나오는 경고 때문에..
@ComponentScan(useDefaultFilters = false)
@EnableDiscoveryClient
@RestController
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
