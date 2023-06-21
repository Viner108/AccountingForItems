package room;

public class Armchair extends Place {
    private int[] trueId = {2};
    private double width;
    private double length;
    private double height;

    public Armchair(double width, double length, double height) {
        super(width, length, height);
        this.width = width;
        this.length = length;
        this.height = height;
    }

    @Override
    public String getName() {
        return "Armchair";
    }

    public int[] getTrueId() {
        return trueId;
    }


}
