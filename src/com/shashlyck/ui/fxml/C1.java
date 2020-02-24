package com.shashlyck.ui.fxml;

import com.shashlyck.ui.AlertHandler;
import com.shashlyck.ui.CreationWindow;
import com.shashlyck.ui.Loader;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.util.Arrays;

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
        countField.textProperty().addListener((ob, ov, nv) -> {
            if (!nv.matches("\\d*"))
                countField.setText(nv.replaceAll("[^\\d]", ""));
        });
    }

    @Override
    public CreationPage nextPage() {

        try{
            int count = Integer.parseInt(countField.getText());
            if (count < 2 || count > 30)
                throw new NumberFormatException("[count="+count+"] is out of bounds");
        } catch (NumberFormatException e){
            AlertHandler.makeAlert(Alert.AlertType.ERROR)
                    .setContent("Должно быть >=2 и <= 30!\n".concat(e.getLocalizedMessage()))
                    .setTitle("Неправильно введено количество точек!").show();
            return this;
        }

        return super.nextPage();
    }

    @Override
    void loadNext() {
        if (group.getSelectedToggle() == typeOneRadioButton)
            setNext((CreationPage) Loader.loadFXML("C12").getTwo());
        else{
            setNext((CreationPage) Loader.loadFXML("C22").getTwo());
        }
        ((C2)next).setCount(Integer.parseInt(countField.getText()));
    }

    @Override
    public void applyWindow(CreationWindow creationWindow) {

        super.applyWindow(creationWindow);
        creationWindow.getNextButton().setText("К Шагу 2");
        creationWindow.getBackButton().setVisible(false);
    }
}