package com.github.example;

import com.github.example.service.HelloService;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Arvin
 */
@SpringBootApplication
public class AutoConfigApplication implements CommandLineRunner, ApplicationContextAware {

    public static void main(String[] args) {

        SpringApplication.run(AutoConfigApplication.class, args);

    }

    private ApplicationContext acx;

    @Override
    public void run(String... strings) throws Exception {

        HelloService helloService = acx.getBean(HelloService.class);

        System.out.println(helloService.sayHello("Arvin"));

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.acx = applicationContext;
    }
}
