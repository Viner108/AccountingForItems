import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        AccountingForItemsApplication application=new AccountingForItemsApplication();
        application.getTable().insert(application.getComputer(),application.getPerson1(),application.getLog());
        application.getTable().insert(application.getComputer(),application.getPerson2(),application.getLog());
        application.getTable().remove(application.getComputer(),application.getPerson2(),application.getLog());
        application.getTable().movement(application.getComputer(),application.getPerson1(),application.getBed(),application.getLog());
        application.randomPlace(application.getDress(),application.getPerson1(),application.getTable(),application.getArmchair(),application.getBed(),application.getFloor());
        application.searchInThisRoom(application.getDress(),application.getPerson2(),application.getFloor(),application.getBed(),application.getTable(),application.getArmchair(),application.getSuitcase());
        application.getTable().answerSearch(application.getDress(),application.getPerson1(),application.getLog());
        application.save();
        application.read();

    }
}
