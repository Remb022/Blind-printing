package com.example.demo.components;

import com.example.demo.LayoutController;
import com.example.demo.activity.BlindPrintingController;
import com.example.demo.view.HomeViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.util.Arrays;
import java.util.List;

public class MenuController {
    @FXML private Button home;
    @FXML private Button progress;
    @FXML private Button info;
    @FXML private Button award;
    @FXML private Button settings;

    private LayoutController layoutController;
    private List<Button> buttonList;


    //Передача ссылки для использования методов данного Layout
    public void setLayoutController(LayoutController layoutController) {
        this.layoutController = layoutController;
        // Загружаем домашнюю страницу с передачей ссылки
        HomeViewController homeController =
                this.layoutController.loadContentPaneWithController("view/home_view.fxml", HomeViewController.class);
        if (homeController != null) {
            homeController.setLayoutController(this.layoutController);
        }
    }



    @FXML
    private void initialize() {
        System.out.println("Инициализация MenuController");

        buttonList = Arrays.asList(home, progress, info, award, settings);

        home.setOnAction(e -> {
            if (layoutController != null) {
                HomeViewController homeController =
                        layoutController.loadContentPaneWithController("view/home_view.fxml", HomeViewController.class);
                if (homeController != null) {
                    homeController.setLayoutController(layoutController);
                }
                setActiveButton(home);
            }
        });


        progress.setOnAction(e -> {
            if (layoutController != null) {
                layoutController.loadContentPane("view/progress_view.fxml");
                setActiveButton(progress);
            }
        });

        info.setOnAction(e -> {
            if (layoutController != null) {
                layoutController.loadContentPane("view/info_view.fxml");
                setActiveButton(info);
            }
        });

        award.setOnAction(e -> {
            if (layoutController != null) {
                layoutController.loadContentPane("view/award_view.fxml");
                setActiveButton(award);
            }
        });

        settings.setOnAction(e -> {
            if (layoutController != null) {
                layoutController.loadContentPane("view/settings_view.fxml");
                setActiveButton(settings);
            }
        });

        // Устанавливаем активную кнопку "home" по умолчанию
        setActiveButton(home);
    }


    private void setActiveButton(Button activeBtn) {
        for (Button btn : buttonList) {
            btn.getStyleClass().remove("active-button-menu");
        }
        activeBtn.getStyleClass().add("active-button-menu");
        System.out.println("Нажата кнопка меню: " + activeBtn.getId());
    }

}