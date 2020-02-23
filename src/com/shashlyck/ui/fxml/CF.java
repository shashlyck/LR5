package com.shashlyck.ui.fxml;

import com.shashlyck.functions.Point;
import com.shashlyck.functions.TabulatedFunction;
import com.shashlyck.ui.CreationWindow;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class CF extends CreationPage {

    @FXML
    private TableView<Point> resultTableView;

    @Override
    public CreationPage nextPage() {

        creationWindow.close();
        return this;
    }

    public void getResultFunction(TabulatedFunction function){

    }

    @Override
    void loadNext() {}

    @Override
    public void applyWindow(CreationWindow creationWindow) {
        creationWindow.getBackButton().setText("� ���� 2");
        creationWindow.getNextButton().setText("�����");
        super.applyWindow(creationWindow);
    }
}
