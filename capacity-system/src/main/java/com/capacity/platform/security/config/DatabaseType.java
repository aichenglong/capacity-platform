package com.capacity.platform.security.config;


/**
 * Author: icl
 * Date:2018/06/02
 * Description: 列出数据源类型
 * Created by icl on 2018/06/02.
 */
public enum DatabaseType {
    master("write"), slave("read");


    DatabaseType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DatabaseType{" +
                "name='" + name + '\'' +
                '}';
    }
}
