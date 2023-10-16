package accounting.repository.xml;

import accounting.entify.action.ActionLogMap;
import accounting.entify.items.ItemMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.nio.file.Path;

public class ActionXmlRepository {
    private Path path;

    public ActionXmlRepository(Path path) {
        this.path = path;
    }

    public void writeToXmlFile(ActionLogMap actionLogMap) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ActionLogMap.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(actionLogMap, path.toFile());
    }
}
