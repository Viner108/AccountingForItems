package by.andrukovich.accounting.controller;

import by.andrukovich.accounting.entify.DTO;
import by.andrukovich.accounting.service.WellBeingService;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/android/")
public class WellBeingController{

    private WellBeingService service=new WellBeingService();


    @GetMapping("getDTO")
    public DTO getAndroid(@RequestParam(name = "pressure") String pressure,
                          @RequestParam(name = "headAche") String headAche) throws Exception {
        DTO dto=service.useOfTheDTO(pressure,headAche);
        return dto;
    }

    @PostMapping("postDTO")
    public DTO postPlace(@RequestBody DTO dto1) throws Exception {
        DTO dto=service.createDTO(dto1.getPressure(), dto1.getHeadAche());
        return dto;
    }

}
