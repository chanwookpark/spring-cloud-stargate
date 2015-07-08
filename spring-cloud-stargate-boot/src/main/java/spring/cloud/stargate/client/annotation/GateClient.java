package spring.cloud.stargate.client.annotation;

import java.lang.annotation.*;

/**
 * @author chanwook
 */
@Target(value = {ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface GateClient {

    String value() default "";
}
