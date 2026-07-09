package com.gopiverse.handgesturerecognition;

import com.gopiverse.handgesturerecognition.opencv.HandGestureDetector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HandGestureRecognitionApplication implements CommandLineRunner {

    @Autowired
    private HandGestureDetector detector;

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        SpringApplication.run(HandGestureRecognitionApplication.class, args);
    }

    @Override
    public void run(String... args) {
        detector.startCamera();
    }
}