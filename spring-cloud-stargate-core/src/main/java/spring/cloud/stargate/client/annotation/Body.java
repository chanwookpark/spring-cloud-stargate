package spring.cloud.stargate.client.annotation;

import java.lang.annotation.*;

/**
 * @author chanwook
 */
@Target(value = {ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface Body {
}
