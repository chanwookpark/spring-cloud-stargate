package spring.cloud.stargate.client.metadata;

/**
 * @author chanwook
 */
public interface APIMetadataResolver {
    String getApiHost(String key);
}
