package com.jaden.dream.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodInfo {
    String author() default "Unknown";
    String version() default "1.0";
}
