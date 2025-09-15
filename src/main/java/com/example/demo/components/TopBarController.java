package com.example.demo.components;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TopBarController {
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

    }
}
