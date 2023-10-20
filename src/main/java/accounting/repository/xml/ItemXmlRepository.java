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

public class ItemXmlRepository extends FileXmlRepository<Item,ItemMap>{
    public ItemXmlRepository(Path path) {
        super(path);
    }
}
