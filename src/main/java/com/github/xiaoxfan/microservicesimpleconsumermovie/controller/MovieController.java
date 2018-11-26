package com.github.xiaoxfan.microservicesimpleconsumermovie.controller;

import com.github.xiaoxfan.microservicesimpleconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaofan
 * @date 2018/11/26 14:06
 */
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        //调用用户的service接口
        return this.restTemplate.getForObject("http://127.0.0.1:7900/simple/" + id, User.class);
    }
}
