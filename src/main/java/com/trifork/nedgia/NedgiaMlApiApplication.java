package com.trifork.nedgia;

import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

import static org.springframework.boot.SpringApplication.run;


@EnableFeignClients
@EnableCaching
@EnableAsync
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})
public class NedgiaMlApiApplication {
    public static void main(String[] args) {
        System.out.println("Hello from Nedgia World 3!!!!");
        run(NedgiaMlApiApplication.class, args);
    }
}