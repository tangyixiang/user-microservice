package com.cloud.usermodule.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheValue {
    String key() default "";
    String cache_object() default "return";
    String primarykey();
    RedisType redisType();

}
