package accounting;

import accounting.items.Documents;
import accounting.items.Item;
import accounting.items.Medicines;
import accounting.items.SpareParts;
import accounting.room.*;
import accounting.users.ActionLog;
import accounting.users.LoginProcessor;
import accounting.users.RegistrationProcessor;
import accounting.users.User;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountingForItemsApplication {
    private FileRepository fileRepository = new FileRepository();
    private ActionLog log = new ActionLog();
    private Path itemPath = Path.of("library", "Item.java");
    private Path placePath = Path.of("library", "Place.java");
    private Path userPath = Path.of("library", "User.java");
    private Path actionPath = Path.of("library", "Action.java");

    // id - категория предмета
    //  1-техника
    //  2-одежда
    //  3-еда
    //  4-инструменты
    //  5-документы
    //  6-лекарства
    //  7-другое
    private Item computer = new Item("Computer", 1, 1, 1, 1);
    private Item toy = new Item("Toy", 7, 2, 2, 2);
    private Item sweet = new Item("Sweet", 3, 0.01, 0.05, 0.01);
    private Item dress = new Item("Dress", 2, 0.01, 1, 1.5);
    private Item trash = new Item("Trash", 7, 0.1, 0.04, 0.01);
    private Item hammock = new Item("Hammock", 7, 1.5, 2, 0.01);
    private Documents document = new Documents("Contract", 5, 0.2, 0.5, 0.0001,10,11,2015, "y",10);
    private Medicines medicine = new Medicines("Pills", 6, 0.02, 0.05, 0.005,3,4,1999,"y",2);
    private SpareParts part = new SpareParts("Rope", 7, 0.01, 3, 0.01, hammock);
    private Table table = new Table("Table", 1, 2, 2);
    private Bed bed = new Bed("Bed", 2, 3, 5);
    private Suitcase suitcase = new Suitcase("Suitcase", 0.5, 1, 0.5);
    private Floor floor = new Floor("Floor", 3, 4, 5);
    private Armchair armchair = new Armchair("Armchair", 1, 1, 1.5);
    private User person1 = new User("Lera", 1, "123");
    private User person2 = new User("Ivan", 2, "321");
    private List<User> users = new ArrayList<>();
    private RegistrationProcessor registrationProcessor = new RegistrationProcessor(userPath);
    private LoginProcessor loginProcessor = new LoginProcessor(userPath);

    public void createUser(String login, String password) {
        User user = registrationProcessor.createUser(login, password);
        users.add(user);
    }
    public User loginUser(String login, String password) {
        User user = loginProcessor.login(login, password);
        return user;
    }
    public void isUser(String login, String password) {
        if(loginProcessor.isUser(login, password)){
            System.out.println("Такой пользователь уже существует");
        }
    }

    public void readAll() throws IOException {
       for( User user:fileRepository.readFileWithUsers(userPath)){
           System.out.println(user.toString());
       }for( Item item:fileRepository.readFileWithItems(itemPath)){
           System.out.println(item.toString());
       }for( Place place:fileRepository.readFileWithPlaces(placePath)){
           System.out.println(place.toString());
       }
//        fileRepository.readFile(path4);
    }


    public void save() throws IOException {
        fileRepository.writeAllItem(itemPath, computer, toy, sweet, dress, trash, hammock, document, document, part);
        fileRepository.writeAllPlace(placePath, armchair, bed, floor, suitcase, table);
//        fileRepository.writeAction(path4, log);
    }

    public void clean() {
        fileRepository.cleanFile(itemPath);
        fileRepository.cleanFile(placePath);
        fileRepository.cleanFile(userPath);
        fileRepository.cleanFile(actionPath);
    }

    public void searchInThisRoom(Item item, User user, Place... places) {
        if (user!=null) {
            log.getActions().add("Пользователь " + user.getName() + " искал предмет " + item.getName() + " по всей комнате");
            for (Place place : places) {
                if (place.search(item, user)) {
                    place.answerSearch(item, user, log);
                }
            }
        }
    }

    public void randomPlace(Item item, User user, Place... places) {
        if (user!=null) {
            for (Place place : places) {
                if (place.volume() > item.volume() && place.indexCheck(item)) {
                    place.insert(item, user, log);
                    break;
                }
            }
        }else {
            System.out.println("Этот пользователь не зарегестрирован в системе.");
        }
    }
    public void AllRoom(Item item, User user) {
        if (user!=null) {
            for (Place place : fileRepository.readFileWithPlaces(placePath)) {
                if (place.volume() > item.volume() && place.indexCheck(item)) {
                    place.insert(item, user, log);
                    break;
                }
            }
        }else {
            System.out.println("Этот пользователь не зарегестрирован в системе.");
        }
    }
    public boolean drugExpirationDate(Medicines medicine) {
        LocalDate nowDate =LocalDate.now();
        LocalDate date=null;
        if(medicine.getDays()!=0){
            date= medicine.getDateOfPurchase().plusDays(medicine.getDays());
        }else if(medicine.getMonths()!=0){
            date= medicine.getDateOfPurchase().plusMonths(medicine.getMonths());
        }else if(medicine.getYears()!=0){
            date= medicine.getDateOfPurchase().plusYears(medicine.getYears());
        }
        date=date.minusYears(nowDate.getYear());
        date = date.minusMonths(nowDate.getMonthValue());
        date = date.minusDays(nowDate.getDayOfMonth());
        if(date.getYear()>=0&&date.getMonthValue()>=0&&date.getDayOfMonth()>0){
            System.out.println("Лекарство "+medicine.getName()+" пригодно к использованию");
            return true;
        }
        System.out.println("У лекарства "+medicine.getName()+" уже истек срок годности");
        return false;
    }
    public boolean documentExpirationDate(Documents document) {
        LocalDate nowDate =LocalDate.now();
        LocalDate date=null;
        if(this.document.getDays()!=0){
            date= this.document.getDateOfPurchase().plusDays(this.document.getDays());
        }else if(this.document.getMonths()!=0){
            date= this.document.getDateOfPurchase().plusMonths(this.document.getMonths());
        }else if(this.document.getYears()!=0){
            date= this.document.getDateOfPurchase().plusYears(this.document.getYears());
        }
        date=date.minusYears(nowDate.getYear());
        date = date.minusMonths(nowDate.getMonthValue());
        date = date.minusDays(nowDate.getDayOfMonth());
        if(date.getYear()>=0&&date.getMonthValue()>=0&&date.getDayOfMonth()>0){
            System.out.println("У документа "+ this.document.getName()+" на данный момент срок годности не закончился");
            return true;
        }
        System.out.println("У документа "+ this.document.getName()+" срок годности уже истек");
        return false;
    }

    public User getPerson1() {
        return person1;
    }

    public FileRepository getFileRepository() {
        return fileRepository;
    }

    public ActionLog getLog() {
        return log;
    }

    public Path getUserPath() {
        return userPath;
    }

    public User getPerson2() {
        return person2;
    }

    public Path getItemPath() {
        return itemPath;
    }

    public Path getPlacePath() {
        return placePath;
    }

    public Item getComputer() {
        return computer;
    }

    public Item getToy() {
        return toy;
    }

    public Item getSweet() {
        return sweet;
    }

    public Item getDress() {
        return dress;
    }

    public Item getTrash() {
        return trash;
    }

    public Item getHammock() {
        return hammock;
    }

    public Documents getDocument() {
        return document;
    }

    public Medicines getMedicine() {
        return medicine;
    }

    public SpareParts getPart() {
        return part;
    }

    public Table getTable() {
        return table;
    }

    public Bed getBed() {
        return bed;
    }

    public Suitcase getSuitcase() {
        return suitcase;
    }

    public Floor getFloor() {
        return floor;
    }

    public Armchair getArmchair() {
        return armchair;
    }
}
