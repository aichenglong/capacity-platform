package com.capacity.platform.security.handel;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: ACL
 * Date:2017/8/13
 * Description:认证成功处理器
 * Created by ACL on 2017/8/13.
 */
@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
    /**
     * Called when a user has been successfully authenticated.
     *
     * @param request the request which caused the successful authentication
     * @param response the response
     * @param authentication the <tt>Authentication</tt> object which was created during
     * the authentication process.
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication
            authentication) throws IOException, ServletException {
        System.out.print("登录成功");

    }
}
