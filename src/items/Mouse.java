package items;

public class Mouse extends Item {
    public Mouse(double length, double width, double height, double weight) {
        super("Mouse", length, width, height, weight);
    }

    @Override
    public double calculateVolume() {
        return getLength() * getWidth() * getHeight();
    }
}
