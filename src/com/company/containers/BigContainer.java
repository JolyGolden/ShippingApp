package com.company.containers;

//Constructor
public class BigContainer extends Container {
    public BigContainer(double length, double width, double height) {
        super(length, width, height);
    }

    //Calculate the volume of container
    @Override
    public double calculateContainerVolume() {
        return getLength() * getWidth() * getHeight();
    }

    @Override
    public String toString() {
        return "Big Container";
    }

}