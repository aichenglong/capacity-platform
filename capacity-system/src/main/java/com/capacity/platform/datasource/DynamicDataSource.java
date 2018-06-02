package com.capacity.platform.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Author: icl
 * Date:2018/06/02
 * Description: 使用DatabaseContextHolder获取当前线程的DatabaseType
 * Created by icl on 2018/06/02.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    static final Map<DatabaseType, List<String>> METHOD_TYPE_MAP = new HashMap<>();


    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        DatabaseType type = DatabaseContextHolder.getDatabaseType();
        logger.info("====================dataSource ==========" + type);
        return type;
    }

    void setMethodType(DatabaseType type, String content) {
        List<String> list = Arrays.asList(content.split(","));
        METHOD_TYPE_MAP.put(type, list);
    }
}
