package com.gopiverse.handgesturerecognition.controller;

import com.gopiverse.handgesturerecognition.response.ApiResponse;
import com.gopiverse.handgesturerecognition.service.GestureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gesture")
@RequiredArgsConstructor
public class GestureController {

    private final GestureService gestureService;

    // Save Gesture
    @PostMapping("/{name}")
    public ApiResponse save(@PathVariable String name) {

        return ApiResponse.builder()
                .success(true)
                .message("Gesture Saved Successfully")
                .data(gestureService.saveGesture(name))
                .build();
    }

    // Get All Gestures
    @GetMapping
    public ApiResponse getAll() {

        return ApiResponse.builder()
                .success(true)
                .message("Gesture List")
                .data(gestureService.getAllGestures())
                .build();
    }

    // Delete Gesture
    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Long id) {

        gestureService.deleteGesture(id);

        return ApiResponse.builder()
                .success(true)
                .message("Gesture Deleted Successfully")
                .data(null)
                .build();
    }
    @GetMapping("/count/{name}")
    public ApiResponse count(@PathVariable String name) {

        return ApiResponse.builder()
                .success(true)
                .message("Gesture Count")
                .data(gestureService.countGesture(name))
                .build();
    }

    @GetMapping("/latest")
    public ApiResponse latest() {

        return ApiResponse.builder()
                .success(true)
                .message("Latest Gesture")
                .data(gestureService.getLatestGesture())
                .build();
    }

}