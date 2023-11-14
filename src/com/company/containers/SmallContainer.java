package com.company.containers;

public class SmallContainer extends Container {
    public SmallContainer(double length, double width, double height) {
        super(length, width, height);
    }

    @Override
    public String toString() {
        return "Small Container";
    }
    @Override
    public double calculateContainerVolume() {
        return getLength() * getWidth() * getHeight();
    }


}