package spring.cloud.stargate.client.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chanwook
 */
@SpringBootApplication
@RestController
public class ClientSampleApp {

    public static void main(String[] args) {
        SpringApplication.run(ClientSampleApp.class, args);
    }

    @RequestMapping("/check")
    public String check() {
        return "OK!";
    }
}
