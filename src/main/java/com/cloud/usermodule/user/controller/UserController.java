package com.cloud.usermodule.user.controller;

import com.cloud.usermodule.user.model.User;
import com.cloud.usermodule.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(HttpServletRequest request){

        return "success";
    }


    public void add(){

    }

    @GetMapping("/user/find/{id}")
    public User find(@PathVariable String id){
        return userService.find(id,"123","ccc");
    }



    public void delete(){

    }

    public void update(){

    }

}
