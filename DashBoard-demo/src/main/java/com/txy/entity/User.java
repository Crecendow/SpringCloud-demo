package com.txy.entity;
/**
 * Project Name: parent-demo.
 * Package Name: com.txy.entity.
 * File Name: User
 * Copyright (c) 2019, 南京天芯云数据服务有限公司.
 */

/**
 *
 * Class Name: User
 * FQDN：com.txy.entity.User
 * Author: 阿辉
 * Date: 2019/11/14 16:10
 * Description:
 *
 */
public class User {

    private int id ;
    private String name ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
