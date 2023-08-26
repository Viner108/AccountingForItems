package accounting.repository.xml;

import accounting.entify.places.PlaceMap;
import accounting.entify.users.UserMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.nio.file.Path;

public class UserXmlRepository {
    private Path path;

    public UserXmlRepository(Path path) {
        this.path = path;
    }

    public void writeToXmlFile(UserMap userMap) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(UserMap.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(userMap, path.toFile());
    }
}
