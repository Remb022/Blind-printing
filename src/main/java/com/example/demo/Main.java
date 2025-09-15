package com.example.demo;

import com.example.demo.databases.DBUserResults;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("Инициализация данных");
        DBUserResults.createTable();
        System.out.println("Запуск MainLayout");
        showWindow(stage);
    }

    private void showWindow(Stage stage) throws IOException {
        //Убираем верхнюю системную панель
        stage.initStyle(StageStyle.UNDECORATED);

        //Подключаем файл с отображаемым
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("layouts/main_layout.fxml"));

        //Получаем размеры экрана
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        //Настраиваем сцену, подключаем файл, задаем высоту, задаем ширину
        Scene scene = new Scene(fxmlLoader.load(), screenBounds.getWidth(), screenBounds.getHeight());

        //Разворачиваем приложение на весь экран заведомо
        stage.setScene(scene);
        stage.setMaximized(false);

        stage.show();
    }
}