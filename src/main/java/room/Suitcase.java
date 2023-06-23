package room;

import java.util.ArrayList;
import java.util.List;

public class Suitcase extends Place {
    private String name;
    private int[] trueId = {1, 2, 4};
    private double width;
    private double length;
    private double height;

    public Suitcase(String name,double width, double length, double height) {
        super(name,width, length, height);
        this.width = width;
        this.length = length;
        this.height = height;
    }

    @Override
    public String getName() {
        return "Suitcase";
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
