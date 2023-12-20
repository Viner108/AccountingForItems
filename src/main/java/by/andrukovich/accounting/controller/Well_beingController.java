package by.andrukovich.accounting.controller;

import by.andrukovich.accounting.entify.DTO;
import by.andrukovich.accounting.entify.places.Place;
import by.andrukovich.accounting.service.UserService;
import by.andrukovich.accounting.service.Well_beingService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/addresses/")
public class Well_beingController{

    private Well_beingService service;
    @GetMapping("q3")
    public DTO getAndroid(@RequestParam(name = "pressure") String pressure,
                          @RequestParam(name = "headAche") String headAche) throws Exception {
        DTO dto=service.useOfTheDTO(pressure);
        return dto;
    }

    @PostMapping("q2/2")
    public DTO postPlace(@RequestBody Body body) throws Exception {
        DTO dto=service.createDTO(body.pressure, body.headAche);
        return dto;
    }
    static class Body{
        public String pressure;
        public String headAche;
    }
}
