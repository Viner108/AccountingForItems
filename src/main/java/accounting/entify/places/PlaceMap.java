package accounting.entify.places;

import accounting.entify.items.Item;
import accounting.repository.xml.adapters.ItemAdapter;
import accounting.repository.xml.adapters.PlaceAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Map;

@XmlRootElement(name = "PlaceMap")
public class PlaceMap {
    Map<Integer, Place> placeMap;

    public Map<Integer, Place> getPlaceMap() {
        return placeMap;
    }
    @XmlElement(name = "Places")
    @XmlJavaTypeAdapter(PlaceAdapter.class)
    public void setPlaceMap(Map<Integer, Place> placeMap) {
        this.placeMap = placeMap;
    }
}