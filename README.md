# Hand Gesture Recognition System

## Project Overview

Hand Gesture Recognition System is a Java Spring Boot application that captures live video from a webcam using OpenCV and recognizes basic hand gestures in real time. The detected gestures are stored in a PostgreSQL database and can be accessed through REST APIs.

---

## Technologies Used

* Java 17
* Spring Boot 3.5.3
* Spring Data JPA
* PostgreSQL
* OpenCV (Java)
* Maven
* Lombok

---

## Features

* Live webcam integration
* Basic hand gesture recognition
* Detects:

    * OPEN PALM
    * FIST
* Stores detected gestures in PostgreSQL
* REST APIs for gesture management
* Get latest detected gesture
* Count gestures by name
* Delete gesture records

---

## Project Structure

```
src
 ├── config
 ├── controller
 ├── dto
 ├── entity
 ├── exception
 ├── opencv
 ├── repository
 ├── response
 └── service
```

---

## REST APIs

### Save Gesture

```
POST /gesture/{name}
```

Example

```
POST /gesture/OPEN PALM
```

---

### Get All Gestures

```
GET /gesture
```

---

### Delete Gesture

```
DELETE /gesture/{id}
```

---

### Latest Gesture

```
GET /gesture/latest
```

---

### Count Gesture

```
GET /gesture/count/{name}
```

Example

```
GET /gesture/count/OPEN PALM
```

---

## Database Configuration

Database: PostgreSQL

Database Name:

```
hand_gesture_db
```

---

## Run Project

1. Create PostgreSQL database.
2. Update database credentials in `application.properties`.
3. Run the Spring Boot application.
4. Webcam opens automatically.
5. Detected gestures are stored in PostgreSQL.

---

## Future Improvements

* MediaPipe integration
* AI-based gesture recognition
* Multiple hand gestures
* React dashboard
* Docker deployment

---

## Author

Diya Khere
