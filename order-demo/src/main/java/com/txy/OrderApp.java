package com.txy;
/**
 * Project Name: parent-demo.
 * Package Name: com.txy.
 * File Name: OrderApp
 * Copyright (c) 2019, 南京天芯云数据服务有限公司.
 */

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * Class Name: OrderApp
 * FQDN：com.txy.OrderApp
 * Author: 阿辉
 * Date: 2019/11/13 16:31
 * Description:
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard


public class OrderApp {
    public static void main(String[] args) {
         SpringApplication.run(OrderApp.class,args);
    }


    /***
     * REST风格.由springboot提供，简化服务调用的过程
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate(  );
    }

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
