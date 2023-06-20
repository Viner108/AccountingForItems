package room;

import items.Item;

import java.util.ArrayList;
import java.util.List;

public class Place {
    private int[] trueId={1,2,3,4};
    private double width;
    private double length;
    private double height;
    private List<String> items = new ArrayList<>();

    public Place(double width, double length, double height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public void insert(Item item) {
        if (item.getWidth()*item.getLength()*item.getHeight()<this.width*this.length*this.height) {
            for (int i : getTrueId()) {
                if (i == item.getId()) {
                    items.add(item.getName());
                    this.width -= item.getWidth();
                    this.length -= item.getLength();
                    this.height -= item.getHeight();
                    System.out.println(item.getName() + " добавлен на место " + getName());
                }
            }
        } else {
            System.out.println("Нет места для предмета " + item.getName());
        }
    }

    public int[] getTrueId() {
        return trueId;
    }

    public boolean search(Item item) {
        for (String integer : items) {
            if (integer.equals(item.getName())) {
                return true;
            }
        }
        return false;
    }

    public void answerSearch(Item item) {
        if (search(item)) {
            System.out.println("Предмет " + item.getName() + " находится в месте " + getName());
        } else {
            System.out.println("В месте " + getName() + " нет предмета " + item.getName());
        }
    }

    public String getName() {
        return "Place";
    }

    public void remove(Item item) {
        if (search(item)) {
            items.remove(item.getName());
            System.out.println("Предмет " + item.getName() + " был удален из места " + getName());
        }
    }

    public void movement(Item item, Place place) {
        if (search(item)) {
            remove(item);
            place.insert(item);
            System.out.println("Предмет " + item.getName() + " был премещен из " + getName() + " в " + place.getName());
        } else {
            System.out.println("Невозможно переместить предмет " + item.getName() + " в место " + place.getName());
        }
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
}

