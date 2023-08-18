package accounting.repository.xml;

import accounting.entify.items.Item;
import accounting.entify.items.ItemMap;
import accounting.entify.places.Place;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

public class ItemXmlRepository {
    private Path path;

    public ItemXmlRepository(Path path) {
        this.path = path;
    }

    public void writeToXmlFile(ItemMap itemMap) throws JAXBException {
            JAXBContext jaxbContext = JAXBContext.newInstance(ItemMap.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(itemMap, path.toFile());
    }
}
