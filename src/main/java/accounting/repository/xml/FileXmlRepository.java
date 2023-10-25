package accounting.repository.xml;

import accounting.repository.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileXmlRepository<T,R> implements Repository<T,R> {
    private Path path;

    public FileXmlRepository(Path path) {
        this.path = path;
    }
    public ArrayList<T> readFileWithItems() {
        return new ArrayList<>();
    }

    public void writeToFile(ArrayList<T> allUser, R elements, boolean append) throws  Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(elements.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(elements, path.toFile());
    }
    public void cleanFile() {
        try {
            FileWriter writer = new FileWriter(path.toFile(), false);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public R readFromFile(ArrayList<T> allItem,R elementMap) throws  Exception {
        JAXBContext context = JAXBContext.newInstance(elementMap.getClass());
        Unmarshaller unmarshaller = context.createUnmarshaller();
        R elementMap1 = (R) unmarshaller.unmarshal(new InputStreamReader(new FileInputStream(path.toString()), StandardCharsets.UTF_8));
        return elementMap1;
    }
}
