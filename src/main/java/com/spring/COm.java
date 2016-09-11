package com.spring;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class COm {
	
	@Value("${key}") private String key;

	@Scheduled(fixedRate=1000)
	public void print(){
	    System.out.println("sd"+key);
	}

	
}
