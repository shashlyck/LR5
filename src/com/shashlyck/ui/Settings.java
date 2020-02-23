package com.shashlyck.ui;

import com.shashlyck.functions.factory.TabulatedFunctionFactory;

public class Settings {

    private static TabulatedFunctionFactory currentFactory;

    public static TabulatedFunctionFactory getCurrentFactory() {
        return currentFactory;
    }

    public static void setCurrentFactory(TabulatedFunctionFactory currentFactory) {
        Settings.currentFactory = currentFactory;
    }
}
