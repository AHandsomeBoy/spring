package com.spring;


import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

public class ApplicationStartUpListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
    	//System.out.println(new File("file:./../../../config/application.properties").exists());;
        System.out.println(new FileSystemResource("./config/mongo.properties").getPath());;
    	
    	PropertyUtil.loadAllProperties("./config/application.properties");
        System.out.println("ApplicationStartUpListener EXEC");
    }
}