package accounting.repository.xml;

import accounting.entify.items.ItemMap;
import accounting.entify.places.Place;
import accounting.entify.places.PlaceMap;
import accounting.entify.places.PlaceWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

public class PlaceXmlRepository extends FileXmlRepository<PlaceMap>{
    public PlaceXmlRepository(Path path) {
        super(path);
    }
}
