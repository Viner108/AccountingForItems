package by.andrukovich.accounting;

import by.andrukovich.accounting.entity.action.ActionLog;
import by.andrukovich.accounting.entity.action.ActionLogMap;
import by.andrukovich.accounting.entity.action.ListOfThingsInPlace;
import by.andrukovich.accounting.entity.items.Documents;
import by.andrukovich.accounting.entity.items.Item;
import by.andrukovich.accounting.entity.items.ItemMap;
import by.andrukovich.accounting.entity.items.Medicines;
import by.andrukovich.accounting.entity.places.Place;
import by.andrukovich.accounting.entity.places.PlaceMap;
import by.andrukovich.accounting.entity.users.User;
import by.andrukovich.accounting.entity.users.UserMap;
import by.andrukovich.accounting.repository.*;
import by.andrukovich.accounting.repository.xml.ActionXmlRepository;
import by.andrukovich.accounting.repository.xml.ItemXmlRepository;
import by.andrukovich.accounting.repository.xml.PlaceXmlRepository;
import by.andrukovich.accounting.repository.xml.UserXmlRepository;
import by.andrukovich.accounting.service.*;
import by.andrukovich.accounting.service.user_service.LoginProcessor;
import by.andrukovich.accounting.service.user_service.RegistrationProcessor;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class AccountingForItemsApplication {
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
    private UserRepository userRepository = new UserRepository(userPath);
    private ItemRepository itemRepository = new ItemRepository(itemPath);
    private PlaceRepository placeRepository = new PlaceRepository(placePath);
    private ActionRepository actionRepository = new ActionRepository(actionPath);
    private ItemXmlRepository itemXmlRepository = new ItemXmlRepository(itemXmlPath);
    private PlaceXmlRepository placeXmlRepository = new PlaceXmlRepository(placeXmlPath);
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
    private List<Item> items = new ArrayList<Item>();
    private List<ActionLog> actionLogs = new ArrayList<>();
    private Repository<Item, ItemMap> itemRepository1 = new ItemRepository(itemPath);
//    private Repository<Item,ItemMap> itemRepository1=new ItemXmlRepository(itemXmlPath);
    private ItemService itemService = new ItemService(itemRepository1);
    private Repository<Place, PlaceMap> placeRepository1 = new PlaceRepository(placePath);
//    private Repository<Place,PlaceMap> placeRepository1=new PlaceXmlRepository(placeXMlPath);
    private PlaceService placeService = new PlaceService(placeRepository1);
    private Repository<User, UserMap> userRepository1 = new UserRepository(userPath);
//    private Repository<User,UserMap> userRepository1=new UserXmlRepository(userXmlPath);
    private UserService userService=new UserService(userRepository1);
    private LoginProcessor loginProcessor = new LoginProcessor( userRepository1);
    private RegistrationProcessor registrationProcessor = new RegistrationProcessor( userRepository1);

    public void createItem(String name, int id, double width, double length, double height) throws Exception {
        Item item = itemService.createItem(name, id, width, length, height);
        items.add(item);
        mapForItem.put(items.size(), item);
        itemMap.setItemMap(mapForItem);
        addInAction(1);
        writeXml();
    }

    public void createPlace(String name, double width, double length, double height) throws Exception {
        Place place = placeService.createPlace(name, width, length, height);
        places.add(place);
        mapForPlace.put(places.size(), place);
        placeMap.setPlaceMap(mapForPlace);
        addInAction(2);
        writeXml();
    }

    public void createUser(String login, String password) throws Exception {
        User user = userService.createUser(login, password);
        users.add(user);
        mapForUser.put(users.size(), user);
        userMap.setUserMap(mapForUser);
        addInAction(3);
    }

    private void addInAction(int x) {
        ActionLog actionLog = new ActionLog();
        if (x == 1) {
            actionLog.setActions("В программе создан новый предмет");
            actionLogs.add(actionLog);
            mapForAction.put(actionLogs.size(), actionLog);
            actionLogMap.setActionLogMap(mapForAction);
        } else if (x == 2) {
            actionLog.setActions("В программе создано новое место");
            actionLogs.add(actionLog);
            mapForAction.put(actionLogs.size(), actionLog);
            actionLogMap.setActionLogMap(mapForAction);
        } else if (x == 3) {
            actionLog.setActions("В программе создана новая учетную запись");
            actionLogs.add(actionLog);
            mapForAction.put(actionLogs.size(), actionLog);
            actionLogMap.setActionLogMap(mapForAction);
        }
    }

    public User loginUser(String login, String password) throws Exception {
        User user = userService.useOfTheUser(login, password);
        return user;
    }

    public Item useOfTheItem(String name) throws Exception {
        Item item = itemService.useOfTheItem(name);
        return item;
    }

    public Place useOfThePlace(String name) throws Exception {
        Place place = placeService.useOfThePlace(name);
        return place;
    }

    public void isUser(String login, String password) throws Exception {
        if (loginProcessor.isUser(login, password)) {
            System.out.println("Такой пользователь уже существует");
        }
    }

    public void writeXml() throws Exception {
        if (itemMap.getItemMap() != null) {
            itemXmlRepository.writeToFile((ArrayList<Item>) items, itemMap, false);
        }
        if (placeMap.getPlaceMap() != null) {
            placeXmlRepository.writeToFile((ArrayList<Place>) places, placeMap, false);
        }
        if (userMap.getUserMap() != null) {
            userXmlRepository.writeToFile((ArrayList<User>) users, userMap, false);
        }
        if (actionLogMap.getActionLogMap() != null) {
            actionXmlRepository.writeToFile((ArrayList<ActionLog>) actionLogs, actionLogMap, false);
        }
    }

    public Place useOfTheXmlPlace(String name) throws Exception {
        PlaceMap placeMap1 = placeXmlRepository.readFromFile( placeMap);
        Place place1 = placeMap1.getPlaceMap().values().stream().filter(place -> Objects.equals(place.getName(), name)).findFirst().get();
        return place1;
    }

    public Item useOfTheXmlItem(String name) throws Exception {
        ItemMap itemMap1 = itemXmlRepository.readFromFile( itemMap);
        Item item1 = itemMap1.getItemMap().values().stream().filter(item -> Objects.equals(item.getName(), name)).findFirst().get();
        return item1;
    }

    public User useOfTheXmlUser(String name) throws Exception {
        UserMap userMap1 = userXmlRepository.readFromFile( userMap);
        User user1 = userMap1.getUserMap().values().stream().filter(user -> Objects.equals(user.getName(), name)).findFirst().get();
        return user1;
    }

    public void readAll() {
        for (User user : userRepository.readFileWithItems()) {
            System.out.println(user.toString());
        }
        for (Item item : itemRepository.readFileWithItems()) {
            System.out.println(item.toString());
        }
        for (Place place : placeRepository.readFileWithItems()) {
            System.out.println(place.toString());
        }
        actionRepository.readFile(actionPath);
    }


    public void save() throws IOException {
        actionRepository.writeAction(actionPath, log);
    }

    public void clean() {
        itemRepository.cleanFile();
        placeRepository.cleanFile();
        userRepository.cleanFile();
        actionRepository.cleanFile();
    }

    public void insert(Place place, Item item, User user) throws JAXBException, Exception {
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

    public void remove(Place place, Item item, User user) throws JAXBException, Exception {
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
            for (Place place : placeRepository.readFileWithItems()) {
                if (search(item, user)) {
                    answerSearch(place, item, user);
                }
            }
        }
    }

    public void randomPlace(Item item, User user, Place... places) throws JAXBException, Exception {
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

    public void AllRoom(Item item, User user) throws JAXBException, Exception {
        if (user != null) {
            for (Place place : placeRepository.readFileWithItems()) {
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
