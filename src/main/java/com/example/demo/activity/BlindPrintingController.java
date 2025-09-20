package com.example.demo.activity;

import com.example.demo.LayoutController;
import com.example.demo.view.HomeViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class BlindPrintingController {

    @FXML private AnchorPane rootPane;
    @FXML private Button backButton; // Кнопка "Назад" для возврата в главное меню

    private LayoutController layoutController;

    // Метод для получения ссылки на родительский контроллер
    public void setLayoutController(LayoutController layoutController) {
        this.layoutController = layoutController;
    }

    @FXML
    private void initialize() {
        System.out.println("Инициализация BlindPrintingController");

        if (backButton != null) {
            backButton.setOnAction(e -> goBackToHome());
        }
    }

    // Метод для возврата в главное меню
    private void goBackToHome() {
        if (layoutController != null) {
            HomeViewController homeController = layoutController.loadContentPaneWithController(
                    "view/home_view.fxml",
                    HomeViewController.class
            );
            if (homeController != null) {
                homeController.setLayoutController(layoutController);
            }
        }
    }


    // Пример метода для загрузки другого контента
    public void loadAnotherView(String fxmlPath) {
        if (layoutController != null) {
            layoutController.loadContentPane(fxmlPath);
        }
    }
}