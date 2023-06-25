package room;

import items.Item;
import users.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Place {
    private String name;
    private int[] trueId = {1, 2, 3, 4, 5,6,7};
    private double width;
    private double length;
    private double height;
    private List<String> itemNames = new ArrayList<>();

    public double volume() {
        return this.width * this.length * this.height;
    }

    public Place(String name, double width, double length, double height) {
        this.name = name;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public void insert(Item item,User user) {
        if (item.volume() < volume()) {
            if (indexCheck(item)) {
                itemNames.add(item.getName());
                user.getActions().add("Добавил предмет "+item.getName()+" в место "+getName());
                double volume = volume() - item.volume();
                volume = Math.cbrt(volume);
                this.width = volume;
                this.length = volume;
                this.height = volume;
                System.out.println("Пользователь "+user.getName()+" добавил предмет "+item.getName() + " на место " + getName());
            } else {
                System.out.println("Предмету " + item.getName() + " не место на " + getName());
            }
        } else {
            System.out.println("Для предмета " + item.getName() + " нет места на " + getName());
        }
    }

    public boolean indexCheck(Item item) {
        for (int i : getTrueId()) {
            if (i == item.getId()) {
                return true;
            }
        }
        return false;
    }

    public int[] getTrueId() {
        return trueId;
    }

    public boolean search(Item item,User user) {
        for (String integer : itemNames) {
            if (integer.equals(item.getName())) {
                return true;
            }
        }
        return false;
    }

    public void answerSearch(Item item,User user) {
        user.getActions().add("Искал предмет "+ item.getName());
        if (search(item,user)) {
            System.out.println("Предмет " + item.getName() + " находится в месте " + getName());
            user.getActions().add("Нашел предмет "+item.getName()+" в месте "+getName());
        } else {
            System.out.println("В месте " + getName() + " нет предмета " + item.getName());
            user.getActions().add("Не нашел предмет "+item.getName());
        }
    }

    public String getName() {
        return name;
    }

    public void remove(Item item,User user) {
        if (search(item,user)) {
            itemNames.remove(item.getName());
            user.getActions().add("Убрал предмет "+item.getName()+" из места "+getName());
            System.out.println("Пользователь "+user.getName() +" убрал предмет "+item.getName()+" из места " + getName());
        }else {
            System.out.println("Пользовать " + user.getName() + " не смог убрать предмет " + item.getName());
        }
    }

    public void movement(Item item,User user, Place place) {
        if (search(item,user)) {
            remove(item,user);
            user.getActions().remove("Убрал предмет "+item.getName()+" из места "+getName());
            place.insert(item,user);
            user.getActions().remove("Добавил предмет "+item.getName()+" в место "+place.getName());
            user.getActions().add("Переместил предмет "+item.getName()+" из места "+getName()+" в место " +place.getName());
            System.out.println("Пользовать " + user.getName() + " переместил предмет " + item.getName() + " из места " + getName()+" в места " +place.getName());
        } else {
            System.out.println("Пользовать " + user.getName() + " не смог переместить предмет " + item.getName() + " из места " + getName()+" в места " +place.getName());
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


    @Override
    public String toString() {
        return "Place{" +
                "Назывние места='" + name + '\'' +
                ", Свободное место в ширину=" + width +
                ", Свободное место в длину=" + length +
                ", Свободное место в высоту=" + height +
                ", Список вещей находящихся в этом месте=" + itemNames +
                '}';
    }
}

