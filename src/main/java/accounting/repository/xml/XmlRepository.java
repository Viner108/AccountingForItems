package accounting.repository.xml;

import javax.xml.bind.JAXBException;

public interface XmlRepository<T,R> {
    void writeToXmlFile(R elementMap) throws JAXBException, Exception;
    R readFromFile(R elementMap) throws JAXBException, Exception;
}
