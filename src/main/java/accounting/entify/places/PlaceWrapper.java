package accounting.entify.places;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaceWrapper {
    @XmlElement
    @XmlJavaTypeAdapter(PlaceWrapper.PlaceAdapter.class)
    public List<Place> places = new ArrayList<Place>();

    class PlaceAdapter extends XmlAdapter<List<Place>, List<Place>> {


        @Override
        public List<Place> unmarshal(List<Place> places) throws Exception {
            return places;
        }

        @Override
        public List<Place> marshal(List<Place> places) throws Exception {
            return places;
        }
    }
}

