package com.capacity.platform.common.mapper;

import com.capacity.platform.common.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Author: ICL
 * Date:2018/5/19
 * Description:
 * Created by ICL on 2018/5/19.
 */
public interface BaseMapper<T extends BaseEntity, ID extends Serializable> {

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    void delete(ID id);

    List<T> findAll(T entity);

    T find(ID id);
}
