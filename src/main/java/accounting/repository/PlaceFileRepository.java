package accounting.repository;

import accounting.entify.places.Place;
import accounting.entify.places.PlaceMap;

import java.nio.file.Path;

public class PlaceFileRepository extends FileRepository<Place, PlaceMap> {
    public PlaceFileRepository(Path path) {
        super(path);
    }
}
