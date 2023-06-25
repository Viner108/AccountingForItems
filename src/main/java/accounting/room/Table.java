package accounting.room;

public class Table extends Place {
    private int[] trueId = {1, 3, 4, 5,6,7};
    private double width;
    private double length;
    private double height;

    public Table(String name, double width, double length, double height) {
        super(name, width, length, height);
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public int[] getTrueId() {
        return trueId;
    }


}
