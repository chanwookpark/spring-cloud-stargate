package spring.cloud.stargate.client.sample.product;

import spring.cloud.stargate.client.MediaType;
import spring.cloud.stargate.client.annotation.*;

/**
 * @author chanwook
 */
@APIClient("product")
public interface ProductClient {

    @GET(path = "/products/{}", consumes = MediaType.APP_JSON)
    Product getOne(@Path String id);

    @POST(path = "/products/{}", produces = MediaType.APP_XML)
    String create(@Path String id, @Body Product product);
}
