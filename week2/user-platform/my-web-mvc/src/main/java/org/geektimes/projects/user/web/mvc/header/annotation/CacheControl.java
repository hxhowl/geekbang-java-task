package org.geektimes.projects.user.web.mvc.header.annotation;

import java.lang.annotation.*;

/**
 * @author hxhowl
 * @since 2021/3/10
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheControl {

    String[] value() default {};
}
