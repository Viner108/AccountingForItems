import items.Item;
import items.Medicines;
import room.Place;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class FileRepository {
    public  void searchInThisRoom(Item item, Place... places) {
        for (Place place : places) {
            if (place.search(item)) {
                place.answerSearch(item);
            }
        }
    }
    public void randomPlace(Item item, Place... places) {
        for (Place place : places) {
            if (place.volume() > item.volume() && place.indexCheck(item)) {
                place.insert(item);
                break;
            }
        }
    }
    //должна задаваться дата сегоднешнего дня и расчитываться сколько времени осталось до конца срока годности
    //либо выдавать дату когда срок годности закончится
    public long drugExpirationDate(Medicines medicine,long data){
        return medicine.getTerm()-data;
    }
}
