package com.shashlyck.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class Loader {

    private static Stage primaryStage;

    public static Stage getMainStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        Loader.primaryStage = primaryStage;
    }

    public static <T> Pair<Parent, T> loadFXML(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("fxml/"+ fxml + ".fxml"));
            return new Pair<>(loader.load(), loader.getController());
        } catch (IOException e) {
            AlertHandler.makeAlert(Alert.AlertType.ERROR).setContent(e.toString()).show();
            throw new RuntimeException();
        }
    }

    public static void openInAWindow(Stage stage, Parent parent, boolean resizable){

        stage.setResizable(resizable);
        stage.setScene(new Scene(parent));

        if (stage == primaryStage) {
            stage.show();
            stage.setMinHeight(stage.getHeight());
            stage.setMinWidth(stage.getWidth());
        } else stage.showAndWait();
    }
}
