package spring.cloud.stargate.front.server.product;

/**
 * @author chanwook
 */
public class Product {
    private String productId;
    private String productName;
    private long price;

    public Product() {
    }

    public Product(String productId, String productName, long price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
