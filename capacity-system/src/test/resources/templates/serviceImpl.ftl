package ${basePackage}.${model}.service.impl;

import com.capacity.platform.common.mapper.BaseMapper;
import com.capacity.platform.common.service.impl.AbstractBaseServiceImpl;
import ${basePackage}.${model}.entity.${modelNameUpperCamel};
import ${basePackage}.${model}.mapper.${modelNameUpperCamel}Mapper;
import ${basePackage}.${model}.service.${modelNameUpperCamel}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Author: ${author}
 * Date:${date}
 * Description: $!{table.comment} 服务实现类
 * Created ${author}  on ${date}.
 */
@Service("${modelNamelowerCamel}Service")
public class ${modelNameUpperCamel}ServiceImpl extends AbstractBaseServiceImpl<${modelNameUpperCamel},${id}> implements
${modelNameUpperCamel}Service  {

    @Autowired
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

    @Override
    public BaseMapper<${modelNameUpperCamel}, ${id}> getBaseMapper() {
        return ${modelNameLowerCamel}Mapper;
    }
}
