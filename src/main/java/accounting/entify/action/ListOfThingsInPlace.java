package accounting.entify.action;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ListOfThingsInPlace implements Serializable {
    private Map<String,String> list=new HashMap<>();
    public void putOnTheList(String item, String place){
        list.put(item,place);
    }
    public void removeFromList(String item,String place){
        list.remove(item,place);
    }

    public Map<String, String> getList() {
        return list;
    }
}
