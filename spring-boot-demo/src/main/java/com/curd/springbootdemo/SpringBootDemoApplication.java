package com.curd.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        System.out.println("Before Start " + Calendar.getInstance());
        SpringApplication.run(SpringBootDemoApplication.class, args);
        System.out.println("After Start " + Calendar.getInstance().getTimeZone());
    }

}
