package com.shashlyck.ui.fxml;

import com.shashlyck.ui.CreationWindow;

public class C22 extends CreationPage {

    private int count;

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
