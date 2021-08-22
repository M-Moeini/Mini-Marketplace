package com.mehdi.other.architecture.configuration;


import com.mehdi.other.architecture.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private DataSource dataSource;

//    @Autowired
//    private UserDetailService userDetailService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers( "/users/register", "/users/enableUser",
                        "/posts/enablePost", "/posts/allPosts", "/posts/register",
                        "/posts/all","/posts/myPosts","/users/getuser").permitAll();

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailService)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//        //  .usersByUsernameQuery("select email,password,enabled from users where email=?")
//        //  .authoritiesByUsernameQuery("select email,roles from authorities where email=?");
//    }
}


