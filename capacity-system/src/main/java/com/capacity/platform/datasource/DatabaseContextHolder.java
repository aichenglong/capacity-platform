package com.capacity.platform.datasource;

/**
 * Author: icl
 * Date:2018/06/02
 * Description: 保存一个线程安全的DatabaseType容器
 *          用于保存数据源类型
 * Created by icl on 2018/06/02.
 */
public class DatabaseContextHolder {

    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();

    public static void setDatabaseType(DatabaseType type) {
        contextHolder.set(type);
    }

    public static DatabaseType getDatabaseType() {
        return contextHolder.get();
    }
}
