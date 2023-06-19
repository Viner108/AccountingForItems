package room;

import java.util.ArrayList;
import java.util.List;

public class Suitcase extends Place{
    private int[] trueId={1,2,4};
    private double width;
    private double length;
    private double height;
    private List<String> items=new ArrayList<>();

    public Suitcase(double width, double length, double height) {
        super(width, length, height);
        this.width = width;
        this.length = length;
        this.height = height;
    }
    public String getName(){
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

    public List<String> getItems() {
        return items;
    }
}
