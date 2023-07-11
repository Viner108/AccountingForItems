package accounting.places;

public class Armchair extends Place {
    private int[] trueId = {2};
    private double width;
    private double length;
    private double height;

    public Armchair(String name, double width, double length, double height) {
        super(name, width, length, height);
        this.width = width;
        this.length = length;
        this.height = height;
    }
    public int[] getTrueId() {
        return trueId;
    }

}
