package accounting.repository.xml;

import accounting.entify.action.ActionLogMap;
import accounting.entify.items.ItemMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.nio.file.Path;

public class ActionXmlRepository extends FileXmlRepository<ActionLogMap>{

    public ActionXmlRepository(Path path) {
        super(path);
    }
}
