package com.txy.controller;
/**
 * Project Name: parent-demo.
 * Package Name: com.txy.controller.
 * File Name: OrderController
 * Copyright (c) 2019, 南京天芯云数据服务有限公司.
 */

import com.txy.entity.User;
import com.txy.service.FeignService;
import com.txy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * Class Name: OrderController
 * FQDN：com.txy.controller.OrderController
 * Author: 阿辉
 * Date: 2019/11/13 16:37
 * Description:
 *
 */
@Controller

public class OrderController {


    @Autowired
    OrderService orderService;

    @Autowired
    FeignService feignService;


    @GetMapping("/order")
    @ResponseBody
    public String  addOrder(String name , Integer id){
        String result = orderService.getUser(1);
        return  "商品:"+ name+";"+ "生成订单：" + result;
    }

    @GetMapping("/order2")
    @ResponseBody
    public String  addOrder2(String name , int id){
        String result = feignService.getUser(1);
        return  "商品:"+ name+";"+ "生成订单：" + result;
    }


    @PostMapping ("/order3")
    @ResponseBody
    public String addOrder3(){
        User user1 = new User();
        String name = "Rookie";
        user1.setId( 1 );
        user1.setName( "青青草原" );
        String result = feignService.addUser( user1 );

        String result1 = feignService.addUser1( name );
        return result;
    }


    @GetMapping("/pool")
    @ResponseBody
    public String getPool(){
        return orderService.testPool();
    }
}
