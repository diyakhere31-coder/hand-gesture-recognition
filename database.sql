CREATE DATABASE hand_gesture_db;

CREATE TABLE gestures (
                          id BIGSERIAL PRIMARY KEY,
                          gesture_name VARCHAR(255),
                          detected_time TIMESTAMP
);