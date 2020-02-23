package com.shashlyck.ui;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import static javafx.scene.control.Alert.AlertType.*;

public class AlertHandler {

    private final Alert alert;

    private AlertHandler(){
        alert = new Alert(INFORMATION);
        alert.setOnCloseRequest(event -> alert.close());
    }
    private AlertHandler(Alert.AlertType type){

        alert = new Alert(type);
        alert.setOnCloseRequest(event -> alert.close());
    }
    public static AlertHandler makeAlert() {
        return new AlertHandler();
    }
    public static AlertHandler makeAlert(Alert.AlertType type){ return new AlertHandler(type); }
    public AlertHandler setOwner(Stage owner){
        alert.initOwner(owner);
        return this;
    }

    public void show(){
        alert.show();
    }

    public boolean showAndGetResult(){
        alert.showAndWait();
        return alert.getResult().getButtonData().isDefaultButton();
    }


    public AlertHandler setContent(String content){
        alert.setContentText(alert.getContentText().concat(content));
        return this;
    }

    public AlertHandler setTitle(String title){
        alert.setTitle(title);
        return this;
    }

    private AlertHandler setHeader(String header){
        alert.setHeaderText(header);
        return this;
    }

    public AlertHandler setConfirmButtons(){
        alert.getButtonTypes().setAll(
                new ButtonType("OKAY", ButtonBar.ButtonData.OK_DONE),
                new ButtonType("CANCEL", ButtonBar.ButtonData.CANCEL_CLOSE));
        return this;
    }

    private AlertHandler setOkButton(){
        alert.getButtonTypes().setAll(new ButtonType("OKAY", ButtonBar.ButtonData.OK_DONE));
        return this;
    }
}