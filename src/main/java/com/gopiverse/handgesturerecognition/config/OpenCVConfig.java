package com.gopiverse.handgesturerecognition.config;

import nu.pattern.OpenCV;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenCVConfig {

    @PostConstruct
    public void init() {
        OpenCV.loadLocally();
        System.out.println("OpenCV Loaded Successfully...");
    }
}