package by.andrukovich.accounting.service;

import by.andrukovich.accounting.entify.DTO;
import by.andrukovich.accounting.repository.WellBeingRepository;
import org.springframework.stereotype.Service;

@Service
public class WellBeingService {
    private WellBeingRepository repository;
    public DTO createDTO(String pressure, String headAche) throws Exception{
        DTO dto = new DTO(pressure,headAche);
        repository.writeToFile(dto);
        return dto;
    }
    public DTO useOfTheDTO(String pressure, String headAche){
        if(repository.readFileWithItems().size()!=0){
            return repository.readFileWithItems().stream().filter(dto -> dto.getPressure().equals(pressure)&& dto.getHeadAche().equals(headAche)).findFirst().get();
        }else {
            return new DTO("","");
        }
    }

}
