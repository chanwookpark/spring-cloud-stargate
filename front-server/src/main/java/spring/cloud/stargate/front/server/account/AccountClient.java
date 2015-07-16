package spring.cloud.stargate.front.server.account;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author chanwook
 */
@FeignClient("accounts-service")
public interface AccountClient {

    @RequestMapping(method = RequestMethod.GET,
            value = "/accounts/{number}", consumes = "application/json")
    Account getAccount(@PathVariable("number") String number);
}
