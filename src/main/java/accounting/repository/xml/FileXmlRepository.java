package accounting.repository.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Path;

public class FileXmlRepository<T> implements XmlRepository<T>{
        private Path path;
    private String XSD_TOKEN_1_XML;
    public FileXmlRepository(Path path) {
        this.path = path;
        this.XSD_TOKEN_1_XML= path.toString();
    }

    @Override
    public void writeToXmlFile(T elementMap) throws JAXBException, Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(elementMap.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(elementMap, path.toFile());
    }
    @Override
    public T readFromFile(T elementMap) throws JAXBException, Exception{
        JAXBContext context=JAXBContext.newInstance(elementMap.getClass());
        Unmarshaller unmarshaller=context.createUnmarshaller();
        elementMap = (T) unmarshaller.unmarshal(new File(FileXmlRepository.class.getClassLoader().getResource(XSD_TOKEN_1_XML).getFile()));
        return elementMap;
    }
}
