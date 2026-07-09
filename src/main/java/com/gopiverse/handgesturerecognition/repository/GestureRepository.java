package com.gopiverse.handgesturerecognition.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import com.gopiverse.handgesturerecognition.entity.Gesture;
import org.springframework.stereotype.Repository;

@Repository
public interface GestureRepository extends JpaRepository<Gesture, Long> {

    long countByGestureName(String gestureName);
    Optional<Gesture> findTopByOrderByDetectedTimeDesc();

}