package spring.cloud.stargate.config.client.sample.product;

import spring.cloud.stargate.client.annotation.*;

/**
 * @author chanwook
 */
@APIClient("product")
public interface ProductClient {

    //TODO {}에 id 적지 않아도 되도록 수정
    @GET(path = "/products/{productId}", consumes = "application/json")
    Product getOne(@Path("productId") String id);

    @POST(path = "/products/{productId}", produces = "application/xml")
    String create(@Body Product product, @Path("productId") String id);
}
