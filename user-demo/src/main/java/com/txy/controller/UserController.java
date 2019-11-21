package com.txy.controller;
/**
 * Project Name: parent-demo.
 * Package Name: com.txy.controller.
 * File Name: UserController
 * Copyright (c) 2019, 南京天芯云数据服务有限公司.
 */

import com.txy.entity.User;
import org.bouncycastle.asn1.dvcs.TargetEtcChain;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequest;
import org.springframework.cloud.client.loadbalancer.ServiceInstanceChooser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 *
 * Class Name: UserController
 * FQDN：com.txy.controller.UserController
 * Author: 阿辉
 * Date: 2019/11/13 15:19
 * Description:
 *
 */

@Controller
public class UserController {

    @Value( "${server.port}" )
    int port;


    @GetMapping("/user/{id}")
    @ResponseBody
    public int getUser(@PathVariable("id") int id){
        if (id == 1){
            return 1;
        }else if (id == 2){
            return port;
        }else {
            return  port ;
        }
    }


    @GetMapping("/wlh")
    @ResponseBody
    public String getName(){
        return "猪";
    }


    @GetMapping("/hat")
    @ResponseBody
    public String getHatName(@RequestParam("id") int id){
        if(id == 1){
            return  "long";
        }else{
            return  "caihong";
        }
    }

    @PostMapping("/user2")
    @ResponseBody
    public  String  addUser(User user){
        return user.getName();
    }

    @PostMapping("/user3")
    @ResponseBody
    public String addUser1(@RequestParam("name") String name){
        return  "hello" + name;
    }

}
