import accounting.AccountingForItemsApplication;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;
import java.util.RandomAccess;

public class Test {
    public static void main(String[] args) throws IOException {
        AccountingForItemsApplication application=new AccountingForItemsApplication();
        application.clean();
        application.createUser("X","Y");
        application.createUser("X2","Y2");
        application.createUser("X3","Y3");
        application.createUser("X4","Y4");
        application.createPlace("Table", 1, 2, 2);
        application.createItem("Computer", 1, 1, 1, 1);
        application.createItem("Computer1", 1, 1, 1, 1);
        application.createItem("Computer2", 1, 1, 1, 1);
        application.createItem("Computer3", 1, 1, 1, 1);
        application.createItem("Computer4", 1, 1, 1, 1);
        application.createItem("Computer5", 1, 1, 1, 1);
        application.createItem("Computer6", 1, 1, 1, 1);
        application.createItem("Computer7", 1, 1, 1, 1);
        application.createItem("Computer8", 1, 1, 1, 1);
        application.createItem("Computer9", 1, 1, 1, 1);
        application.loginUser("X","Y");
        application.readAll();
//        application.isUser("X2","Y2");
//        application.useOfThePlace("Table").insert(application.useOfTheItem("Computer"),application.loginUser("X","Y"),application.getLog(),application.getListOfThingsInPlace());
//        application.useOfThePlace("Table").insert(application.useOfTheItem("Computer1"),application.loginUser("X","Y"),application.getLog(),application.getListOfThingsInPlace());
//        application.useOfThePlace("Table").insert(application.useOfTheItem("Computer2"),application.loginUser("X","Y"),application.getLog(),application.getListOfThingsInPlace());
//        application.useOfThePlace("Table").insert(application.useOfTheItem("Computer3"),application.loginUser("X","Y"),application.getLog(),application.getListOfThingsInPlace());
//        application.useOfThePlace("Table").insert(application.useOfTheItem("Computer4"),application.loginUser("X","Y"),application.getLog(),application.getListOfThingsInPlace());
//        application.useOfThePlace("Table").insert(application.useOfTheItem("Computer5"),application.loginUser("X","Y"),application.getLog(),application.getListOfThingsInPlace());
//        application.useOfThePlace("Table").insert(application.useOfTheItem("Computer6"),application.loginUser("X","Y"),application.getLog(),application.getListOfThingsInPlace());
//        application.useOfThePlace("Table").insert(application.useOfTheItem("Computer7"),application.loginUser("X","Y"),application.getLog(),application.getListOfThingsInPlace());
//        application.useOfThePlace("Table").insert(application.useOfTheItem("Computer8"),application.loginUser("X","Y"),application.getLog(),application.getListOfThingsInPlace());
//        application.useOfThePlace("Table").insert(application.useOfTheItem("Computer9"),application.loginUser("X","Y"),application.getLog(),application.getListOfThingsInPlace());
//        application.useOfThePlace("Table").answerSearch(application.useOfTheItem("Computer"),application.loginUser("X","Y"),application.getLog(),application.getListOfThingsInPlace());
//        application.searchInThisRoom(application.useOfTheItem("Computer"),application.loginUser("X","Y"));
//        application.useOfThePlace("Table").remove(application.useOfTheItem("Computer"),application.loginUser("X","Y"),application.getLog(),application.getListOfThingsInPlace());
//        application.useOfThePlace("Table").answerSearch(application.useOfTheItem("Computer"),application.loginUser("X","Y"),application.getLog(),application.getListOfThingsInPlace());
        application.insert(application.useOfThePlace("Table"),application.useOfTheItem("Computer"),application.loginUser("X","Y"));
        application.insert(application.useOfThePlace("Table"),application.useOfTheItem("Computer1"),application.loginUser("X","Y"));
        application.insert(application.useOfThePlace("Table"),application.useOfTheItem("Computer2"),application.loginUser("X","Y"));
        application.insert(application.useOfThePlace("Table"),application.useOfTheItem("Computer3"),application.loginUser("X","Y"));
        application.insert(application.useOfThePlace("Table"),application.useOfTheItem("Computer4"),application.loginUser("X","Y"));
        application.answerSearch(application.useOfThePlace("Table"),application.useOfTheItem("Computer"),application.loginUser("X","Y"));
        application.answerSearch(application.useOfThePlace("Table"),application.useOfTheItem("Computer4"),application.loginUser("X","Y"));
        application.remove(application.useOfThePlace("Table"),application.useOfTheItem("Computer"),application.loginUser("X","Y"));
        application.remove(application.useOfThePlace("Table"),application.useOfTheItem("Computer4"),application.loginUser("X","Y"));
        application.searchInThisRoom(application.useOfTheItem("Computer1"),application.loginUser("X","Y"));
        application.save();
//        application.getTable().insert(application.getComputer(),application.loginUser("X2","Y2"),application.getLog());
//        application.getTable().remove(application.getComputer(),application.loginUser("X2","Y2"),application.getLog());
//        application.getTable().movement(application.getComputer(),application.loginUser("X","Y"),application.getBed(),application.getLog());
//        application.randomPlace(application.getDress(),application.loginUser("X","Y"),application.getTable(),application.getArmchair(),application.getBed(),application.getFloor());
//        application.useOfThePlace("Table").insert(application.useOfTheItem("Computer"),application.loginUser("X","Y"),application.getLog());
//        application.searchInThisRoom(application.useOfTheItem("Computer"),application.loginUser("X2","Y2"));
//        application.getTable().answerSearch(application.getDress(),application.loginUser("X","Y"),application.getLog());
//        application.AllRoom(application.getComputer(),application.loginUser("X","Y"));
//        application.AllRoom(application.getComputer(),application.loginUser("X5","Y5"));
        application.drugExpirationDate(application.getMedicine());
        application.documentExpirationDate(application.getDocument());
        application.readAll();
    }
}
