package com.txy.service;
/**
 * Project Name: parent-demo.
 * Package Name: com.txy.service.
 * File Name: FeignService
 * Copyright (c) 2019, 南京天芯云数据服务有限公司.
 */

import com.txy.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 *
 * Class Name: FeignService
 * FQDN：com.txy.service.FeignService
 * Author: 阿辉
 * Date: 2019/11/14 15:33
 * Description:
 *
 */
@FeignClient(value = "txy-user" , fallback = MyFallback.class)
public interface FeignService {

    @GetMapping("/user/{id}")
    String getUser(@PathVariable("id") int id);


    @PostMapping("/user2")
    String addUser(User user);


    @PostMapping("/user3")
    String addUser1(String name);
}
