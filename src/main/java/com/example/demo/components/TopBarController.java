package com.example.demo.components;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class TopBarController {
    private boolean toggled = false;
    private double x;
    private double y;
    private double width = 1000;
    private double height = 700;
    @FXML HBox topBar;

    @FXML
    private void initialize() {
        System.out.println("Инициализация TopBarController");
    }

    @FXML
    private void closeWindow(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void rollUp(ActionEvent event) {
    }

    @FXML
    private void reduce(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        if (!toggled) {
            stage.setWidth(takeWidth());
            stage.setHeight(takeHeight());
        } else {
            Screen screen = Screen.getPrimary();
            Rectangle2D screenBounds = screen.getVisualBounds();
            stage.setWidth(screenBounds.getWidth());
            stage.setHeight(screenBounds.getHeight());
        }
        toggled = !toggled;
    }

    private void giveWidth(double width) {
        this.width = width;
    }
    private void  giveHeight(double height) {
        this.height = height;
    }
    private double takeWidth() {
        return width;
    }
    private  double takeHeight() {
        return height;
    }
}
