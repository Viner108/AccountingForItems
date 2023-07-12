package accounting.service;

import accounting.places.Place;
import accounting.repository.PlaceRepository;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

public class PlaceService implements Serializable {
    private PlaceRepository fileRepository = new PlaceRepository();
    private Path path;
    private ArrayList<Place> places = new ArrayList<>();
    public PlaceService(Path path) {
        this.path = path;
    }

    public Place createPlace(String name, double width, double length, double height){
        Place place=new Place(name,width,length,height);
        places.add(place);
        fileRepository.writeObject(path, places,false);
        return place;
    }
    public Place useOfThePlace(String name){
        Place place1=null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            ArrayList<Place> places1=((ArrayList<Place>) ois.readObject());
            place1=places1.stream().filter(place -> Objects.equals(place.getName(),name)).findFirst().get();
//            for (Place place:places1){
//                if(Objects.equals(place.getName(), name)){
//                    place1=place;
//                }
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return place1;
    }
    public void overwritingPlace(String name,Place newPlace){
        ArrayList<Place> places1=null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            places1=((ArrayList<Place>) ois.readObject());
            for (Place place:places1){
                if(Objects.equals(place.getName(), name)){
                    places1.remove(place);
                    places1.add(newPlace);
                }
            }
            fileRepository.writeObject(path,places1,false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
