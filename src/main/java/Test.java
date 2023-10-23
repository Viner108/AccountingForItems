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
    public static void main(String[] args) throws IOException, JAXBException, Exception {
//        testCreateUser();
//        testLoginUser();
//        testWriteFile();
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
    public static void testWriteFile() throws JAXBException,Exception {
        AccountingForItemsApplication application=new AccountingForItemsApplication();
        application.createItem("Computer",1,1,1,1);
        System.out.println(application.useOfTheItem("Computer").toString());
        application.createPlace("Table",1,1,1);
        System.out.println(application.useOfThePlace("Table").toString());
    }
    public static void testWriteXmlFile() throws JAXBException,Exception {
        AccountingForItemsApplication application=new AccountingForItemsApplication();
        application.createItem("Computer",1,1,1,1);
        application.createUser("Computer","111");
        application.createPlace("Table",1,1,1);
        application.writeXml();
        application.createPlace("Table3",2,2,2);
        application.writeXml();
        System.out.println(application.useOfTheXmlItem("Computer").toString());
        System.out.println(application.useOfTheXmlUser("Computer").toString());
        System.out.println(application.useOfTheXmlPlace("Table3").toString());
//        System.out.println(application.readXmlPlace().getPlaceMap().values().stream().count());
    }
}
