package spring.cloud.stargate.config.client.sample.product;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chanwook
 */
@RestController
public class ProductApiController {

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
    public Product getOneResource(@PathVariable String productId) {
        return new Product(productId, "맥북", 100);
    }
}

