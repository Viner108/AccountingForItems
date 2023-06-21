import items.Item;
import room.*;

public class Test {
    // id - категория предмета
    //  1-техника
    //  2-одежда
    //  3-еда
    //  4-другое
    public static void main(String[] args) {
        Item computer = new Item("Computer", 1, 1, 1, 1);
        Item toy = new Item("Toy", 4, 2, 2, 2);
        Item sweet = new Item("Sweet", 3, 0.01, 0.05, 0.01);
        Item dress = new Item("Dress", 2, 0.01, 1, 1.5);
        Item trash = new Item("Trash", 4, 0.1, 0.04, 0.01);
        Table table = new Table(1, 2, 2);
        Bed bed = new Bed(2, 3, 5);
        Suitcase suitcase = new Suitcase(0.5, 1, 0.5);
        Floor floor = new Floor(3, 4, 5);
        Armchair armchair = new Armchair(1, 1, 1.5);
        table.insert(computer);
        table.insert(toy);
        table.insert(computer);
        table.insert(computer);
        table.insert(computer);
        bed.insert(toy);
        bed.insert(toy);
        bed.insert(toy);
        bed.insert(toy);
        bed.insert(sweet);
        suitcase.insert(dress);
        table.insert(dress);
        floor.insert(trash);
        floor.insert(sweet);
        floor.insert(dress);
        floor.insert(computer);
        floor.insert(toy);
        armchair.insert(computer);
        armchair.insert(toy);
        armchair.insert(trash);
        armchair.insert(dress);
        table.answerSearch(computer);
        bed.answerSearch(sweet);
        bed.answerSearch(computer);
        table.movement(computer, bed);
        bed.remove(computer);
        bed.answerSearch(computer);
        randomPlace(sweet, bed, table, suitcase, floor, armchair);
        searchInThisRoom(computer, bed, suitcase, table, floor, armchair);
//        System.out.println(bed.getWidth()+ " " +bed.getLength()+ " " +bed.getHeight());
//        System.out.println(table.getWidth()+ " "+ table.getLength()+ " "+ table.getHeight());
//        System.out.println(suitcase.getWidth()+" "+suitcase.getLength()+ " "+ suitcase.getHeight());
//        System.out.println(bed.volume());
//        System.out.println(table.volume());
    }

    public static void randomPlace(Item item, Place... places) {
        for (Place place : places) {
            if (place.volume() > item.volume() && place.indexCheck(item)) {
                place.insert(item);
                break;
            }
        }
    }

    public static void searchInThisRoom(Item item, Place... places) {
        for (Place place : places) {
            if (place.search(item)) {
                place.answerSearch(item);
            }
        }
    }
}
