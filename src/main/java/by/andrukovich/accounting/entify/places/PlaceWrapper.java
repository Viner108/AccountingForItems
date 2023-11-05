package by.andrukovich.accounting.entify.places;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class PlaceWrapper {
    @XmlElement(name = "place")
    public List<Place> places = new ArrayList<Place>();
}
