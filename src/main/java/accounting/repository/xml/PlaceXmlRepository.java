package accounting.repository.xml;

import accounting.entify.places.Place;
import accounting.entify.places.PlaceWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

public class PlaceXmlRepository{
    private Path path;

    public PlaceXmlRepository(Path path) {
        this.path = path;
    }

    public void writeToXmlFile(PlaceWrapper place){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Place.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(place, path.toFile());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
