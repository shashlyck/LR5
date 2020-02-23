package com.shashlyck.concurrent;

import com.shashlyck.functions.Point;
import com.shashlyck.functions.TabulatedFunction;
import com.shashlyck.operations.TabulatedFunctionOperationService;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SynchronizedTabulatedFunction {

    private final TabulatedFunction tabulatedFunction;

    SynchronizedTabulatedFunction(TabulatedFunction tabulatedFunction) {
        this.tabulatedFunction = tabulatedFunction;
    }

    public double apply(double x) {
        synchronized (tabulatedFunction) {
            return tabulatedFunction.apply(x);
        }
    }

    public int getCount() {
        synchronized (tabulatedFunction) {
            return tabulatedFunction.getCount();
        }
    }

    public double getX(int index) {
        synchronized (tabulatedFunction) {
            return tabulatedFunction.getX(index);
        }
    }


    public double getY(int index) {
        synchronized (tabulatedFunction) {
            return tabulatedFunction.getY(index);
        }
    }


    public void setY(int index, double value) {
        synchronized (tabulatedFunction) {
            tabulatedFunction.setY(index, value);
        }

    }


    public int indexOfX(double x) {
        synchronized (tabulatedFunction) {
            return tabulatedFunction.indexOfX(x);
        }
    }


    public int indexOfY(double y) {
        synchronized (tabulatedFunction) {
            return tabulatedFunction.indexOfY(y);
        }
    }


    public double leftBound() {
        synchronized (tabulatedFunction) {
            return tabulatedFunction.leftBound();
        }
    }


    public double rightBound() {
        synchronized (tabulatedFunction) {
            return tabulatedFunction.rightBound();
        }
    }

    public Iterator<Point> iterator() {
        final int[] i = {0};
        synchronized (tabulatedFunction) {
            Point[] copy = TabulatedFunctionOperationService.asPoints(tabulatedFunction);
            return new Iterator<Point>() {
                public boolean hasNext() {
                    return i[0] != copy.length;
                }

                public Point next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return new Point(copy[i[0]].x, copy[i[0]++].y);
                }
            };
        }
    }
}
