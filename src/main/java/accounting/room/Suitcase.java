package accounting.room;

public class Suitcase extends Place {
    private int[] trueId = {1, 2, 5,6,7};
    private double width;
    private double length;
    private double height;

    public Suitcase(String name, double width, double length, double height) {
        super(name, width, length, height);
        this.width = width;
        this.length = length;
        this.height = height;
    }
    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public int[] getTrueId() {
        return trueId;
    }
}
