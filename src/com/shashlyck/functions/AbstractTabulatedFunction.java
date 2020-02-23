package com.shashlyck.functions;

public abstract class AbstractTabulatedFunction implements TabulatedFunction {

    protected int count;

    protected abstract int floorIndexOfX(double x);

    protected abstract double extrapolateLeft(double x);

    protected abstract double extrapolateRight(double x);

    protected abstract double interpolate(double x, int floorIndex);

    protected double interpolate(double x, double leftX, double rightX, double leftY, double rightY) {
        return leftY + (rightY - leftY) / (rightX - leftX) * (x - leftX);
    }

    public double apply(double x) {
        if (x < leftBound()) {
            return extrapolateLeft(x);
        } else if (x > rightBound()) {
            return extrapolateRight(x);
        } else if (indexOfX(x) != -1) {
            return getY(indexOfX(x));
        } else {
            return interpolate(x, floorIndexOfX(x));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName()).append(" size = ").append(this.getCount());
        for (Point point : this)
            stringBuilder.append("\n[").append(point.x).append("; ").append(point.y).append("]");
        return stringBuilder.toString();
    }
}
