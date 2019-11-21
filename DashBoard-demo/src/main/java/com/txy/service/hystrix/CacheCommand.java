package com.txy.service.hystrix;
/**
 * Project Name: parent-demo.
 * Package Name: com.txy.service.hystrix.
 * File Name: CacheCommand
 * Copyright (c) 2019, 南京天芯云数据服务有限公司.
 */

import com.netflix.hystrix.*;
import org.springframework.web.client.RestTemplate;

/**
 *
 * Class Name: CacheCommand
 * FQDN：com.txy.service.hystrix.CacheCommand
 * Author: 阿辉
 * Date: 2019/11/19 11:53
 * Description:
 *
 */
public class CacheCommand extends HystrixCommand<String>   {

    private long id ;
    private RestTemplate restTemplate;

    public CacheCommand(long id , RestTemplate restTemplate){
        super( Setter.withGroupKey(
                HystrixCommandGroupKey.Factory.asKey( "cache-group" ))
                .andCommandKey( HystrixCommandKey.Factory.asKey( "cache-pool"  ))
    );

        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected String run() throws Exception {
        String url =  "http://txy-user/user/{id}";

        String info = restTemplate.getForObject(url, String.class, id);   //请求，返回一个string 对象

        return info;
    }
}
