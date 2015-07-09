package spring.cloud.stargate.client.metadata;

import org.springframework.core.env.Environment;

/**
 * @author chanwook
 */
public class SpringCloudMetadataResolver implements APIMetadataResolver {
    private final Environment env;

    public SpringCloudMetadataResolver(Environment env) {
        this.env = env;
    }

    @Override
    public String getApiHost(String key) {
        final String host = env.getProperty("api." + key + ".host");
        final String port = env.getProperty("api." + key + ".port");

        return "http://" + host + ":" + port + "/";
    }

}
