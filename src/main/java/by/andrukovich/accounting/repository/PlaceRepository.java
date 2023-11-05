package by.andrukovich.accounting.repository;

import by.andrukovich.accounting.entify.places.Place;
import by.andrukovich.accounting.entify.places.PlaceMap;

import java.nio.file.Path;

public class PlaceRepository extends FileRepository<Place, PlaceMap> {
    public PlaceRepository(Path path) {
        super(path);
    }
}
