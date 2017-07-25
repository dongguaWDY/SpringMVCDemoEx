package com.donggua.webpackage;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Created by 冬瓜WDY on 2017/7/14.
 */
@Configuration
@EnableWebMvcSecurity
public class ConfClassForMvcSecurity extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("USER", "ADMIN");
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        org.springframework.security.core.context.SecurityContext
//        org.springframework.security.core.context.SecurityContextHolder
//        org.springframework.security.core.userdetails.UserDetails
//        http
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
                .authorizeRequests()
//                .antMatchers("/helloworld").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin();
//                .and()
//                .httpBasic();
        http.rememberMe().tokenValiditySeconds(300000000).key("we");

//        http.httpBasic();
//        http.httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.authorizeRequests()
//                .antMatchers("/helloworld").hasRole("ADMIN");//访问改路径下的用户必须拥有ADMIN角色
        //super.configure(http);

    }
}
