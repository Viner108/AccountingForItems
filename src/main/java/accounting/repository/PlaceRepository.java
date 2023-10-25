package accounting.repository;

import accounting.entify.places.Place;
import accounting.entify.places.PlaceMap;

import java.nio.file.Path;

public class PlaceRepository extends FileRepository<Place, PlaceMap> {
    public PlaceRepository(Path path) {
        super(path);
    }
}
