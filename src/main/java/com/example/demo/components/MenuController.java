package com.example.demo.components;

import com.example.demo.LayoutController;
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
    }

    @FXML
    private void initialize() {
        System.out.println("Инициализация MenuController");

        buttonList = Arrays.asList(home, progress, info, award, settings);

        home.setOnAction(e -> {
            (layoutController.loadContentPane("view/home_view.fxml", HomeViewController.class)).setLayoutController(layoutController);
            setActiveButton(home);
        });

        progress.setOnAction(e -> {
            layoutController.loadContentPane("view/progress_view.fxml");
            setActiveButton(progress);
        });

        info.setOnAction(e -> {
            layoutController.loadContentPane("view/info_view.fxml");
            setActiveButton(info);
        });

        award.setOnAction(e -> {
            layoutController.loadContentPane("view/award_view.fxml");
            setActiveButton(award);
        });

        settings.setOnAction(e -> {
            layoutController.loadContentPane("view/settings_view.fxml");
            setActiveButton(settings);
        });
    }

    private void setActiveButton(Button activeBtn) {
        for (Button btn : buttonList) {
            btn.getStyleClass().remove("active-button-menu");
        }
        activeBtn.getStyleClass().add("active-button-menu");
        System.out.println("Нажата кнопка меню: " + activeBtn.getId());
    }
}
