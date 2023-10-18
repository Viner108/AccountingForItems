package accounting;

import accounting.entify.action.ActionLogMap;
import accounting.entify.items.Documents;
import accounting.entify.items.Item;
import accounting.entify.items.ItemMap;
import accounting.entify.items.Medicines;
import accounting.entify.places.Place;
import accounting.entify.places.PlaceMap;
import accounting.entify.places.PlaceWrapper;
import accounting.entify.users.UserMap;
import accounting.repository.ActionRepository;
import accounting.entify.action.ListOfThingsInPlace;
import accounting.repository.*;
import accounting.entify.action.ActionLog;
import accounting.repository.xml.ActionXmlRepository;
import accounting.repository.xml.ItemXmlRepository;
import accounting.repository.xml.PlaceXmlRepository;
import accounting.repository.xml.UserXmlRepository;
import accounting.service.DocumentService;
import accounting.service.DrugService;
import accounting.service.ItemService;
import accounting.service.PlaceService;
import accounting.service.user_service.LoginProcessor;
import accounting.service.user_service.RegistrationProcessor;
import accounting.entify.users.User;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountingForItemsApplication {
    private FileRepository fileRepository = new FileRepository();
    private UserRepository userRepository = new UserRepository();
    private ItemRepository itemRepository = new ItemRepository();
    private PlaceFileRepository placeFileRepository = new PlaceFileRepository();
    private ActionRepository actionRepository = new ActionRepository();
    private ActionLog log = new ActionLog();
    private ListOfThingsInPlace listOfThingsInPlace = new ListOfThingsInPlace();
    private Path itemXmlPath = Path.of("library", "Items.xml");
    private Path placeXmlPath = Path.of("library", "Places.xml");
    private Path userXmlPath = Path.of("library", "Users.xml");
    private Path actionXmlPath = Path.of("library", "Action.xml");
    private Path itemPath = Path.of("library", "Item.java");
    private Path placePath = Path.of("library", "Place.java");
    private Path userPath = Path.of("library", "User.java");
    private Path actionPath = Path.of("library", "Action.java");
    private ItemXmlRepository itemXmlRepository = new ItemXmlRepository(itemXmlPath);
    public PlaceXmlRepository placeXmlRepository = new PlaceXmlRepository(placeXmlPath);
    private UserXmlRepository userXmlRepository = new UserXmlRepository(userXmlPath);
    private ActionXmlRepository actionXmlRepository = new ActionXmlRepository(actionXmlPath);
    private ItemMap itemMap = new ItemMap();
    private PlaceMap placeMap = new PlaceMap();
    private UserMap userMap = new UserMap();
    private ActionLogMap actionLogMap = new ActionLogMap();
    private Map<Integer, Item> mapForItem = new HashMap<>();
    private Map<Integer, Place> mapForPlace = new HashMap<>();
    private Map<Integer, User> mapForUser = new HashMap<>();
    private Map<Integer, ActionLog> mapForAction = new HashMap<>();

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
    private List<ActionLog> actionLogs = new ArrayList<>();
    private ItemService itemService = new ItemService(itemXmlPath);
    private PlaceService placeService = new PlaceService(placeXmlPath);
    private RegistrationProcessor registrationProcessor = new RegistrationProcessor(userPath);
    private LoginProcessor loginProcessor = new LoginProcessor(userPath);

    public void createItem(String name, int id, double width, double length, double height) {
        Item item = itemService.createItem(name, id, width, length, height);
        items.add(item);
        mapForItem.put(items.size(), item);
        itemMap.setItemMap(mapForItem);
        addInAction(1);

    }

    public void createPlace(String name, double width, double length, double height) {
        Place place = placeService.createPlace(name, width, length, height);
        places.add(place);
        mapForPlace.put(places.size(), place);
        placeMap.setPlaceMap(mapForPlace);
        addInAction(2);
    }

    public void createUser(String login, String password) {
        User user = registrationProcessor.createUser(login, password);
        users.add(user);
        mapForUser.put(users.size(), user);
        userMap.setUserMap(mapForUser);
        addInAction(3);
    }

    private void addInAction(int x) {
        ActionLog actionLog =new ActionLog();
        if (x == 1) {
            actionLog.setActions("В программе создан новый предмет");
            actionLogs.add(actionLog);
            mapForAction.put(actionLogs.size(),actionLog);
            actionLogMap.setActionLogMap(mapForAction);
        } else if (x == 2) {
            actionLog.setActions("В программе создано новое место");
            actionLogs.add(actionLog);
            mapForAction.put(actionLogs.size(),actionLog);
            actionLogMap.setActionLogMap(mapForAction);
        } else if (x == 3) {
            actionLog.setActions("В программе создана новая учетную запись");
            actionLogs.add(actionLog);
            mapForAction.put(actionLogs.size(),actionLog);
            actionLogMap.setActionLogMap(mapForAction);
        }
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

    public void writeXml() throws JAXBException, Exception {
        itemXmlRepository.writeToXmlFile(itemMap);
        placeXmlRepository.writeToXmlFile(placeMap);
        userXmlRepository.writeToXmlFile(userMap);
        actionXmlRepository.writeToXmlFile(actionLogMap);
    }
    public PlaceMap readXmlPlace() throws JAXBException, Exception {
        PlaceMap placeMap1=placeXmlRepository.readFromFile(placeMap);
        return placeMap1;
    }

    public void readAll() {
        for (User user : userRepository.readFileWithItems(userPath)) {
            System.out.println(user.toString());
        }
        for (Item item : itemRepository.readFileWithItems(itemXmlPath)) {
            System.out.println(item.toString());
        }
        for (Place place : placeFileRepository.readFileWithItems(placeXmlPath)) {
            System.out.println(place.toString());
        }
        actionRepository.readFile(actionPath);
    }


    public void save() throws IOException {
        actionRepository.writeAction(actionPath, log);
    }

    public void clean() {
        itemRepository.cleanFile(itemXmlPath);
        placeFileRepository.cleanFile(placeXmlPath);
        userRepository.cleanFile(userPath);
        fileRepository.cleanFile(actionPath);
    }

    public void insert(Place place, Item item, User user) {
        if (item.volume() < place.volume()) {
            if (indexCheck(item, place)) {
                if (user != null) {
//                    log.getActions().add("Пользователь " + user.getName() + " добавил предмет " + item.getName() + " в место " + place.getName());
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
//        for (int i : place.getTrueId()) {
        if (1 == item.getId()) {
            return true;
        }
//        }
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
//            log.getActions().add("Пользователь " + user.getName() + " искал предмет " + item.getName() + " в месте " + place.getName());
            if (search(item, user)) {
                System.out.println("Предмет " + item.getName() + " находится в месте " + place.getName());
//                log.getActions().add("Пользователь " + user.getName() + " нашел предмет " + item.getName() + " в месте " + place.getName());
            } else {
                System.out.println("В месте " + place.getName() + " нет предмета " + item.getName());
//                log.getActions().add("Пользователь " + user.getName() + " не нашел предмет " + item.getName() + " в месте " + place.getName());
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
//                log.getActions().add("Пользователь " + user.getName() + " убрал предмет " + item.getName() + " из места " + place.getName());
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
//            log.getActions().add("Пользователь " + user.getName() + " искал предмет " + item.getName() + " по всей комнате");
            for (Place place : placeFileRepository.readFileWithItems(placeXmlPath)) {
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
            for (Place place : placeFileRepository.readFileWithItems(placeXmlPath)) {
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
        return itemXmlPath;
    }

    public Path getPlacePath() {
        return placeXmlPath;
    }


    public ItemXmlRepository getItemXmlRepository() {
        return itemXmlRepository;
    }

    public PlaceXmlRepository getPlaceXmlRepository() {
        return placeXmlRepository;
    }

    public UserXmlRepository getUserXmlRepository() {
        return userXmlRepository;
    }
}
