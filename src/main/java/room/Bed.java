package room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bed extends Place {
    private int[] trueId = {1, 2, 7};
    private double width;
    private double length;
    private double height;

    public Bed(String name,double width, double length, double height) {
        super(name,width, length, height);
        this.width = width;
        this.length = length;
        this.height = height;
    }
    public int[] getTrueId() {
        return trueId;
    }


}
