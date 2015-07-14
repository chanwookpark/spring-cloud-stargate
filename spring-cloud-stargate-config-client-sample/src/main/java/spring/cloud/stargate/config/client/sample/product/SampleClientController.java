package spring.cloud.stargate.config.client.sample.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import r2.dustjs.spring.DustModel;

/**
 * @author chanwook
 */
@Controller
public class SampleClientController {

    @Autowired
    private ProductClient client;

    @RequestMapping("/product/view.html")
    public String view(@RequestParam("productId") String productId, DustModel model) {
        final Product product = client.getOne(productId);
        model.put("product", product);
        return "view";
    }
}
