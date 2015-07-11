package spring.cloud.stargate.client.sample.product;

import spring.cloud.stargate.client.annotation.*;

/**
 * @author chanwook
 */
@APIClient("product")
public interface ProductClient {

    @GET(path = "/products/{}", consumes = "application/json")
    Product getOne(@Path String id);

    @POST(path = "/products/{productId}", produces = "application/xml")
    String create(@Body Product product, @Path("productId") String id);
}
