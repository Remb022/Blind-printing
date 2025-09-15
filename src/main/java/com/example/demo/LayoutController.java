package com.example.demo;

import com.example.demo.components.MenuController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class LayoutController {
    @FXML AnchorPane menuPane;
    @FXML AnchorPane contentPane;
    @FXML AnchorPane scenePane;

    @FXML
    public void initialize() {
        System.out.println("Инициализация LayoutController");
        showMenu().setLayoutController(this);
    }

    public AnchorPane getScenePane() {
        return scenePane;
    }

    //Установка view в contentPane при вызове метода из MenuController
    public void loadContentPane(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            AnchorPane pane = loader.load();
            contentPane.getChildren().setAll(pane);
            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Установка menu и привязка контроллера к LayoutController
    private MenuController showMenu() {
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("components/menu.fxml"));
            VBox pane = loader.load();
            menuPane.getChildren().setAll(pane);
            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);
            return loader.getController();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void setBlindPrinting() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/activity/blind_printing_activity.fxml"));
            AnchorPane pane = loader.load();
            LayoutController layoutController = loader.getController();
            AnchorPane scenePane = layoutController.getScenePane();
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
