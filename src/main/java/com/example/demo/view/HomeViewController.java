package com.example.demo.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import java.io.IOException;

public class HomeViewController {
    @FXML TilePane basicLessons;

    public void initialize() {
        System.out.println("Инициализация Home_view");
        setCardsBasicLessons();
    }

    //Вывод карточек базовых уроков
    private void setCardsBasicLessons() {
        for (int i = 0; i < 6; i++) {
            try {
                FXMLLoader loaderCard = new FXMLLoader(getClass().getResource("/com/example/demo/components/study_cards.fxml"));
                AnchorPane pane = loaderCard.load();

                //Присвоение ID
                pane.setId("card" + i);

                //Программа запоминает какой ID выводить при нажатии на карточки и потом просто выводит запомнившийся код
                pane.setOnMouseClicked(mouseEvent -> {
                    System.out.println("Нажата карточка: " + pane.getId());
                });
                basicLessons.getChildren().add(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}