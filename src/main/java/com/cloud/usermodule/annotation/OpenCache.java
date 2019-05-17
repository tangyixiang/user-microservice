package com.cloud.usermodule.annotation;

import org.springframework.data.type.classreading.MethodsMetadataReader;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface OpenCache {

    Class<?> cls();

}


