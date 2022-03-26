package com.example.xbc1913041334library.config;

import com.example.xbc1913041334library.xbc1913041334interceptor.loginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( new loginInterceptor())
                .addPathPatterns( "/**" ).excludePathPatterns("/","/admin/login","/static/**","/static/easyui/**","/easyui/**","/css/**","/fonts/**","/images/**", "/lib/**","/js/**","/pic/**");
    }
    //自定义静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler( "/pic/**" )
                .addResourceLocations( "file:D:/photo/" );
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

}
