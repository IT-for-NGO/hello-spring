package com.henri.hellospring;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
//import org.springframework.boot.SpringApplication;

//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//@SpringBootApplication
//@EnableScheduling
@SpringBootApplication
public class Main {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        BasicConfigurator.configure();
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
        SpringApplication.run(Main.class, args);
    }
}