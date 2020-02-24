package com.shashlyck.ui.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class SettingsController {

    @FXML
    private RadioButton arrayType;
    @FXML
    private RadioButton listType;
    private Stage stage;
    private ToggleGroup toggleGroup = new ToggleGroup();
    private static boolean isArray = true;

    @FXML
    void initialize(){
        arrayType.fire();
        arrayType.setToggleGroup(toggleGroup);
        listType.setToggleGroup(toggleGroup);
    }


    public void close(ActionEvent actionEvent) {
        if (arrayType.isSelected())
            isArray = true;
        else
            isArray = false;
        stage.close();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static boolean getCurrentFactoryType() {
        return isArray;
    }
}
