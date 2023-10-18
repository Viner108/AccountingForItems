package accounting.repository.xml;

import javax.xml.bind.JAXBException;

public interface XmlRepository<T> {
    void writeToXmlFile(T elementMap) throws JAXBException;
}
