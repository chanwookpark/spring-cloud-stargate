package spring.cloud.stargate.client.metadata;

import spring.cloud.stargate.client.config.ApiMetadataMap;

/**
 * @author chanwook
 */
public interface APIMetadataResolver {
    ApiMetadataMap createMetadata(String key);
}
