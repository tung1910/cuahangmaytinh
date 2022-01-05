/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.cauhinh;

import com.nmt.dinhdang.DinhDangLoaiHang;
//import com.nmt.xacnhan.TrinhXacThucSanPham;
//import com.nmt.xacnhan.TrinhXacThucUngDungWeb;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author hp
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.nmt.dieukhien",
                               "com.nmt.kho",
                               "com.nmt.dichvu",
                               "com.nmt.dinhdang",
                               "com.nmt.tienich"
})
public class CauHinhNguCanhUngDungWeb implements WebMvcConfigurer{

    @Override
    public void configureDefaultServletHandling(
     DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/resources/css/");
        registry.addResourceHandler("/img/**")
                .addResourceLocations("/resources/images/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("/resources/js/");
    }   
    
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver(){
        InternalResourceViewResolver resoure = new InternalResourceViewResolver();
            
            resoure.setViewClass(JstlView.class);
            resoure.setPrefix("/WEB-INF/jsp/");
            resoure.setSuffix(".jsp");
        
            return resoure;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DinhDangLoaiHang());
    }
        
//    @Bean
//    public TrinhXacThucUngDungWeb trinhXacThucSanPham(){
//        Set<Validator> springValidators = new HashSet<>();
//        springValidators.add(new TrinhXacThucSanPham());
//        
//        TrinhXacThucUngDungWeb v = new TrinhXacThucUngDungWeb();
//        v.setSpringValidators(springValidators);
//        
//        return v;
//    }
    
    @Bean
    public LocalValidatorFactoryBean validator(){
        LocalValidatorFactoryBean v = new LocalValidatorFactoryBean();
        v.setValidationMessageSource(messageSource());
        
        return v;
    }
    
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("thongbao");
        
        return source;
    }
    
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        
        return resolver;
    }
}
