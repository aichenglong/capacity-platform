package com.capacity.platform.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;

/**
 * Author: icl
 * Date:2018/06/10
 * Description: 资源服务器
 * Created by icl on 2018/06/10.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration  extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "resource_id";


    /**
     * Add resource-server specific properties (like a resource id). The defaults should work for many applications, but
     * you might want to change at least the resource id.
     *
     * @param resources configurer for the resource server
     * @throws Exception if there is a problem
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    /**
     * Use this to configure the access rules for secure resources. By default all resources <i>not</i> in "/oauth/**"
     * are protected (but no specific rules about scopes are given, for instance). You also get an
     * {@link OAuth2WebSecurityExpressionHandler} by default.
     *
     * @param http the current http filter configuration
     * @throws Exception if there is a problem
     */

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                anonymous().disable()
                .authorizeRequests()
                .antMatchers("/users/**").access("hasRole('ADMIN')")
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }



}
