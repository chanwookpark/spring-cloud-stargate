package spring.cloud.stargate.client.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import spring.cloud.stargate.client.annotation.GET;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chanwook
 */
public class ClientExecutionInterceptor implements MethodInterceptor {

    final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        final ReflectiveMethodInvocation reflective = (ReflectiveMethodInvocation) invocation;
        if (reflective.getThis() instanceof ApiClientBean) {
            ApiClientBean api = (ApiClientBean) reflective.getThis();
            HttpRequest method = createMethod(reflective);
            String url = createUri(api, method);
            HttpEntity requestEntity = createRequestEntity(method);
            Class<?> responseType = reflective.getMethod().getReturnType();
            Map<String, Object> paramMap = createParamemter(reflective);

            final ResponseEntity<?> responseEntity = restTemplate.exchange(url, method.getType(), requestEntity, responseType, paramMap);
            return responseEntity.getBody();
        }
        return invocation.proceed();
    }

    private HttpEntity createRequestEntity(HttpRequest method) {
        final HttpHeaders headers = createHeader(method);
        return new HttpEntity(headers);
    }

    private HttpHeaders createHeader(HttpRequest method) {
        final HttpHeaders headers = new HttpHeaders();
        if (method.getAccept() != null) {
            headers.set(HttpHeaders.ACCEPT, method.getAccept());
        }
        return headers;
    }

    private Map<String, Object> createParamemter(ReflectiveMethodInvocation reflective) {
        Map<String, Object> paramMap = new HashMap<>();
//        final TypeVariable<Method>[] typeParameters = reflective.getMethod().getTypeParameters();
        final Parameter[] parameters = reflective.getMethod().getParameters();
        final Object[] arguments = reflective.getArguments();
        for (int index = 0; index < arguments.length; index++) {
            final String name = parameters[index].getName();
            final Object value = arguments[index];
            paramMap.put(name, value);
        }
        return paramMap;
    }

    private HttpRequest createMethod(ReflectiveMethodInvocation reflective) {
        HttpRequest method = new HttpRequest();
        for (Annotation annotation : reflective.getStaticPart().getAnnotations()) {
            if (annotation.annotationType().equals(GET.class)) {
                GET getMethod = (GET) annotation;
                method.setPath(getMethod.path());
                method.setType(HttpMethod.GET);
                method.setAccept(getMethod.consumes());
            }
        }
        return method;
    }

    private String createUri(ApiClientBean api, HttpRequest method) {
        final ApiMetadataMap metadata = api.getMetadata();
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();

        uriBuilder.scheme("http");
        uriBuilder.host(metadata.get("host"));
        uriBuilder.port(metadata.get("port"));
        uriBuilder.path(method.getPath());

        return uriBuilder.toUriString();
    }
}
