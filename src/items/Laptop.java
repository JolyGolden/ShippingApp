package items;

// Concrete class representing a laptop
public class Laptop extends Item {
    public Laptop(double length, double width, double height, double weight) {
        super("Laptop", length, width, height, weight);
    }

    @Override
    public double calculateVolume() {
        return getLength() * getWidth() * getHeight();
    }
}