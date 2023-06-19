import items.Item;
import room.Bed;
import room.Place;
import room.Table;

public class Test {
// id - категория предмета
//    1-техника
//    2-одежда
//    3-еда
//    4-другое
    public static void main(String[] args) {
        Item computer=new Item("Computer",1,0.1,1,0.5);
        Item toy=new Item("Toy",4,0.5,1.5,2);
        Item sweet=new Item("Sweet",3,0.01,0.05,0.01);
        Item dress=new Item("Dress",2,0.01,1,1.5);
        Table table=new Table(1,2,2);
        Bed bed=new Bed(2,3,5);
        table.insert(computer);
        table.insert(toy);
        bed.insert(sweet);
        table.insert(dress);
        table.answerSearch(computer);
        bed.answerSearch(computer);
        table.remove(computer);
        table.answerSearch(computer);
        table.movement(computer,bed);
        bed.answerSearch(computer);
    }
}
