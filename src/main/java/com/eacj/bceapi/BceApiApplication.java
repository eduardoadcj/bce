package com.eacj.bceapi;

import com.eacj.bceapi.core.dataloader.DataLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class BceApiApplication {

    @Autowired
    DataLoaderService dataLoaderService;
    
    public static void main(String[] args) {
        SpringApplication.run(BceApiApplication.class, args);
    }
    
    @EventListener(ApplicationReadyEvent.class)
    public void onAfterStartup(){
        dataLoaderService.start();
    }

}
