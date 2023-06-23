package room;

import java.util.ArrayList;
import java.util.List;

public class Table extends Place {
    private String name;
    private int[] trueId = {1, 3, 4};
    private double width;
    private double length;
    private double height;

    public Table(String name,double width, double length, double height) {
        super(name,width, length, height);
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public int[] getTrueId() {
        return trueId;
    }

    @Override
    public String getName() {
        return "Table";
    }

}
