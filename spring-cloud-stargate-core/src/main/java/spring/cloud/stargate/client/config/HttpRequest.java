package spring.cloud.stargate.client.config;

import org.springframework.http.HttpMethod;

/**
 * @author chanwook
 */
public class HttpRequest {
    private String path;
    private HttpMethod type;
    private String accept;

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setAccept(String acceptMediaType) {
        this.accept = acceptMediaType;
    }

    public String getAccept() {
        return accept;
    }

    public HttpMethod getType() {
        return type;
    }

    public void setType(HttpMethod type) {
        this.type = type;
    }
}
