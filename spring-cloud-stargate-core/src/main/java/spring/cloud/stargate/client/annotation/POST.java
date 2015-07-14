package spring.cloud.stargate.client.annotation;

import java.lang.annotation.*;

/**
 * @author chanwook
 */
@Target(value = {ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface POST {

    String path();

    String produces();
}
