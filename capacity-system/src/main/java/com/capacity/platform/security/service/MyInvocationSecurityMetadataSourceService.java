package com.capacity.platform.security.service;

import com.capacity.platform.system.entity.SysMenu;
import com.capacity.platform.system.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Author: icl
 * Date:2018/06/02
 * Description:
 * Created by icl on 2018/06/02.
 */
@Service
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    private HashMap<String, Collection<ConfigAttribute>> map =null;

    /**
     * 加载资源，初始化资源变量
     */
    public void loadResourceDefine(){
        map = new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        List<SysMenu> sysMenuList = sysMenuMapper.selectList(null);
        for(SysMenu menu : sysMenuList){
            array = new ArrayList<>();
            cfg = new SecurityConfig(menu.getName());
            array.add(cfg);
            map.put(menu.getHref(), array);
        }

    }


    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if(map ==null) loadResourceDefine();
        HttpServletRequest request = ((FilterInvocation) o).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for(Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
            resUrl = iter.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if(matcher.matches(request)) {
                return map.get(resUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
