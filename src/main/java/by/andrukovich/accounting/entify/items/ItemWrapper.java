package by.andrukovich.accounting.entify.items;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class ItemWrapper {
    @XmlElement(name = "item")
    public List<Item> items = new ArrayList<Item>();
}
