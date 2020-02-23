package com.shashlyck.ui;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainWindow {

    private Stage mainStage;

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public BorderPane mainPane;
    public TableView tableObjects;
    public TableColumn columnObjects;
    public TableView tablePoints;
    public LineChart lineChart;

    @FXML
    void initialize(){

    }

    public void handleAdd() {

        Stage addStage = new Stage();
        addStage.initOwner(mainStage);
        addStage.initModality(Modality.WINDOW_MODAL);
        Pair<Parent, CreationWindow> pair = Loader.loadFXML("CreationWindow");
        pair.getTwo().setStage(addStage);
        Loader.openInAWindow(addStage, pair.getOne(), false);
    }

    public void handleOperation() {
    }

    public void handleSettings() {

    }

    public void handleSave() {
    }

    public void handleLoad() {
    }
}
