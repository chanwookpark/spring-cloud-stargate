package spring.cloud.stargate.front.server.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author chanwook
 */
@Service
public class WebAccountService {

    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    String serviceUrl;

    public WebAccountService(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public Account getByNumber(String accountNumber) {
        Account account = restTemplate.getForObject(serviceUrl
                + "/accounts/{number}", Account.class, accountNumber);

        if (account == null) {
            throw new RuntimeException(accountNumber);
        } else {
            return account;
        }
    }
}
