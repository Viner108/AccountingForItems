package accounting.service;

import accounting.entify.places.Place;
import accounting.repository.PlaceFileRepository;
import accounting.repository.xml.PlaceXmlRepository;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

public class PlaceService implements Serializable {
    private PlaceFileRepository fileRepository = new PlaceFileRepository();
//    private PlaceXmlRepository repository = new PlaceXmlRepository();
    private ArrayList<Place> places = new ArrayList<>();
    private Path path;

    public PlaceService(Path path) {
        this.path = path;
    }

    public Place createPlace(String name, double width, double length, double height) {
        Place place = new Place(name, width, length, height);
        places.add(place);
        fileRepository.writeWithAppend(path, places, false);
        return place;
    }

    public Place useOfThePlace(String name) {
        Place place1 = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            ArrayList<Place> places1 = ((ArrayList<Place>) ois.readObject());
            place1 = places1.stream().filter(place -> Objects.equals(place.getName(), name)).findFirst().get();
//            for (Place place:places1){
//                if(Objects.equals(place.getName(), name)){
//                    place1=place;
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return place1;
    }

    public void overwritingPlace(String name, Place newPlace) {
        ArrayList<Place> places1 = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            places1 = ((ArrayList<Place>) ois.readObject());
            for (Place place : places1) {
                if (Objects.equals(place.getName(), name)) {
                    places1.remove(place);
                    places1.add(newPlace);
                }
            }
            fileRepository.writeWithAppend(path, places1, false);
//            repository.writeWithAppend(path, places1, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
