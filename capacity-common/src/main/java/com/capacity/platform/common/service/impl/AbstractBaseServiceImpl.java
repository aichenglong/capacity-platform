package com.capacity.platform.common.service.impl;

import com.capacity.platform.common.entity.BaseEntity;
import com.capacity.platform.common.mapper.BaseMapper;
import com.capacity.platform.common.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public abstract  class AbstractBaseServiceImpl<T extends BaseEntity, ID extends Serializable> implements
        BaseService<T, ID> {

    public abstract BaseMapper<T, ID> getBaseMapper();


    @Override
    public void save(T entity) {
        getBaseMapper().save(entity);

    }

    @Override
    public void update(T entity) {
        getBaseMapper().update(entity);
    }

    @Override
    public void delete(T entity) {
        getBaseMapper().delete(entity);
    }

    @Override
    public void delete(Iterable<T> entitys) {
        entitys.forEach(e->{
            getBaseMapper().delete(e);
        });

    }

    @Override
    public void delete(ID[] ids) {
        for (ID id:ids){
            getBaseMapper().delete(id);
        }
    }

    @Override
    public void delete(ID id) {
        getBaseMapper().delete(id);
    }

    @Override
    public List<T> findAll(T entity) {
        return getBaseMapper().findAll(entity);
    }

    @Override
    public T find(ID id) {
        return getBaseMapper().find(id);
    }
}