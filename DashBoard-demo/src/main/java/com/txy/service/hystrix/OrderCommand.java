package com.txy.service.hystrix;
/**
 * Project Name: parent-demo.
 * Package Name: com.txy.service.hystrix.
 * File Name: OrderCommand
 * Copyright (c) 2019, 南京天芯云数据服务有限公司.
 */

import com.netflix.hystrix.*;

/**
 *
 * Class Name: OrderCommand
 * FQDN：com.txy.service.hystrix.OrderCommand
 * Author: 阿辉
 * Date: 2019/11/19 8:34
 * Description:
 *
 */
public class OrderCommand extends HystrixCommand<String> {

    private String value;

    public  OrderCommand(String value) {
        super( Setter.withGroupKey(
                HystrixCommandGroupKey.Factory.asKey( "OrderGroup" ))
                .andThreadPoolKey( HystrixThreadPoolKey.Factory.asKey( "OrderPool" ) )
                .andThreadPoolPropertiesDefaults( HystrixThreadPoolProperties.Setter()
                        .withCoreSize( 10 )
                        .withKeepAliveTimeMinutes( 5 )
                        .withMaxQueueSize( 10 )
                        .withQueueSizeRejectionThreshold( 1000 ) )
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                                .withExecutionIsolationStrategy( HystrixCommandProperties.ExecutionIsolationStrategy.THREAD ) ) );

        this.value = value;
    }

    @Override
    protected String run() throws Exception {
        String threadName = Thread.currentThread().getName();
        return threadName  + "||" + value;
    }
}
