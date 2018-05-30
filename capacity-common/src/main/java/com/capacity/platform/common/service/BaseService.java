package com.capacity.platform.common.service;

import java.io.Serializable;
import java.util.List;

/**
 * Author: ICL
 * Date:2018/5/19
 * Description:
 * Created by ICL on 2018/5/19.
 */
public interface BaseService<T,ID  extends Serializable> {

    void save(T entity);

    void update(T entity);


    void delete(T entity);

    void delete(Iterable<T> entitys);

    void  delete(ID[] ids);

    void delete(ID id);

    List<T> findAll(T entity);

    T find(ID id);
}
