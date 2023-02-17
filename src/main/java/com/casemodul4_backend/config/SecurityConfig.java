package com.casemodul4_backend.config;

import com.casemodul4_backend.config.filter.JwtAuthenticationFilter;
import com.casemodul4_backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AccountService accountService;

    //Tạo Bean cho đối tượng quản lý việc xác thực
    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    // Phân quyền
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/**");


        http.authorizeRequests().antMatchers("/login", "/register","/accounts/**,/**","**/admin").permitAll(); //Phân quyền cho phép các đường dẫn trên được truy cập
//                .anyRequest().authenticated() //Còn lại các request khác đều phải xác thực
//                .and().csrf().disable(); //Đóng cửa cho tất cả các request còn lại (Tại đây nếu ta ".formLogin()" thì nó sẽ hiện form đăng nhập của hệ thống)
//        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) //Đính filter
//                .exceptionHandling();
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); //Session sẽ không được lưu
        http.cors();

    }

    // Xác thực
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountService).passwordEncoder(NoOpPasswordEncoder.getInstance());

    }
}
