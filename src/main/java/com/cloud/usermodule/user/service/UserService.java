package com.cloud.usermodule.user.service;


import com.cloud.usermodule.annotation.CacheValue;
import com.cloud.usermodule.annotation.OpenCache;
import com.cloud.usermodule.annotation.RedisType;
import com.cloud.usermodule.user.dao.UserDao;
import com.cloud.usermodule.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


@Service
@OpenCache(cls = User.class)
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void add(){


    }

    @CacheValue(key="user",primarykey="id",redisType = RedisType.STRING)
    public User find(String id,String name,String cc){
       User user = userDao.find(id);
       return user;
    }

    public void delete(){

    }

    public void update(){

    }


}
