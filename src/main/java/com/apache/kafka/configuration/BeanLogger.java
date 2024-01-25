package com.apache.kafka.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanLogger {

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void logBeans() {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        System.out.println("List of available beans in the application context:");

        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
