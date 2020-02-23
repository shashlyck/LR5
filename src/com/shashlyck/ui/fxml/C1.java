package com.shashlyck.ui.fxml;

import com.shashlyck.ui.AlertHandler;
import com.shashlyck.ui.CreationWindow;
import com.shashlyck.ui.Loader;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class C1 extends CreationPage {

    @FXML
    private RadioButton typeOneRadioButton;
    @FXML
    private RadioButton typeTwoRadioButton;
    public ToggleGroup group = new ToggleGroup();
    @FXML
    private TextField countField;

    @FXML
    void initialize(){
        typeOneRadioButton.fire();
        typeOneRadioButton.setToggleGroup(group);
        typeTwoRadioButton.setToggleGroup(group);
        countField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                countField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    @Override
    public CreationPage nextPage() {

        try{
            int count = Integer.parseInt(countField.getText());
            if (count < 2 || count > 20) throw new NumberFormatException("count out of bounds");
        } catch (NumberFormatException e){
            AlertHandler.makeAlert(Alert.AlertType.ERROR)
                    .setContent("Должно быть >=2 и <= 20!\n".concat(e.getLocalizedMessage()))
                    .setTitle("Неправильно введено количество!").show();
            return this;
        }

        return super.nextPage();
    }

    @Override
    void loadNext() {
        if (group.getSelectedToggle() == typeOneRadioButton) {
                setNext((CreationPage) Loader.loadFXML("C12").getTwo());
            ((C12)next).setCount(Integer.parseInt(countField.getText()));
        }

        else {
            setNext((CreationPage) Loader.loadFXML("C22").getTwo());
            ((C22)next).setCount(Integer.parseInt(countField.getText()));
        }
    }

    @Override
    public void applyWindow(CreationWindow creationWindow) {

        super.applyWindow(creationWindow);
        creationWindow.getNextButton().setText("К Шагу 2");
        creationWindow.getBackButton().setVisible(false);
    }
}