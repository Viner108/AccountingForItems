package accounting.items;

public class Item {
    private String name;
    private int id;
    private double width;
    private double length;
    private double height;

    public Item(String name, int id, double width, double length, double height) {
        this.name = name;
        this.id = id;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public double volume() {
        return this.width * this.length * this.height;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "Item{" +
                "Название предмета='" + name + '\'' +
                ", id=" + id +
                ", Ширина=" + width +
                ", Длина=" + length +
                ", Высота=" + height +
                '}';
    }
}
