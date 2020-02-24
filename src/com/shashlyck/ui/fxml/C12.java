package com.shashlyck.ui.fxml;

import com.shashlyck.functions.TabulatedFunction;
import com.shashlyck.functions.factory.ArrayTFFactory;
import com.shashlyck.functions.factory.LinkedListTFFactory;
import com.shashlyck.functions.factory.TabulatedFunctionFactory;
import com.shashlyck.ui.CreationWindow;
import com.shashlyck.ui.Loader;
import com.shashlyck.ui.Settings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.DoubleStringConverter;

import java.util.ArrayList;
import java.util.List;

public class C12 extends CreationPage implements C2 {

    @FXML
    private Label amountLabel;

    public class EditablePoint{
        double X;
        double Y;

        public EditablePoint(double X, double Y) {
            this.X = X;
            this.Y = Y;
        }

        public double getX() {
            return X;
        }

        public void setX(double x) {
            this.X = x;
        }

        public double getY() {
            return Y;
        }

        public void setY(double y) {
            this.Y = y;
        }
    }

    @FXML
    private TableView<EditablePoint> pointsTableView;
    private int count;

    @FXML
    void initialize(){
        TableColumn<EditablePoint, Double> xCoorColumn = new TableColumn<>("X коорд.");
        xCoorColumn.setCellValueFactory(new PropertyValueFactory<>("X"));
        xCoorColumn.setOnEditCommit((TableColumn.CellEditEvent<EditablePoint, Double> event) -> {
            TablePosition<EditablePoint, Double> pos = event.getTablePosition();
            Double newValue = event.getNewValue();
            int row = pos.getRow();
            EditablePoint point = event.getTableView().getItems().get(row);
            point.setX(newValue);
        });
        TableColumn<EditablePoint, Double> yCoorColumn = new TableColumn<>("Y коорд.");
        yCoorColumn.setCellValueFactory(new PropertyValueFactory<>("Y"));
        yCoorColumn.setOnEditCommit((TableColumn.CellEditEvent<EditablePoint, Double> event) -> {
            TablePosition<EditablePoint, Double> pos = event.getTablePosition();
            Double newValue = event.getNewValue();
            int row = pos.getRow();
            EditablePoint point = event.getTableView().getItems().get(row);
            point.setY(newValue);
        });
        pointsTableView.getColumns().addAll(xCoorColumn, yCoorColumn);
        xCoorColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        yCoorColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

    }

    @Override
    void loadNext() {
        setNext((CreationPage) Loader.loadFXML("CF").getTwo());
        int size = pointsTableView.getItems().size();
        double[] xValues = new double[size];
        double[] yValues = new double[size];
        ObservableList<EditablePoint> points = pointsTableView.getItems();
        for (int i = 0; i < size; i++) {
            xValues[i] = points.get(i).X;
            yValues[i] = points.get(i).Y;
        }
        TabulatedFunctionFactory currentFactory = SettingsController.getCurrentFactoryType() ?
                new ArrayTFFactory() : new LinkedListTFFactory();
        Settings.setCurrentFactory(currentFactory);
        ((CF)next).getResultFunction(Settings.getCurrentFactory().create(xValues, yValues));
    }

    @Override
    public void setCount(int count) {

        this.count = count;
        amountLabel.setText(Integer.toString(count));
        pointsTableView.setItems(FXCollections.observableArrayList(new ArrayList<EditablePoint>(){{
            for (int i = 0; i < count; i++) add(new EditablePoint(.0, .0));
        }}));
    }

    @Override
    public void applyWindow(CreationWindow creationWindow) {
        super.applyWindow(creationWindow);
        creationWindow.getBackButton().setText("К Шагу 1");
        creationWindow.getNextButton().setText("К Шагу 3");
    }
}
