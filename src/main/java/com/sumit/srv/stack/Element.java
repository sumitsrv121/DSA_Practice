package com.sumit.srv.stack;

public class Element {
    private int leftIndex;
    private int rightIndex;
    private int height;

    public Element() {
    }

    public int getLeftIndex() {
        return leftIndex;
    }

    public void setLeftIndex(int leftIndex) {
        this.leftIndex = leftIndex;
    }

    public int getRightIndex() {
        return rightIndex;
    }

    public void setRightIndex(int rightIndex) {
        this.rightIndex = rightIndex;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Element{" +
                "leftIndex=" + leftIndex +
                ", rightIndex=" + rightIndex +
                ", height=" + height +
                '}';
    }
}
