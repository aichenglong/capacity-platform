package com.capacity.platform.security.MetadataSource;

import com.capacity.platform.system.entity.SysMenu;
import com.capacity.platform.system.service.SysMenuService;
import com.capacity.platform.system.service.SysRoleService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Author: ACL
 * Date:2017/8/14
 * Description:
 * Created by ACL on 2017/8/14.
 */
@Component
public class CustomSecurityContext {

    private SysMenuService service;

    private SysRoleService sysRoleService;


    @Autowired
    public void setService(SysMenuService service) {
        this.service = service;
    }

    @Autowired
    public void setSysRoleService(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    Map<String, Collection<ConfigAttribute>> getMetadataSource() {
        List<SysMenu> list =service.selectList(null);
        if(list == null || list.isEmpty()){
            return null;
        }
        Map<String, Collection<ConfigAttribute>>  map =  Maps.newLinkedHashMap();
        list.forEach(	r ->{
            Collection<ConfigAttribute> configAttributes = Lists.newLinkedList();
            //查询资源与角色的对应关系

            sysRoleService.findByMenuId(r.getId()).forEach(e->{
                ConfigAttribute configAttribute = new SecurityConfig(e.getRoleCode());
                configAttributes.add(configAttribute);
            });

            map.put(r.getHref(), configAttributes);

        });
        return map;
    }
}
