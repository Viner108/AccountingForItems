package accounting.repository.xml;

import accounting.entify.items.ItemMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.nio.file.Path;

public class FileXmlRepository<T> {
    private Path path;
    public FileXmlRepository(Path path) {
        this.path = path;
    }
    public void writeToXmlFile(T elementMap) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(elementMap.getClass() );
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(elementMap, path.toFile());
    }
}
