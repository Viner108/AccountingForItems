package by.andrukovich.accounting.service;

import by.andrukovich.accounting.entify.DTO;
import by.andrukovich.accounting.entify.items.Item;
import by.andrukovich.accounting.repository.Well_beingRepository;

import javax.xml.bind.JAXBException;
import java.util.Objects;

public class Well_beingService {
    private Well_beingRepository repository;
    public DTO createDTO(String pressure, String headAche) throws JAXBException, Exception{
        DTO dto = new DTO(pressure,headAche);
        return dto;
    }
    public DTO useOfTheDTO(String pressure){
        if(repository.dtoArrayList.size()!=0){
            return repository.dtoArrayList.stream().filter(dto -> Objects.equals(dto.getPressure(), pressure)).findFirst().get();
        }else {
            return new DTO("","");
        }
    }

}
