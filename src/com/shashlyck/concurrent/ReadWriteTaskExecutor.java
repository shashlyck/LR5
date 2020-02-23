package com.shashlyck.concurrent;

import com.shashlyck.functions.ConstantFunction;
import com.shashlyck.functions.LinkedListTabulatedFunction;
import com.shashlyck.functions.TabulatedFunction;

public class ReadWriteTaskExecutor {
    public static void main(String[] args) {
        TabulatedFunction linkedListTabulatedFunction =
                new LinkedListTabulatedFunction(new ConstantFunction(-5), 1, 1000, 1000);
        Thread readThread = new Thread(new ReadTask(linkedListTabulatedFunction));
        Thread writeThread = new Thread(new WriteTask(linkedListTabulatedFunction, 11));
        writeThread.start();
        readThread.start();
    }
}
