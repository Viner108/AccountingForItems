package accounting.controller;

import accounting.AccountingForItemsApplication;
import accounting.entify.places.Place;
import accounting.entify.places.PlaceMap;
import accounting.repository.PlaceRepository;
import accounting.repository.Repository;
import accounting.service.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController()
@RequestMapping("/place")
public class PlaceController {
    private Path placePath = Path.of("library", "Place.java");
    private Repository<Place, PlaceMap> placeRepository1 = new PlaceRepository(placePath);
    private PlaceService placeService;

    public PlaceController() {
        placeService = new PlaceService(placeRepository1);
    }
    @GetMapping("/getPlace")
    public Place getPlace(@RequestParam(name = "place") String placeName) throws Exception {
        return placeService.useOfThePlace(placeName);
    }

    @PostMapping("/postPlace")
    public Place postPlace(@RequestBody Body body) throws Exception {
        placeService.createPlace(body.name, body.width, body.length, body.height);
        return placeService.useOfThePlace(body.name);
    }

    static class Body {
        public String name;
        public double width;
        public double length;
        public double height;
    }
}
