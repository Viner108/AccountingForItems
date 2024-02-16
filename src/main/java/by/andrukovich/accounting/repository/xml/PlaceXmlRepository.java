package by.andrukovich.accounting.repository.xml;

import by.andrukovich.accounting.entity.places.Place;
import by.andrukovich.accounting.entity.places.PlaceMap;

import java.nio.file.Path;

public class PlaceXmlRepository extends FileXmlRepository<Place,PlaceMap>{
    public PlaceXmlRepository(Path path) {
        super(path);
    }
}
