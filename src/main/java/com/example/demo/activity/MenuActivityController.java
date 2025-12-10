package com.example.demo.activity;

import com.example.demo.ControllerManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MenuActivityController {
    @FXML AnchorPane menuPane;
    @FXML AnchorPane contentPane;

    ControllerManager controllerManager = ControllerManager.getInstance();

    @FXML
    private void initialize() {
        showMenu();
        controllerManager.setMenuActivityController(this);
        loadContentPane("/com/example/demo/view/home_view.fxml");
    }

    //Установка view в contentPane при вызове метода из MenuController и передача ссылки на Controller
    public <T> T loadContentPane(String fxmlPath, Class<T> controllerClass) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            AnchorPane pane = loader.load();
            contentPane.getChildren().setAll(pane);

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
    private void showMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/components/menu.fxml"));
            VBox pane = loader.load();
            menuPane.getChildren().setAll(pane);

            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}