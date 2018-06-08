package com.capacity.platform.security.config;

import com.capacity.platform.security.handel.CustomAuthenticationFailureHandler;
import com.capacity.platform.security.handel.CustomAuthenticationSuccessHandler;
import com.capacity.platform.security.service.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Author: icl
 * Date:2018/06/02
 * Description:
 * Created by icl on 2018/06/02.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启security注解
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    public   static Logger log=LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;







    /**
     * Override this method to configure {@link WebSecurity}. For example, if you wish to
     * ignore certain requests.
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/plugins/**", "/**/*.js", "/**/*.css",  //
                "/**/*.png", "/**/*.jpg", "/**/*.ico",//
                "/**/*.gpeg", "/**/*.gif", "/**/*.woff2", //
                "/**/*.ttf", "/**/*.svg", "/**/*.woff", //
                "/**/*.eot"
        ).antMatchers("/druid/**"). antMatchers("/swagger-ui.html")
                .antMatchers("/webjars/**")
                .antMatchers("/v2/**")
                .antMatchers("/swagger-resources/**");
    }
    /**
     * Override this method to configure the {@link HttpSecurity}. Typically subclasses
     * should not invoke this method by calling super as it may override their
     * configuration. The default configuration is:
     * <p>
     * <pre>
     * http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
     * </pre>
     *
     * @param http the {@link HttpSecurity} to modify
     * @throws Exception if an error occurs
     */
    // @formatter:off
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionFixation().none();

        http.authorizeRequests()
                .antMatchers(new String("/find/**"),"/sys/**","/system/**")
                .permitAll()
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .and()
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/login?error")
//                .permitAll() //登录页面用户任意访问
//                .and()
                .logout().permitAll(); //注销行为任意访问


        http.authorizeRequests().
                antMatchers( "/js/**", "/css/**", "/bootstrap/**", "/img/**", "/static/**", "/h2/**")
                .permitAll().anyRequest().authenticated()
                .and().headers().frameOptions().disable() //headers
                .and() .formLogin().loginPage("/login").permitAll()  //login  configuration
                .defaultSuccessUrl("/index", true)
                .loginProcessingUrl("/login")
                .and().rememberMe().rememberMeParameter("remember-me").tokenValiditySeconds(86400)
                .and().csrf().disable();


    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        // authenticationProvider.setSaltSource(saltSource());
        return authenticationProvider;
    }

    /**
     * 设置用户密码的加密方式为BCrypt加密
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return  PasswordEncoderFactories.createDelegatingPasswordEncoder();

    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("admin"));

//       String value= String.valueOf(Hex.encode(new Pbkdf2PasswordEncoder("md5").encode("admin","admin".getBytes())));
//        System.out.println(value);

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        System.out.println(passwordEncoder.encode("admin"));


//    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    String encode = passwordEncoder.encode("password");
  log.info("加密后的密码:" + encode);
  log.info("bcrypt密码对比:" + passwordEncoder.matches("password", encode));
    String md5Password = "{MD5}88e2d8cd1e92fd5544c8621508cd706b";//MD5加密前的密码为:password
  log.info("MD5密码对比:" + passwordEncoder.matches("password", encode));
}

}
