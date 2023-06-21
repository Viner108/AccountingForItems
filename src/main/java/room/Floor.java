package room;

public class Floor extends Place {
    private int[] trueId = {1, 4};
    private double width;
    private double length;
    private double height;

    public Floor(double width, double length, double height) {
        super(width, length, height);
        this.width = width;
        this.length = length;
        this.height = height;
    }

    @Override
    public String getName() {
        return "Floor";
    }

    public int[] getTrueId() {
        return trueId;
    }


}
