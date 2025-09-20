package com.example.demo;

import com.example.demo.components.MenuController;
import com.example.demo.activity.BlindPrintingController;
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
        MenuController menuController = showMenu(menuPane, "components/menu.fxml", MenuController.class);
        if (menuController != null) {
            menuController.setLayoutController(this);
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
            System.err.println("Ошибка загрузки контента: " + fxmlPath);
            e.printStackTrace();
        }
    }

    // Специальный метод для загрузки активности с передачей ссылки на контроллер
    public void loadActivityWithController(String fxmlPath, Class<?> controllerClass) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            AnchorPane pane = loader.load();

            // Получаем контроллер загруженного FXML
            Object controller = loader.getController();

            // Если это BlindPrintingController, передаем ему ссылку на себя
            if (controller instanceof BlindPrintingController) {
                ((BlindPrintingController) controller).setLayoutController(this);
            }

            // Загружаем контент в contentPane
            contentPane.getChildren().setAll(pane);
            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);

            System.out.println("Активность загружена: " + fxmlPath);

        } catch (Exception e) {
            System.err.println("Ошибка загрузки активности: " + fxmlPath);
            e.printStackTrace();
        }
    }

    //Установка menu и привязка контроллера к LayoutController
    private <T> T showMenu(AnchorPane contentContainer, String file, Class<T> controllerClass) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
            VBox pane = loader.load();
            contentContainer.getChildren().setAll(pane);
            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);
            return loader.getController();
        } catch (Exception e) {
            System.err.println("Ошибка загрузки меню: " + file);
            e.printStackTrace();
            return null;
        }
    }
    // В LayoutController
    public <T> T loadContentPaneWithController(String fxmlPath, Class<T> controllerClass) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            AnchorPane pane = loader.load();

            // поместили view
            contentPane.getChildren().setAll(pane);
            AnchorPane.setTopAnchor(pane, 0.0);
            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 0.0);
            AnchorPane.setRightAnchor(pane, 0.0);

            // вернули контроллер загруженного FXML
            @SuppressWarnings("unchecked")
            T controller = (T) loader.getController();
            return controller;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}