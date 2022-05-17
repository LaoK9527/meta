package com.javastroger.demo;

import com.javastroger.demo.controller.RestController;
import com.javastroger.demo.service.PaymentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 老K
 */
@SpringBootApplication
public class MyPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyPlusApplication.class, args);
    }

}
