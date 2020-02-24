package com.shashlyck.ui.fxml;

import com.shashlyck.functions.MathFunction;
import com.shashlyck.functions.Point;
import com.shashlyck.functions.SqrFunction;
import com.shashlyck.functions.SqrRootFunction;
import com.shashlyck.functions.factory.ArrayTFFactory;
import com.shashlyck.functions.factory.LinkedListTFFactory;
import com.shashlyck.functions.factory.TabulatedFunctionFactory;
import com.shashlyck.ui.AlertHandler;
import com.shashlyck.ui.CreationWindow;
import com.shashlyck.ui.Loader;
import com.shashlyck.ui.Settings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C22 extends CreationPage implements C2 {

    @FXML
    private Label amountLabel;
    @FXML
    private ChoiceBox functionChoiceBox;
    @FXML
    private TextField endField;
    @FXML
    private TextField startField;
    private int count;

    @FXML
    void initialize(){
        List<String> implFunctionsList =
                Arrays.asList(new String[] {"Возведение в квадрат", "Взятие корня"});
        ObservableList<String> implFunctions = FXCollections.observableList(implFunctionsList);
        functionChoiceBox.setItems(implFunctions);
    }

    @Override
    void loadNext() {
        setNext((CreationPage) Loader.loadFXML("CF").getTwo());

        MathFunction mathFunction = functionChoiceBox.getSelectionModel().getSelectedItem().equals("Возведение в квадрат") ?
                new SqrFunction() : new SqrRootFunction();
        TabulatedFunctionFactory currentFactory = SettingsController.getCurrentFactoryType() ?
                new ArrayTFFactory() : new LinkedListTFFactory();
        Settings.setCurrentFactory(currentFactory);
        ((CF)next).getResultFunction(Settings.getCurrentFactory().create(mathFunction,
                Double.parseDouble(startField.getText()), Double.parseDouble(endField.getText()), count));
    }

    @Override
    public CreationPage nextPage() {

        try {

            double startBorder = Double.parseDouble(startField.getText());
            double endBorder = Double.parseDouble(endField.getText());
            if (startBorder == endBorder)
                throw  new NumberFormatException("Equality of Start and End Constraints");

        } catch (NumberFormatException e){


            AlertHandler.makeAlert(Alert.AlertType.ERROR)
                    .setTitle("Ошибка при задании границ")
                    .setContent("Вы ввели неправильные границы")
                    .show();

            return this;
        }
        return super.nextPage();
    }

    @Override
    public void setCount(int count) {

        this.count = count;
        amountLabel.setText(Integer.toString(count));
    }

    @Override
    public void applyWindow(CreationWindow creationWindow) {
        super.applyWindow(creationWindow);
        creationWindow.getBackButton().setText("К Шагу 1");
        creationWindow.getNextButton().setText("К Шагу 3");
    }

}
