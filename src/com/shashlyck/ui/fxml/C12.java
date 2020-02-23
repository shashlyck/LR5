package com.shashlyck.ui.fxml;

import com.shashlyck.ui.CreationWindow;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class C12 extends CreationPage {

    @FXML
    private TableView pointsTableView;

    private int count;

    @FXML
    void initialize(){

    }

    @Override
    void loadNext() {

    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void applyWindow(CreationWindow creationWindow) {
        super.applyWindow(creationWindow);
        creationWindow.getBackButton().setText("Ъ ируѓ 1");
    }
}
