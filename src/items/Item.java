package items;

public abstract class Item {
    private String name;
    private double length;
    private double width;
    private double height;
    private double weight;

    public Item(String name, double length, double width, double height, double weight) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public abstract double calculateVolume();

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
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

    // Print product information
    public void printItemInfo() {
        System.out.println("Item: " + name);
        System.out.println("Volume: " + calculateVolume() + " m³");
        System.out.println("Weight: " + weight + " kg");
        System.out.println();
    }
}

