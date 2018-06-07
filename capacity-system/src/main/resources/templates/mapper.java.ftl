package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};

/**
* Author: ${author}
* Date:${date}
* Description: ${table.comment} Mapper 接口
* Created by ${author} on ${date}.
*/
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

}
</#if>
