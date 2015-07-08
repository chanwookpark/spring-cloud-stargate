package spring.cloud.stargate.client.annotation;

import spring.cloud.stargate.client.MediaType;

import java.lang.annotation.*;

/**
 * @author chanwook
 */
@Target(value = {ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface GET {

    String path();

    MediaType consumes();
}
