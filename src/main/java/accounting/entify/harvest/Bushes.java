package accounting.entify.harvest;

public class Bushes {
    private int NumberOfBushes;
    private double averageYieldInKg;

    public Bushes(int numberOfBushes, double averageYieldInKg) {
        NumberOfBushes = numberOfBushes;
        this.averageYieldInKg = averageYieldInKg;
    }

    public int getNumberOfBushes() {
        return NumberOfBushes;
    }

    public double getAverageYieldInKg() {
        return averageYieldInKg;
    }
}
