package spring.cloud.stargate.client.metadata;

import org.springframework.core.env.Environment;
import spring.cloud.stargate.client.config.ApiMetadataMap;

/**
 * @author chanwook
 */
public class SpringCloudMetadataResolver implements APIMetadataResolver {
    public static final String PROPERTY_KEY_API_CATEGORY = "api.";
    
    private final Environment env;

    public SpringCloudMetadataResolver(Environment env) {
        this.env = env;
    }

    @Override
    public ApiMetadataMap createMetadata(String key) {
        ApiMetadataMap metadata = new ApiMetadataMap();
        metadata.put("host", env.getProperty(PROPERTY_KEY_API_CATEGORY + key + ".host"));
        metadata.put("port", env.getProperty(PROPERTY_KEY_API_CATEGORY + key + ".port"));

        return metadata;
    }
}
