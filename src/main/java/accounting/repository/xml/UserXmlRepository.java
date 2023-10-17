package accounting.repository.xml;

import accounting.entify.places.PlaceMap;
import accounting.entify.users.UserMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.nio.file.Path;

public class UserXmlRepository extends FileXmlRepository<UserMap>{
    public UserXmlRepository(Path path) {
        super(path);
    }
}
