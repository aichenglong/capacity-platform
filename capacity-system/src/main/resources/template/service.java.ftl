package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
* Author: ${author}
* Date:${date}
* Description: ${table.comment} 服务类
* Created by ${author} on${date}.
*/
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

}
</#if>
