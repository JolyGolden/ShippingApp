package items;

public class Desktop extends Item {
    public Desktop(double length, double width, double height, double weight) {
        super("Desktop", length, width, height, weight);
    }

    @Override
    public double calculateVolume() {
        return getLength() * getWidth() * getHeight();
    }
}