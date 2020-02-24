package com.shashlyck.ui.fxml;

import com.shashlyck.functions.Point;
import com.shashlyck.functions.TabulatedFunction;
import com.shashlyck.ui.CreationWindow;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class CF extends CreationPage {

    @FXML
    private TableView<Point> resultTableView;
    private TabulatedFunction resultFunction;

    @Override
    public CreationPage nextPage() {

        creationWindow.close();
        return this;
    }

    public TabulatedFunction getResultFunction(TabulatedFunction function){
        return function;
    }

    @Override
    void loadNext() {}

    @Override
    public void applyWindow(CreationWindow creationWindow) {
        creationWindow.getBackButton().setText("К Шагу 2");
        creationWindow.getNextButton().setText("Финиш");
        super.applyWindow(creationWindow);
    }

}
