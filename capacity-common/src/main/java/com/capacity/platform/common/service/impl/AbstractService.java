package com.capacity.platform.common.service.impl;


import com.capacity.platform.common.entity.BaseEntity;
import com.capacity.platform.common.mapper.BaseMapper;
import com.capacity.platform.common.service.BaseService;

import java.io.Serializable;
import java.util.List;

/**
 * Author: ICL
 * Date:2018/5/19
 * Description:
 * Created by ICL on 2018/5/19.
 */
public  abstract  class AbstractService<T extends BaseEntity,ID extends Serializable> implements BaseService<T,ID> {


}
