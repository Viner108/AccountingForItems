package accounting.entify.harvest;

public class Plant {
    private int row;
    private double averageYieldInKg;

    public Plant(int row, double averageYieldInKg) {
        this.row = row;
        this.averageYieldInKg = averageYieldInKg;
    }

    public int getRow() {
        return row;
    }

    public double getAverageYieldInKg() {
        return averageYieldInKg;
    }
}
