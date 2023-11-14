package items;

public class LCDScreen extends Item {
    public LCDScreen(double length, double width, double height, double weight) {
        super("LCD Screen", length, width, height, weight);
    }

    @Override
    public double calculateVolume() {
        return getLength() * getWidth() * getHeight();
    }
}