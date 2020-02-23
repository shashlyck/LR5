package com.shashlyck.concurrent;

import com.shashlyck.functions.TabulatedFunction;

public class ReadTask implements Runnable {

    private final TabulatedFunction tabulatedFunction;

    ReadTask(TabulatedFunction tabulatedFunction) {
        this.tabulatedFunction = tabulatedFunction;
    }

    @Override
    public void run() {

        for (int i = 0; i < tabulatedFunction.getCount(); i++)
            synchronized (tabulatedFunction) {
                System.out.printf(
                        "After read: i = %d, x = %f, y = %f\n",
                        i, tabulatedFunction.getX(i), tabulatedFunction.getY(i));
            }
    }
}
