package com.h2o.ai.reuterscollectionservices.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping(value = "healthcheck")
    public String healthCheck() {
        return "ReutersCollection Services server is up and running";
    }
}
