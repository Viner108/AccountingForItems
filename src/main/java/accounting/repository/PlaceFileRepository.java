package accounting.repository;

import accounting.entify.places.Place;

import java.nio.file.Path;

public class PlaceFileRepository extends FileRepository<Place> {
    public PlaceFileRepository(Path path) {
        super(path);
    }
}
