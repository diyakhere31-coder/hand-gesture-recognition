package com.gopiverse.handgesturerecognition.service;

import com.gopiverse.handgesturerecognition.entity.Gesture;
import com.gopiverse.handgesturerecognition.exception.ResourceNotFoundException;
import com.gopiverse.handgesturerecognition.repository.GestureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GestureService {

    private final GestureRepository repository;

    public Gesture saveGesture(String name) {

        Gesture gesture = Gesture.builder()
                .gestureName(name)
                .detectedTime(LocalDateTime.now())
                .build();

        return repository.save(gesture);
    }

    public List<Gesture> getAllGestures() {
        return repository.findAll();
    }

    public void deleteGesture(Long id) {

        Gesture gesture = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gesture Not Found"));

        repository.delete(gesture);
    }

    public long countGesture(String gestureName) {
        return repository.countByGestureName(gestureName);
    }
    public Gesture getLatestGesture() {

        return repository.findTopByOrderByDetectedTimeDesc()
                .orElseThrow(() -> new ResourceNotFoundException("No Gesture Found"));

    }
}