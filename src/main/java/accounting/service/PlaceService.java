package accounting.service;

import accounting.entify.items.Item;
import accounting.entify.items.ItemMap;
import accounting.entify.places.Place;
import accounting.entify.places.PlaceMap;
import accounting.repository.Repository;

import javax.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PlaceService implements Serializable {
    private Path placePath = Path.of("library", "Place.java");
    private Repository repository;
    private ArrayList<Place> places = new ArrayList<>();
    private PlaceMap placeMap=new PlaceMap();
    private Map<Integer, Place> mapForPlace = new HashMap<Integer, Place>();
    public PlaceService(Repository<Place,PlaceMap> repository) {
        this.repository=repository;
    }

    public Place createPlace(String name, double width, double length, double height) throws JAXBException, Exception{
        Place place = new Place(name, width, length, height);
        places.add(place);
        mapForPlace.put(places.size(), place);
        placeMap.setPlaceMap(mapForPlace);
        repository.writeToFile( places,placeMap, false);
        return place;
    }

    public Place useOfThePlace(String name) throws Exception {
        Place place1 = null;
        Place place2 = null;
        Place place3 = null;
        ArrayList<Place> places2 = repository.readFileWithItems();
        PlaceMap placeMap1 = (PlaceMap) repository.readFromFile(placeMap);
        if(places2.size()!=0) {
            place1 = places2.stream().filter(place -> Objects.equals(place.getName(), name)).findFirst().get();
        }
        if(placeMap1.getPlaceMap() !=null) {
            place2 = placeMap1.getPlaceMap().values().stream().filter(item -> Objects.equals(item.getName(), name)).findFirst().get();
        }
        if (place1 != null) {
            return place1;
        } else if (place2 != null) {
            return place2;
        } else return place3;
    }

    public void overwritingPlace(String name, Place newPlace) throws JAXBException, Exception{
        ArrayList<Place> places1 = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(placePath.toFile()))) {
            places1 = ((ArrayList<Place>) ois.readObject());
            for (Place place : places1) {
                if (Objects.equals(place.getName(), name)) {
                    places1.remove(place);
                    places1.add(newPlace);
                }
            }
            repository.writeToFile( places1,placeMap, false);
//            repository.writeWithAppend(path, places1, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
