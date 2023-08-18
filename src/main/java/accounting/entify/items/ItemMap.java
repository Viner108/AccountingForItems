package accounting.entify.items;

import accounting.repository.xml.adapters.ItemAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Map;

@XmlRootElement(name = "ItemMap")
public class ItemMap {
    Map<Integer,Item> itemMap;

    public Map<Integer, Item> getItemMap() {
        return itemMap;
    }
    @XmlElement(name = "Items")
    @XmlJavaTypeAdapter(ItemAdapter.class)
    public void setItemMap(Map<Integer, Item> itemMap) {
        this.itemMap = itemMap;
    }
}