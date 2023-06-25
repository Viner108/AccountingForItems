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
import java.util.ArrayList;
import java.util.List;

public class AccountingForItemsApplication {
    private FileRepository fileRepository = new FileRepository();
    private ActionLog log = new ActionLog();
    private Path path1 = Path.of("library", "Item.java");
    private Path path2 = Path.of("library", "Place.java");
    private Path userPath = Path.of("library", "User");
    private Path path4 = Path.of("library", "Action.java");

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
    private Documents document = new Documents("Contract", 5, 0.2, 0.5, 0.0001, 31536000);
    private Medicines medicine = new Medicines("Pills", 6, 0.02, 0.05, 0.005, 7776000);
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
    }

    public void loginUser(String login, String password) {
        User user = loginProcessor.login(login, password);
        users.add(user);
    }

    public void read() throws IOException {
        fileRepository.readFile(path1);
        fileRepository.readFile(path2);
        fileRepository.readFile(userPath);
        fileRepository.readFile(path4);
    }


    public void save() throws IOException {
        fileRepository.writeAllItem(path1, computer, toy, sweet, dress, trash, hammock, document, medicine, part);
        fileRepository.writeAllPlace(path2, armchair, bed, floor, suitcase, table);
        fileRepository.writeAllUser(userPath, person1, person2);
        fileRepository.writeAction(path4, log);
    }

    public void clean() {
        fileRepository.cleanFile(path1);
        fileRepository.cleanFile(path2);
        fileRepository.cleanFile(userPath);
        fileRepository.cleanFile(path4);
    }

    public void searchInThisRoom(Item item, User user, Place... places) {
        log.getActions().add("Пользователь " + user.getName() + " искал предмет " + item.getName() + " по всей комнате");
        for (Place place : places) {
            if (place.search(item, user)) {
                place.answerSearch(item, user, log);
            }
        }
    }

    public void randomPlace(Item item, User user, Place... places) {
        for (Place place : places) {
            if (place.volume() > item.volume() && place.indexCheck(item)) {
                place.insert(item, user, log);
                break;
            }
        }
    }

    //должна задаваться дата сегоднешнего дня и расчитываться сколько времени осталось до конца срока годности
    //либо выдавать дату когда срок годности закончится

    public long drugExpirationDate(Medicines medicine, long data) {
        return medicine.getTerm() - data;
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

    public Path getPath1() {
        return path1;
    }

    public Path getPath2() {
        return path2;
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