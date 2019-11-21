package com.txy.service;
/**
 * Project Name: parent-demo.
 * Package Name: com.txy.service.
 * File Name: OrderService
 * Copyright (c) 2019, 南京天芯云数据服务有限公司.
 */

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.txy.service.hystrix.OrderCommand;
import com.txy.service.hystrix.Usercommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

/**
 *
 * Class Name: OrderService
 * FQDN：com.txy.service.OrderService
 * Author: 阿辉
 * Date: 2019/11/13 16:47
 * Description:
 *
 */

@Service
public class OrderService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "userFallBack")
    public String getUser(Integer id){
        String url =  "http://txy-user/user/{id}";

        String info = restTemplate.getForObject(url, String.class, id);   //请求，返回一个string 对象

        return info;
    }

    //添加服务器降级处理方法
    public String userFallBack(Integer id){
        return "Error OrderService  FallBack";
    }

    //测试依赖隔离
    public String testPool(){
        Usercommand usercommand = new Usercommand("鲁智深");
        OrderCommand orderCommand = new OrderCommand("钉耙");
        OrderCommand orderCommand1 = new OrderCommand("树");

        //同步调用
//        String val1 = usercommand.execute();
//        String val2 = orderCommand.execute();
//        String val3 = orderCommand1.execute();

        //异步调用
        Future<String> f1 = usercommand.queue();
        Future<String> f2 = orderCommand.queue();
        Future<String> f3 = orderCommand1.queue();


//        return  "同步调用："+"val1:" + val1 + "   val2:" + val2 + "   val3:" + val3   ;
        return   "     异步调用："+"f1:" + f1 + "   f2:" + f2 + "   f3:" +f3;

    }
}
