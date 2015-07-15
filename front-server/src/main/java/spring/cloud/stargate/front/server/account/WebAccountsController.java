package spring.cloud.stargate.front.server.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import r2.dustjs.spring.DustModel;

/**
 * @author chanwook
 */
@Controller
public class WebAccountsController {

    private WebAccountService service;

    public WebAccountsController(WebAccountService service) {
        this.service = service;
    }

    @RequestMapping("/accounts/{number}")
    public String findAccounts(@PathVariable String number, DustModel model) {

        final Account account = service.getByNumber(number);
        model.put("account", account);

        return "account";
    }
}
