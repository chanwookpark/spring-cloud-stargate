package spring.cloud.stargate.client.sample.product;

import org.springframework.http.MediaType;
import spring.cloud.stargate.client.annotation.*;

/**
 * @author chanwook
 */
@APIClient("product")
public interface ProductClient {

    @GET(path = "/products/{}", consumes = MediaType.APPLICATION_JSON_VALUE)
    Product getOne(@Path String id);

    @POST(path = "/products/{}", produces = MediaType.APPLICATION_XML_VALUE)
    String create(@Path String id, @Body Product product);
}
