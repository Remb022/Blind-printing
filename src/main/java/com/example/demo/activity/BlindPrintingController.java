package com.example.demo.activity;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

public class BlindPrintingController { ;
    @FXML private Button buttonMoreVert;
    @FXML private ImageView imageMoreVert;

    @FXML
    private void initialize() {
        System.out.println("Инициализация BlindPrintingController");

        Image image = new Image(getClass().getResourceAsStream("../icon/More_vert_normal.png"));
        imageMoreVert.setImage(image);
        //glowOnHover(buttonMoreVert, imageMoreVert,"icon/More_vert_active.png","icon/More_vert_normal.png");
    }

    private void glowOnHover(Button button, ImageView imageView, String activeIconPath, String normalIconPath) {
        InputStream normalStream = getClass().getResourceAsStream(normalIconPath);
        InputStream activeStream = getClass().getResourceAsStream(activeIconPath);

        if (normalStream == null) {
            throw new IllegalArgumentException("Ресурс не найден: " + normalIconPath);
        }
        if (activeStream == null) {
            throw new IllegalArgumentException("Ресурс не найден: " + activeIconPath);
        }

        Image normalImage = new Image(normalStream);
        Image activeImage = new Image(activeStream);

        button.setOnMouseEntered(event -> imageView.setImage(activeImage));
        button.setOnMouseExited(event -> imageView.setImage(normalImage));
    }



}
