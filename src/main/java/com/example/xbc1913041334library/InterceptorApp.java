package com.example.xbc1913041334library;

import com.example.xbc1913041334library.xbc1913041334interceptor.Interceptor1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@SpringBootApplication(scanBasePackages ="com.example.xbc1913041334library")
public class InterceptorApp implements WebMvcConfigurer{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(InterceptorApp.class, args);
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		InterceptorRegistration ir=registry.addInterceptor(new Interceptor1());
	    ir.addPathPatterns("/interceptor/**");


	}

}
