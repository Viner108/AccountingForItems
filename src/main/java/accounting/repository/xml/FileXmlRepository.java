package accounting.repository.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileXmlRepository<T,R> implements XmlRepository<T,R> {
    private Path path;

    public FileXmlRepository(Path path) {
        this.path = path;
    }

    @Override
    public void writeToXmlFile(R elementMap) throws JAXBException, Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(elementMap.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(elementMap, path.toFile());
    }

    @Override
    public R readFromFile(R elementMap) throws JAXBException, Exception {
        JAXBContext context = JAXBContext.newInstance(elementMap.getClass());
        Unmarshaller unmarshaller = context.createUnmarshaller();
        R elementMap1 = (R) unmarshaller.unmarshal(new InputStreamReader(new FileInputStream(path.toString()), StandardCharsets.UTF_8));
        return elementMap1;
    }
}
