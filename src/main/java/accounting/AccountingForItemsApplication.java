package accounting;

import accounting.entify.items.Documents;
import accounting.entify.items.Item;
import accounting.entify.items.Medicines;
import accounting.entify.places.Place;
import accounting.repository.ActionRepository;
import accounting.entify.action.ListOfThingsInPlace;
import accounting.entify.items.*;
import accounting.repository.*;
import accounting.entify.places.*;
import accounting.entify.action.ActionLog;
import accounting.service.DocumentService;
import accounting.service.DrugService;
import accounting.service.ItemService;
import accounting.service.PlaceService;
import accounting.service.user_service.LoginProcessor;
import accounting.service.user_service.RegistrationProcessor;
import accounting.entify.users.User;

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

    public void remove(Place place, Item item, User user) {
        if (user != null) {
            if (search(item, user)) {
                listOfThingsInPlace.removeFromList(item.getName(), place.getName());
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
        } else {
            System.out.println("Этот пользователь не зарегестрирован в системе.");
        }
    }

    public void searchInThisRoom(Item item, User user) {
        if (user != null) {
            log.getActions().add("Пользователь " + user.getName() + " искал предмет " + item.getName() + " по всей комнате");
            for (Place place : placeRepository.readFileWithItems(placePath)) {
                if (search(item, user)) {
                    answerSearch(place, item, user);
                }
            }
        }
    }

    public void randomPlace(Item item, User user, Place... places) {
        if (user != null) {
            for (Place place : places) {
                if (place.volume() > item.volume() && indexCheck(item, place)) {
                    insert(place, item, user);
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
                if (place.volume() > item.volume() && indexCheck(item, place)) {
                    insert(place, item, user);
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
            System.out.println("У документа " + document.getName() + " на данный момент срок годности не закончился");
        } else {
            System.out.println("У документа " + document.getName() + " срок годности уже истек");
        }
    }

    public ListOfThingsInPlace getListOfThingsInPlace() {
        return listOfThingsInPlace;
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


    public Path getItemPath() {
        return itemPath;
    }

    public Path getPlacePath() {
        return placePath;
    }

}
