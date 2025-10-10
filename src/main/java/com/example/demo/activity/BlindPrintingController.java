package com.example.demo.activity;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Objects;

public class BlindPrintingController {
    //Компоненты активности
    @FXML private Button buttonMoreVert, buttonKeyboard, buttonDelete;
    @FXML private ImageView imageMoreVert, imageKeyboard, imageDelete;
    @FXML private AnchorPane layout;
    //Компоненты стоп карточки
    @FXML private Button buttonResume, buttonExit, buttonAgain;
    @FXML private AnchorPane stopCard;

    @FXML
    private void initialize() {
        System.out.println("Инициализация BlindPrintingController");

        blindPrintingStop(buttonMoreVert);
        blindPrintingResume(buttonResume);

        //Анимации подсвечивания
        glowOnHover(buttonMoreVert, imageMoreVert, "/com/example/demo/icon/More_vert_active.png", "/com/example/demo/icon/More_vert_normal.png");
        glowOnHover(buttonKeyboard, imageKeyboard, "/com/example/demo/icon/Keyboard_active.png", "/com/example/demo/icon/Keyboard_normal.png");
        glowOnHover(buttonDelete, imageDelete, "/com/example/demo/icon/Delete_active.png", "/com/example/demo/icon/Delete_normal.png");
    }

    //Метод реализации свечения кнопки спомощью подмены содержимого иконки кнопки
    private void glowOnHover(Button button, ImageView imageView, String imageActivePatch, String imageNormalPatch) {
        Image imageActive = new Image(Objects.requireNonNull(getClass().getResource(imageActivePatch)).toExternalForm());
        Image imageNormal = new Image(Objects.requireNonNull(getClass().getResource(imageNormalPatch)).toExternalForm());

        imageView.setImage(imageNormal);

        button.setOnMouseClicked(mouseEvent -> {
            boolean isPressed = Boolean.TRUE.equals(button.getUserData());

            isPressed = !isPressed;
            button.setUserData(isPressed);

            imageView.setImage(isPressed ? imageActive : imageNormal);
        });

        button.setOnMouseEntered(mouseEvent -> {
            if (!Boolean.TRUE.equals(button.getUserData())) {
                imageView.setImage(imageActive);
            }
        });

        button.setOnMouseExited(mouseEvent -> {
            if (!Boolean.TRUE.equals(button.getUserData())) {
                imageView.setImage(imageNormal);
            }
        });
    }
    private void blindPrintingStop(Button button) {
        button.setOnAction(mouseEvent -> {
            System.out.println("Нажата кнопка остановить");
            stopCard.setDisable(false);
            stopCard.setVisible(true);
        });
    }
    private void blindPrintingResume(Button button) {
        button.setOnAction(mouseEvent -> {
            System.out.println("Нажата кнопка продолжить");
            stopCard.setDisable(true);
            stopCard.setVisible(false);
        });
    }
}
