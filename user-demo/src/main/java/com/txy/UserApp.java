package com.txy;
/**
 * Project Name: parent-demo.
 * Package Name: com.txy.
 * File Name: UserApp
 * Copyright (c) 2019, 南京天芯云数据服务有限公司.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 *
 * Class Name: UserApp
 * FQDN：com.txy.UserApp
 * Author: 阿辉
 * Date: 2019/11/13 15:17
 * Description:
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class UserApp {
    public static void main(String[] args) {

        SpringApplication.run(UserApp.class,args);
    }
}
