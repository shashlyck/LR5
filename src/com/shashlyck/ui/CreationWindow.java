package com.shashlyck.ui;

import com.shashlyck.ui.fxml.CreationPage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CreationWindow {

    @FXML
    public Button nextButton;
    @FXML
    public Button backButton;

    public CreationPage currentScene;
    @FXML
    public Pane currentScenePane;
    private Stage stage;

    @FXML
    void initialize(){

        currentScene = (CreationPage) Loader.loadFXML("C1").getTwo();
        currentScene.applyWindow(this);
        nextButton.setOnAction(event -> currentScene = currentScene.nextPage());
        backButton.setOnAction(event -> currentScene = currentScene.previousPage());
    }

    public Button getNextButton() {
        return nextButton;
    }

    public Button getBackButton() {
        return backButton;
    }

    public Pane getCurrentScenePane() {
        return currentScenePane;
    }

    void setStage(Stage stage){
        this.stage = stage;
    }

    public void close(){
        stage.close();
    }
}
