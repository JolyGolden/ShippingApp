package com.company.containers;

public abstract class Container {
    private double length;
    private double width;
    private double height;

    public Container(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }


    public abstract double calculateContainerVolume();

    @Override
    public String toString() {
        return "Container";
    }

    // Print container information
    public void printContainerInfo() {
        System.out.println("Container Volume: " + calculateContainerVolume() + " m³");
    }


}