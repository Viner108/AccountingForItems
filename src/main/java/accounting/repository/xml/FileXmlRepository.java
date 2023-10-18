package accounting.repository.xml;

import accounting.entify.items.ItemMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Path;

public class FileXmlRepository<T> implements XmlRepository<T>{
    private Path path;
    public FileXmlRepository(Path path) {
        this.path = path;
    }
    @Override
    public void writeToXmlFile(T elementMap) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(elementMap.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(elementMap, path.toFile());
    }
    public T readFromFile(T elementMap) throws JAXBException{
        JAXBContext context=JAXBContext.newInstance(elementMap.getClass());
        Unmarshaller unmarshaller=context.createUnmarshaller();
        elementMap = (T) unmarshaller.unmarshal(new File(JAXBExample.class.getClassLoader().getResource(XSD_TOKEN_1_XML).getFile()));
        return elementMap;
    }
}
