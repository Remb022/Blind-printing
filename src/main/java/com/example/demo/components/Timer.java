package com.example.demo.components;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class Timer {
    private int seconds = 0;
    private Timeline timer;

    public void startTimer(Text text) {
        timer = new Timeline(
                new KeyFrame(Duration.seconds(1),event -> {
                    seconds++;
                    text.setText(updateTime());
                })
        );
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    public void stopTimer() {
        if (timer != null) {
            timer.stop();
        }
    }

    public void resumeTimer() {
        if (timer != null) {
            timer.play();
        }
    }

    public void resetTime() {
        seconds = 0;
    }

    public String setTime() {
        int min = seconds/60;
        int sec = seconds%60;

        return String.format("%02d:%02d", min, sec);
    }

    private String updateTime() {
        int min = seconds/60;
        int sec = seconds%60;

        String time = String.format("%02d:%02d", min, sec);

        System.out.println(time);

        return time;
    }


}
