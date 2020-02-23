package com.shashlyck.ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Loader.setPrimaryStage(primaryStage);
        Loader.openInAWindow(primaryStage, Loader.loadFXML("MainWindow").getOne(), true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
