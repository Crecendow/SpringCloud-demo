package com.txy.service;
/**
 * Project Name: parent-demo.
 * Package Name: com.txy.service.
 * File Name: MyFallback
 * Copyright (c) 2019, 南京天芯云数据服务有限公司.
 */

import com.txy.entity.User;
import org.springframework.stereotype.Component;

/**
 *
 * Class Name: MyFallback
 * FQDN：com.txy.service.MyFallback
 * Author: 阿辉
 * Date: 2019/11/18 14:55
 * Description:
 *
 */
@Component
public class MyFallback implements  FeignService {
    @Override
    public String getUser(int id) {
        return "error GetUSER";
    }

    @Override
    public String addUser(User user) {
        return "error getUSER2";
    }

    @Override
    public String addUser1(String name) {
        return "error getUSER3";
    }
}
