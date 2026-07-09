package com.gopiverse.handgesturerecognition.opencv;

import com.gopiverse.handgesturerecognition.service.GestureService;
import lombok.RequiredArgsConstructor;
import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HandGestureDetector {

    private final GestureService gestureService;

    private String lastGesture = "";

    public void startCamera() {

        VideoCapture camera = new VideoCapture(0);

        if (!camera.isOpened()) {
            System.out.println("Cannot Open Webcam");
            return;
        }

        Mat frame = new Mat();
        Mat gray = new Mat();

        while (true) {

            if (!camera.read(frame)) {
                break;
            }

            Imgproc.cvtColor(frame, gray, Imgproc.COLOR_BGR2GRAY);

            Imgproc.GaussianBlur(gray, gray, new Size(15, 15), 0);

            Imgproc.threshold(gray, gray, 100, 255, Imgproc.THRESH_BINARY);

            double whitePixels = Core.countNonZero(gray);

            String gesture = (whitePixels > 90000) ? "OPEN PALM" : "FIST";

            // Save only when gesture changes
            if (!gesture.equals(lastGesture)) {
                gestureService.saveGesture(gesture);
                System.out.println("Saved Gesture : " + gesture);
                lastGesture = gesture;
            }

            Imgproc.putText(
                    frame,
                    "Gesture : " + gesture,
                    new Point(20, 50),
                    Imgproc.FONT_HERSHEY_SIMPLEX,
                    1,
                    new Scalar(0, 255, 0),
                    2
            );

            Imgproc.putText(
                    frame,
                    "White Pixels : " + (int) whitePixels,
                    new Point(20, 90),
                    Imgproc.FONT_HERSHEY_SIMPLEX,
                    0.7,
                    new Scalar(255, 0, 0),
                    2
            );

            HighGui.imshow("Hand Gesture Recognition", frame);

            int key = HighGui.waitKey(30);

            if (key == 27) { // ESC key
                break;
            }
        }

        camera.release();
        HighGui.destroyAllWindows();
    }
}