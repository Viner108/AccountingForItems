package room;

import java.util.ArrayList;
import java.util.List;

public class Bed extends Place{
    private int[] trueId={1,2,4};
    private double width;
    private double length;
    private double height;
    private List<String> items=new ArrayList<>();

    public Bed(double width, double length, double height) {
        super(width, length, height);
        this.width = width;
        this.length = length;
        this.height = height;
    }
    public String getName(){
        return "Bed";
    }

    public int[] getTrueId() {
        return trueId;
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

    public List<String> getItems() {
        return items;
    }
}
