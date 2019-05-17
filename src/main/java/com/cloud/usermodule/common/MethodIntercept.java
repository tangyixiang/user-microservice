package com.cloud.usermodule.common;

import com.cloud.usermodule.annotation.CacheValue;
import com.cloud.usermodule.annotation.RedisType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@Aspect
public class MethodIntercept {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(* com.cloud.usermodule.user.service..*.*(..))")
    public void intercept(){

    }


    //进入方法前查询缓存
    @Before("intercept()&&@annotation(com.cloud.usermodule.annotation.CacheValue)")
    public Object before(JoinPoint joinPoint){

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature;
        String[] paramsName = methodSignature.getParameterNames();
        Method method = methodSignature.getMethod();
        CacheValue cacheValue = null;
        if(method != null){
            cacheValue = method.getAnnotation(CacheValue.class);
            //key的前缀
            String prefix = cacheValue.key();
            //唯一标识变量
            String primaryKey = cacheValue.primarykey();
            //redis 存放类型
            RedisType redisType = cacheValue.redisType();
            //返回primarykey在数组中的index
            int paramIndex = Arrays.binarySearch(paramsName,primaryKey);
            Object[] args = joinPoint.getArgs();
            String key_indentity = args[paramIndex].toString();
            String key = prefix+"."+key_indentity;

            String redis_value = getRedisValue(key);
            if(redis_value != null){
                return redis_value;
            }
        }
        return null;
    }


    private String getRedisValue(String key){
        return redisTemplate.opsForValue().get(key);
    }

}
