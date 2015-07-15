package spring.cloud.stargate.service.account;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chanwook
 */
@RestController
public class AccountRestController {

    @RequestMapping("/accounts/{number}")
    public Account getAccountByNumber(@PathVariable String number) {
        return new Account(number);
    }
}
