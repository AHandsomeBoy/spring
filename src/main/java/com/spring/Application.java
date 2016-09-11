package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.spring")
@EnableScheduling
public class Application {
	
	@Autowired
	private Environment env;
	
	public static void main(String[] args) {
    	SpringApplication application=new SpringApplication(Application.class);
        application.addListeners(new ApplicationStartUpListener());
        application.run(args);
        System.out.println(PropertyUtil.getProperty("key"));
    }
	
}