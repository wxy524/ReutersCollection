package com.h2o.ai.reuterscollectionservices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.h2o.ai"})
public class ReutersCollectionServicesApplication {

    private static final Logger LOGGER = LogManager.getLogger(ReutersCollectionServicesApplication.class);

    public static void main(String[] args) {

        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("Service is starting");
        }
        SpringApplication.run(ReutersCollectionServicesApplication.class, args);

        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("Service is started");
        }
    }
}
