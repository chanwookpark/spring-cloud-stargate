package spring.cloud.stargate.client.config;

/**
 * @author chanwook
 */
public class ApiClientBean {

    private final ApiMetadataMap metadata;

    public ApiClientBean(ApiMetadataMap metadata) {
        this.metadata = metadata;
    }

    public ApiMetadataMap getMetadata() {
        return metadata;
    }
}
