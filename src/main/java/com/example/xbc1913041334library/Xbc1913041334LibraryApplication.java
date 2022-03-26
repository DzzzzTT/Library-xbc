package com.example.xbc1913041334library;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@MapperScan("com.example.xbc1913041334library.xbc1913041334Dao")
@SpringBootApplication
public class Xbc1913041334LibraryApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run =SpringApplication.run(Xbc1913041334LibraryApplication.class, args);

       /* //打印所有组件名称
        String[] names= run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }*/
    }

}
