package room;

import java.util.Arrays;

public class Floor extends Place {
    private String name;
    private int[] trueId = {1, 4, 7};
    private double width;
    private double length;
    private double height;

    public Floor(String name, double width, double length, double height) {
        super(name, width, length, height);
        this.width = width;
        this.length = length;
        this.height = height;
    }

    @Override
    public String getName() {
        return name;
    }


    public int[] getTrueId() {
        return trueId;
    }

}
