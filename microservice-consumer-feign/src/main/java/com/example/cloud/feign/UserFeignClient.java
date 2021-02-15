package com.example.cloud.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.Logger;

import com.example.cloud.entity.User;

@FeignClient(name="microservice-provider-user",configuration=UserFeignConfig.class)
public interface UserFeignClient {
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
    @RequestMapping(value="/post",method=RequestMethod.POST)
    public User post(@RequestBody User user);
}
class UserFeignConfig{
    @Bean
    public Logger.Level logger(){
        return Logger.Level.FULL;
    }
}