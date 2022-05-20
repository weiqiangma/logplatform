package com.mawkun.logplatform.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogRecord {
    String success();
    String fail() default "";
    String context() default "";
    String operator() default "";
    String bizNo() default "";
    String category() default "";
    String detail() default "";
    String condition() default "";
}
