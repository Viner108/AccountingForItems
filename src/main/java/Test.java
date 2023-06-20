import items.Item;
import room.Bed;
import room.Place;
import room.Suitcase;
import room.Table;

public class Test {
// id - категория предмета
//    1-техника
//    2-одежда
//    3-еда
//    4-другое
    public static void main(String[] args) {
        Item computer=new Item("Computer",1,0.1,1,0.5);
        Item toy=new Item("Toy",4,2,2,2);
        Item sweet=new Item("Sweet",3,0.01,0.05,0.01);
        Item dress=new Item("Dress",2,0.01,1,1.5);
        Table table=new Table(1,2,2);
        Bed bed=new Bed(2,3,5);
        Suitcase suitcase=new Suitcase(0.5,1,0.5);
        table.insert(computer);
        table.insert(toy);
        table.insert(computer);
        bed.insert(toy);
        bed.insert(toy);
        bed.insert(toy);
        bed.insert(toy);
        bed.insert(sweet);
        suitcase.insert(dress);
        table.insert(dress);
        table.answerSearch(computer);
        bed.answerSearch(sweet);
        bed.answerSearch(computer);
        table.movement(computer,bed);
        bed.remove(computer);
        bed.answerSearch(computer);
        System.out.println(bed.getWidth()+ " " +bed.getLength()+ " " +bed.getHeight());
        System.out.println(table.getWidth()+ " "+ table.getLength()+ " "+ table.getHeight());
        System.out.println(suitcase.getWidth()+" "+suitcase.getLength()+ " "+ suitcase.getHeight());
        System.out.println(bed.volume());
        System.out.println(table.volume());

    }
}
