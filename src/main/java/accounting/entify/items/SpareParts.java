package accounting.entify.items;

public class SpareParts extends Item {
    Item parent;

    public SpareParts(String name, int id, double width, double length, double height,Item parent) {
        super(name, id, width, length, height);
        this.parent=parent;
    }

    public Item getParent() {
        return parent;
    }
}
