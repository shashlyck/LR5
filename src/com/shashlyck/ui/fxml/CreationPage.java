package com.shashlyck.ui.fxml;

import com.shashlyck.ui.CreationWindow;
import javafx.fxml.FXML;
import javafx.scene.Parent;

public abstract class CreationPage {

    @FXML
    private Parent parent;

    private CreationWindow creationWindow;
    private CreationPage previous = null;
    protected CreationPage next = null;

    public CreationPage nextPage(){
        if (next == null) loadNext();
        next.previous = this;
        creationWindow.getBackButton().setVisible(true);
        next.applyWindow(creationWindow);
        return next;
    }

    public CreationPage previousPage(){

        previous.next = this;
        creationWindow.getNextButton().setVisible(true);
        previous.applyWindow(creationWindow);
        return previous;
    }
    void setNext(CreationPage page){
        next = page;
    }

    abstract void loadNext();

    public void applyWindow(CreationWindow creationWindow){
        this.creationWindow = creationWindow;
        creationWindow.getCurrentScenePane().getChildren().clear();
        creationWindow.getCurrentScenePane().getChildren().add(parent);
    }
}
