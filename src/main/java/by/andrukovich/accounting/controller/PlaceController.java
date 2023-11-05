package by.andrukovich.accounting.controller;

import by.andrukovich.accounting.entify.places.Place;
import by.andrukovich.accounting.service.PlaceService;
import by.andrukovich.accounting.entify.places.PlaceMap;
import by.andrukovich.accounting.repository.PlaceRepository;
import by.andrukovich.accounting.repository.Repository;
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
