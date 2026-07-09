package com.gopiverse.handgesturerecognition.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GestureResponse {

    private Long id;
    private String gestureName;
    private LocalDateTime detectedTime;

}