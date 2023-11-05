package by.andrukovich.accounting.repository.xml.adapters;

import by.andrukovich.accounting.entify.places.Place;
import by.andrukovich.accounting.entify.places.PlaceWrapper;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaceAdapter extends XmlAdapter<PlaceWrapper, Map<Integer, Place>> {

    @Override
    public Map<Integer, Place> unmarshal(PlaceWrapper placeWrapper) throws Exception {
        Map<Integer, Place> placeMap = null;
        if (placeWrapper != null && placeWrapper.places != null && !placeWrapper.places.isEmpty()) {
            placeMap = new HashMap<Integer, Place>();
            int i=0;
            for (Place place : placeWrapper.places) {
                placeMap.put(i,place);
                i++;
            }
        }
        return placeMap;
    }

    @Override
    public PlaceWrapper marshal(Map<Integer, Place> placeMap) throws Exception {
        PlaceWrapper wrapper = new PlaceWrapper();
        List<Place> elements = new ArrayList<Place>();
        for (Map.Entry<Integer, Place> property : placeMap.entrySet()) {
            elements.add(property.getValue());
        }
        wrapper.places = elements;
        return wrapper;
    }
}
