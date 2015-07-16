package spring.cloud.stargate.front.server.account;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chanwook
 */
@Configuration
public class AccountServiceConfig {
    @Bean
    public WebAccountService accountsService() {
        // 1. Value should not be hard-coded, just to keep things simple in this example.
        // 2. Case insensitive: could also use: http://accounts-service
        return new WebAccountService("http://ACCOUNTS-SERVICE");  // serviceUrl
    }

    @Bean
    public WebAccountsController accountsController() {
        return new WebAccountsController(accountsService());
    }
}
