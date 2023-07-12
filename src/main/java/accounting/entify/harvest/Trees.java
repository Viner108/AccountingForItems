package accounting.entify.harvest;

public class Trees {
    private int NumberOfTrees;
    private double averageYieldInKg;

    public Trees(int numberOfTrees, double averageYieldInKg) {
        NumberOfTrees = numberOfTrees;
        this.averageYieldInKg = averageYieldInKg;
    }

    public int getNumberOfTrees() {
        return NumberOfTrees;
    }

    public double getAverageYieldInKg() {
        return averageYieldInKg;
    }
}
