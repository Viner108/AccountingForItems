package accounting.items;

public class Medicines extends Item {
    private String name;
    private long term;

    public Medicines(String name, int id, double width, double length, double height, long term) {
        super(name, id, width, length, height);
        this.name = name;
        this.term = term;
    }

    public String getName() {
        return name;
    }

    public long getTerm() {
        return term;
    }
}
