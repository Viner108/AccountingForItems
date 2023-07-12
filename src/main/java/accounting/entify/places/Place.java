package accounting.entify.places;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Place implements Serializable {
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

    public String getName() {
        return name;
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


    public int[] getTrueId() {
        return trueId;
    }

    @Override
    public String toString() {
        return "Place{" +
                "Назывние места='" + name + '\'' +
                ", Свободное место в ширину=" + width +
                ", Свободное место в длину=" + length +
                ", Свободное место в высоту=" + height +
                '}';
    }
//    public void insert(Item item, User user, ActionLog log, ListOfThingsInPlace list) {
//        if (item.volume() < volume()) {
//            if (indexCheck(item)) {
//                if(user!=null) {
//                    log.getActions().add("Пользователь " + user.getName() + " добавил предмет " + item.getName() + " в место " + getName());
//                    double volume = volume() - item.volume();
//                    volume = Math.cbrt(volume);
//                    this.width = volume;
//                    this.length = volume;
//                    this.height = volume;
//                    list.putOnTheList(item.getName(),getName());
//                    System.out.println("Пользователь " + user.getName() + " добавил предмет " + item.getName() + " на место " + getName());
//                }else {
//                    System.out.println("Этот пользователь не зарегестрирован в системе.");
//                }
//            } else {
//                System.out.println("Предмету " + item.getName() + " не место на " + getName());
//            }
//        } else {
//            System.out.println("Для предмета " + item.getName() + " нет места на " + getName());
//        }

//    }
//    public boolean indexCheck(Item item) {
//        for (int i : getTrueId()) {
//            if (i == item.getId()) {
//                return true;
//            }
//        }
//        return false;

//    }

//    public boolean search(Item item,User user,ListOfThingsInPlace list) {
//        for (String integer : list.getList().keySet()) {
//            if (integer.equals(item.getName())) {
//                return true;
//            }
//        }
//        return false;

//    }
//    public void answerSearch(Item item,User user, ActionLog log,ListOfThingsInPlace list) {
//        if (user!=null) {
//            log.getActions().add("Пользователь " + user.getName() + " искал предмет " + item.getName() + " в месте " + getName());
//            if (search(item, user,list)) {
//                System.out.println("Предмет " + item.getName() + " находится в месте " + getName());
//                log.getActions().add("Пользователь " + user.getName() + " нашел предмет " + item.getName() + " в месте " + getName());
//            } else {
//                System.out.println("В месте " + getName() + " нет предмета " + item.getName());
//                log.getActions().add("Пользователь " + user.getName() + " не нашел предмет " + item.getName() + " в месте " + getName());
//            }
//        }else {
//            System.out.println("Этот пользователь не зарегестрирован в системе.");
//        }

//    }

//    public void remove(Item item,User user,ActionLog log,ListOfThingsInPlace list) {
//        if (user!=null) {
//            if (search(item, user,list)) {
//                list.removeFromList(item.getName(),getName());
//                double volume = volume() + item.volume();
//                volume = Math.cbrt(volume);
//                this.width = volume;
//                this.length = volume;
//                this.height = volume;
//                log.getActions().add("Пользователь " + user.getName() + " убрал предмет " + item.getName() + " из места " + getName());
//                System.out.println("Пользователь " + user.getName() + " убрал предмет " + item.getName() + " из места " + getName());
//            } else {
//                System.out.println("Пользовать " + user.getName() + " не смог убрать предмет " + item.getName());
//            }
//        }else {
//            System.out.println("Этот пользователь не зарегестрирован в системе.");
//        }
//    }
//    public void movement(Item item,User user, Place place,ActionLog log,ListOfThingsInPlace list) {
//        if (user!=null) {
//            if (search(item, user,list)) {
//                remove(item, user, log,list);
//                list.removeFromList(item.getName(),getName());
//                log.getActions().remove("Пользователь " + user.getName() + " убрал предмет " + item.getName() + " из места " + getName());
//                place.insert(item, user, log,list);
//                list.putOnTheList(item.getName(),place.getName());
//                log.getActions().remove("Пользователь " + user.getName() + " добавил предмет " + item.getName() + " в место " + place.getName());
//                log.getActions().add("Пользователь " + user.getName() + " переместил предмет " + item.getName() + " из места " + getName() + " в место " + place.getName());
//                System.out.println("Пользовать " + user.getName() + " переместил предмет " + item.getName() + " из места " + getName() + " в места " + place.getName());
//            } else {
//                System.out.println("Пользовать " + user.getName() + " не смог переместить предмет " + item.getName() + " из места " + getName() + " в места " + place.getName());
//            }
//        }else {
//            System.out.println("Этот пользователь не зарегестрирован в системе.");
//        }

//    }
}


