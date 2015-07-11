package spring.cloud.stargate.client.annotation;

import java.lang.annotation.*;

/**
 * @author chanwook
 */
@Target(value = {ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface GET {

    String path();

    String consumes();
}
