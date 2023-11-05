package by.andrukovich.accounting.repository.xml;

import by.andrukovich.accounting.entify.places.Place;
import by.andrukovich.accounting.entify.places.PlaceMap;

import java.nio.file.Path;

public class PlaceXmlRepository extends FileXmlRepository<Place,PlaceMap>{
    public PlaceXmlRepository(Path path) {
        super(path);
    }
}
