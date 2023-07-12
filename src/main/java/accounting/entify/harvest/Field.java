package accounting.entify.harvest;

import java.util.ArrayList;

public class Field {
    private double wight;
    private double row;
    private ArrayList<Plant> planting=new ArrayList<>();

    public Field(double wight, double row) {
        this.wight = wight;
        this.row = row;
    }
    public void addPlants(Plant plant){
        planting.add(plant);
        this.row-=plant.getRow();
    }
}
