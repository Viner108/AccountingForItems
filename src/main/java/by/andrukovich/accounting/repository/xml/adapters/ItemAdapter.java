package by.andrukovich.accounting.repository.xml.adapters;

import by.andrukovich.accounting.entify.items.Item;
import by.andrukovich.accounting.entify.items.ItemWrapper;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemAdapter extends XmlAdapter<ItemWrapper, Map<Integer, Item>> {

    @Override
    public Map<Integer, Item> unmarshal(ItemWrapper itemWrapper) throws Exception {
        Map<Integer, Item> itemMap = null;
        if (itemWrapper != null && itemWrapper.items != null && !itemWrapper.items.isEmpty()) {
            itemMap = new HashMap<Integer, Item>();
            int i=0;
            for (Item item : itemWrapper.items) {
                itemMap.put(i,item);
                i++;
            }
        }
        return itemMap;
    }

    @Override
    public ItemWrapper marshal(Map<Integer, Item> stringItemMap) throws Exception {
        ItemWrapper wrapper = new ItemWrapper();
        List<Item> elements = new ArrayList<Item>();
        for (Map.Entry<Integer, Item> property : stringItemMap.entrySet()) {
            elements.add(property.getValue());
        }
        wrapper.items = elements;
        return wrapper;
    }
}
