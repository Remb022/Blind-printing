package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class LayoutController {
    @FXML AnchorPane scenePane;

    ControllerManager controllerManager = ControllerManager.getInstance();

    @FXML
    public void initialize() {
        System.out.println("Инициализация LayoutController");
        controllerManager.setLayoutController(this);
        loadSceneMenu();
    }

    public void loadSceneMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/activity/menu_content_activity.fxml"));
            AnchorPane pane = loader.load();
            scenePane.getChildren().setAll(pane);

            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadSceneBlindPrinting() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/activity/blind_printing_activity.fxml"));
            StackPane pane = loader.load();
            scenePane.getChildren().setAll(pane);

            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
