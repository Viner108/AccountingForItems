package accounting.entify.places;

import accounting.entify.items.Item;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class PlaceWrapper {
    @XmlElement(name = "place")
    public List<Place> places = new ArrayList<Place>();
}
