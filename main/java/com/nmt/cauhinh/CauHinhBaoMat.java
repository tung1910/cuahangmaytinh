/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.cauhinh;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nmt.cauhinh.xuly.TrinhXuLySauDangNhap;
import com.nmt.cauhinh.xuly.TrinhXuLySauDangXuat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author hp
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.nmt.kho",
    "com.nmt.dichvu"
})
public class CauHinhBaoMat extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private AuthenticationSuccessHandler trinhXuLySauDangNhap;
    
    @Autowired
    private LogoutSuccessHandler trinhXuLySauDangXuat;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public Cloudinary cloudinary(){
        Cloudinary c = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "ddrev0shv",
                "api_key", "778684834614553",
                "api_secret", "NT5vrwJn0SsIMYBi-a-pxRCg9-g",
                "secure", true));
        
        return c;
    }
    
    @Bean
    public AuthenticationSuccessHandler trinhXuLySauDangNhap(){
        return  new TrinhXuLySauDangNhap();
    }
    
    @Bean
    public LogoutSuccessHandler trinhXuLySauDangXuat(){
        return  new TrinhXuLySauDangXuat();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/dangnhap").usernameParameter("tenDN").passwordParameter("matKhau");
        
        http.formLogin().defaultSuccessUrl("/").failureUrl("/dangnhap?error");
        http.formLogin().successHandler(this.trinhXuLySauDangNhap);
        
//        http.logout().logoutSuccessUrl("/dangnhap");
        http.logout().logoutSuccessHandler(this.trinhXuLySauDangXuat);
        
        http.exceptionHandling().accessDeniedPage("/dangnhap?accessDenied");
        
        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
        
        http.csrf().disable();
    }
    
    
}
