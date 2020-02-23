package com.shashlyck.ui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Loader.setPrimaryStage(primaryStage);
        Pair<Parent, MainWindow> pair = Loader.loadFXML("MainWindow");
        Loader.openInAWindow(primaryStage, pair.getOne(), true);
        pair.getTwo().setMainStage(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
