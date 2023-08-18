import accounting.AccountingForItemsApplication;
import accounting.entify.places.Place;
import accounting.repository.xml.ItemXmlRepository;
import accounting.repository.xml.PlaceXmlRepository;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.nio.file.Path;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;
import java.util.RandomAccess;

public class Test {
    private static Path itemPath = Path.of("library", "Items.xml");
    private static Path placePath = Path.of("library", "Places.xml");
    public static void main(String[] args) throws IOException, JAXBException {
        testWriteXmlFile();
    }
    public static void testCreateUser(){
        AccountingForItemsApplication application=new AccountingForItemsApplication();
        application.createUser("X","Y");
        application.clean();
    }
    public static void testLoginUser(){
        AccountingForItemsApplication application=new AccountingForItemsApplication();
        application.createUser("X","Y");
        System.out.println(application.loginUser("X","Y").toString());
        application.readAll();
    }
    public static void testWriteXmlFile() throws JAXBException {
        AccountingForItemsApplication application=new AccountingForItemsApplication();
        application.createItem("Computer",1,1,1,1);
        application.createItem("Computer2",1,2,2,2);
        application.writeXml();
    }
}
