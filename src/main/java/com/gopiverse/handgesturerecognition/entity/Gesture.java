package com.gopiverse.handgesturerecognition.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "gestures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gesture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gesture_name")
    private String gestureName;

    @Column(name = "detected_time")
    private LocalDateTime detectedTime;
}