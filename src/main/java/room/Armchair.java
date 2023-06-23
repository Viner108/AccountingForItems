package room;

import java.util.Arrays;

public class Armchair extends Place {
    private String name;
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

    @Override
    public String getName() {
        return name;
    }

    public int[] getTrueId() {
        return trueId;
    }

}
