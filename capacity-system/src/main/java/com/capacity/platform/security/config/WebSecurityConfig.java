package com.capacity.platform.security.config;

import com.capacity.platform.security.interceptor.CustomFilterSecurityInterceptor;
import com.capacity.platform.security.service.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Author: icl
 * Date:2018/06/02
 * Description: 权限配置
 * Created by icl on 2018/06/02.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    public   static Logger log=LoggerFactory.getLogger(WebSecurityConfig.class);

//    @Autowired
//    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

//
//    @Autowired
//    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

//
//    @Autowired
//    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

//    @Autowired
//    private RedisConnectionFactory redisConnection;
//


    @Autowired
    private CustomFilterSecurityInterceptor customFilterSecurityInterceptor;

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
        http.csrf().disable().authorizeRequests().
                antMatchers( "/js/**", "/css/**", "/bootstrap/**", "/img/**", "/static/**", "/h2/**")
                .permitAll().anyRequest().authenticated()
                .and().headers().frameOptions().disable() //headers
                .and() .formLogin().loginPage("/login").permitAll()  //login  configuration
                .defaultSuccessUrl("/index", true)
                .loginProcessingUrl("/login")
                .and().rememberMe().rememberMeParameter("remember-me").tokenValiditySeconds(86400)
                .and().csrf().disable();


//        http.addFilterBefore(customFilterSecurityInterceptor,FilterSecurityInterceptor.class);


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    //配置全局设置
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //设置UserDetailsService以及密码规则
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
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


    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }
   /* @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnection);
    }
*/

    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
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
