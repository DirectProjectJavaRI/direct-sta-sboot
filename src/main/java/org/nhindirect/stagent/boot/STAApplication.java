package org.nhindirect.stagent.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"org.nhindirect.gateway.springconfig", "org.nhindirect.gateway.streams"})
@SpringBootApplication
@Configuration
@EnableEurekaClient
public class STAApplication
{
    public static void main(String[] args) 
    {
        SpringApplication.run(STAApplication.class, args);
    }  
}
