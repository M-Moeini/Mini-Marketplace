package com.Mehdi.SheypoorApp.config;

import com.Mehdi.SheypoorApp.modules.architecture.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private JWTEntryPoint jwtEntryPoint;

    @Autowired
    private JWTRequestFilter jwtRequestFilter;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
               //  .usersByUsernameQuery("select email,password,enabled from users where email=?")
              //  .authoritiesByUsernameQuery("select email,roles from authorities where email=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
                 http.csrf().disable()
                .authorizeRequests().antMatchers("/index","/users/register","/users/otpGen","/users/getuser","/authenticate","/otp/get","/otp/send").permitAll()
                .antMatchers("/users","/users/enableUser","/posts/allPosts","/posts/enablePost").hasAuthority("ADMIN")
                         .antMatchers("/posts/all","/posts/myPosts").hasAuthority("USER")
                .anyRequest().authenticated()
                         .and()
                         .exceptionHandling().authenticationEntryPoint(jwtEntryPoint).and().
                         sessionManagement()
                         .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

                 http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
                         //.and().logout().permitAll();
//                .and().exceptionHandling().accessDeniedPage("/403");

        }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
