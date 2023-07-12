package accounting;

import accounting.action.ActionRepository;
import accounting.action.ListOfThingsInPlace;
import accounting.items.*;
import accounting.repository.*;
import accounting.places.*;
import accounting.action.ActionLog;
import accounting.service.DocumentService;
import accounting.service.DrugService;
import accounting.service.ItemService;
import accounting.service.PlaceService;
import accounting.users.LoginProcessor;
import accounting.users.RegistrationProcessor;
import accounting.users.User;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AccountingForItemsApplication {
    private FileRepository fileRepository = new FileRepository();
    private UserRepository userRepository = new UserRepository();
    private ItemRepository itemRepository = new ItemRepository();
    private PlaceRepository placeRepository = new PlaceRepository();
    private ActionRepository actionRepository = new ActionRepository();
    private ActionLog log = new ActionLog();
    private ListOfThingsInPlace listOfThingsInPlace = new ListOfThingsInPlace();
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
    private Documents document = new Documents("Contract", 5, 0.2, 0.5, 0.0001, 10, 11, 2015, "y", 10);
    private Medicines medicine = new Medicines("Pills", 6, 0.02, 0.05, 0.005, 3, 4, 1999, "y", 2);
    private SpareParts part = new SpareParts("Rope", 7, 0.01, 3, 0.01, hammock);
    private Table table = new Table("Table", 1, 2, 2);
    private Bed bed = new Bed("Bed", 2, 3, 5);
    private Suitcase suitcase = new Suitcase("Suitcase", 0.5, 1, 0.5);
    private Floor floor = new Floor("Floor", 3, 4, 5);
    private Armchair armchair = new Armchair("Armchair", 1, 1, 1.5);
    private User person1 = new User("Lera", 1, "123");
    private User person2 = new User("Ivan", 2, "321");
    private List<User> users = new ArrayList<>();
    private List<Place> places = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private ItemService itemService = new ItemService(itemPath);
    private PlaceService placeService = new PlaceService(placePath);
    private RegistrationProcessor registrationProcessor = new RegistrationProcessor(userPath);
    private LoginProcessor loginProcessor = new LoginProcessor(userPath);

    public void createItem(String name, int id, double width, double length, double height) {
        Item item = itemService.createItem(name, id, width, length, height);
        items.add(item);
    }

    public void createPlace(String name, double width, double length, double height) {
        Place place = placeService.createPlace(name, width, length, height);
        places.add(place);
    }

    public void createUser(String login, String password) {
        User user = registrationProcessor.createUser(login, password);
        users.add(user);
    }

    public User loginUser(String login, String password) {
        User user = loginProcessor.login(login, password);
        return user;
    }

    public Item useOfTheItem(String name) {
        Item item = itemService.useOfTheItem(name);
        return item;
    }

    public Place useOfThePlace(String name) {
        Place place = placeService.useOfThePlace(name);
        return place;
    }

    public void isUser(String login, String password) {
        if (loginProcessor.isUser(login, password)) {
            System.out.println("Такой пользователь уже существует");
        }
    }

    public void readAll() {
        for (User user : userRepository.readFileWithItems(userPath)) {
            System.out.println(user.toString());
        }
        for (Item item : itemRepository.readFileWithItems(itemPath)) {
            System.out.println(item.toString());
        }
        for (Place place : placeRepository.readFileWithItems(placePath)) {
            System.out.println(place.toString());
        }
        actionRepository.readFile(actionPath);
    }


    public void save() throws IOException {
        actionRepository.writeAction(actionPath, log);
    }

    public void clean() {
        itemRepository.cleanFile(itemPath);
        placeRepository.cleanFile(placePath);
        userRepository.cleanFile(userPath);
        fileRepository.cleanFile(actionPath);
    }

    public void insert(Place place, Item item, User user) {
        if (item.volume() < place.volume()) {
            if (indexCheck(item, place)) {
                if (user != null) {
                    log.getActions().add("Пользователь " + user.getName() + " добавил предмет " + item.getName() + " в место " + place.getName());
                    double volume = place.volume() - item.volume();
                    volume = Math.cbrt(volume);
                    double width = volume;
                    double length = volume;
                    double height = volume;
                    listOfThingsInPlace.putOnTheList(item.getName(), place.getName());
                    placeService.overwritingPlace(place.getName(), new Place(place.getName(), width, length, height));
                    System.out.println("Пользователь " + user.getName() + " добавил предмет " + item.getName() + " на место " + place.getName());
                } else {
                    System.out.println("Этот пользователь не зарегестрирован в системе.");
                }
            } else {
                System.out.println("Предмету " + item.getName() + " не место на " + place.getName());
            }
        } else {
            System.out.println("Для предмета " + item.getName() + " нет места на " + place.getName());
        }
    }

    public boolean indexCheck(Item item, Place place) {
        for (int i : place.getTrueId()) {
            if (i == item.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean search(Item item, User user) {
        for (String integer : listOfThingsInPlace.getList().keySet()) {
            if (integer.equals(item.getName())) {
                return true;
            }
        }
        return false;
    }

    public void answerSearch(Place place, Item item, User user) {
        if (user != null) {
            log.getActions().add("Пользователь " + user.getName() + " искал предмет " + item.getName() + " в месте " + place.getName());
            if (search(item, user)) {
                System.out.println("Предмет " + item.getName() + " находится в месте " + place.getName());
                log.getActions().add("Пользователь " + user.getName() + " нашел предмет " + item.getName() + " в месте " + place.getName());
            } else {
                System.out.println("В месте " + place.getName() + " нет предмета " + item.getName());
                log.getActions().add("Пользователь " + user.getName() + " не нашел предмет " + item.getName() + " в месте " + place.getName());
            }
        } else {
            System.out.println("Этот пользователь не зарегестрирован в системе.");
        }
    }
    public void remove(Place place,Item item,User user) {
        if (user!=null) {
            if (search(item, user)) {
                listOfThingsInPlace.removeFromList(item.getName(),place.getName());
                double volume = place.volume() + item.volume();
                volume = Math.cbrt(volume);
                double width = volume;
                double length = volume;
                double height = volume;
                placeService.overwritingPlace(place.getName(), new Place(place.getName(), width, length, height));
                log.getActions().add("Пользователь " + user.getName() + " убрал предмет " + item.getName() + " из места " + place.getName());
                System.out.println("Пользователь " + user.getName() + " убрал предмет " + item.getName() + " из места " + place.getName());
            } else {
                System.out.println("Пользовать " + user.getName() + " не смог убрать предмет " + item.getName());
            }
        }else {
            System.out.println("Этот пользователь не зарегестрирован в системе.");
        }
    }

    public void searchInThisRoom(Item item, User user) {
        if (user != null) {
            log.getActions().add("Пользователь " + user.getName() + " искал предмет " + item.getName() + " по всей комнате");
            for (Place place : placeRepository.readFileWithItems(placePath)) {
                if (search(item, user)) {
                    answerSearch(place,item, user);
                }
            }
        }
    }

    public void randomPlace(Item item, User user, Place... places) {
        if (user != null) {
            for (Place place : places) {
                if (place.volume() > item.volume() && indexCheck(item,place)) {
                    insert(place,item, user);
                    break;
                }
            }
        } else {
            System.out.println("Этот пользователь не зарегестрирован в системе.");
        }
    }

    public void AllRoom(Item item, User user) {
        if (user != null) {
            for (Place place : placeRepository.readFileWithItems(placePath)) {
                if (place.volume() > item.volume() &&indexCheck(item,place)) {
                    insert(place,item, user);
                    break;
                }
            }
        } else {
            System.out.println("Этот пользователь не зарегестрирован в системе.");
        }
    }

    public void drugExpirationDate(Medicines medicine) {
        DrugService drugService = new DrugService(medicine);
        if (drugService.drugExpirationDate()) {
            System.out.println("Лекарство " + medicine.getName() + " пригодно к использованию");
        } else {
            System.out.println("У лекарства " + medicine.getName() + " уже истек срок годности");
        }
    }

    public void documentExpirationDate(Documents document) {
        DocumentService drugExpirationDate = new DocumentService(document);
        if (drugExpirationDate.documentExpirationDate()) {
            System.out.println("У документа " + this.document.getName() + " на данный момент срок годности не закончился");
        } else {
            System.out.println("У документа " + this.document.getName() + " срок годности уже истек");
        }
    }

    public ListOfThingsInPlace getListOfThingsInPlace() {
        return listOfThingsInPlace;
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
