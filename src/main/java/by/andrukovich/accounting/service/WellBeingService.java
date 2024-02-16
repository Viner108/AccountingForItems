package by.andrukovich.accounting.service;

import by.andrukovich.accounting.entity.DTO;
import by.andrukovich.accounting.entity.UserHealth;
import by.andrukovich.accounting.repository.UserHealthRepository;
import by.andrukovich.accounting.repository.WellBeingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WellBeingService {
    private WellBeingRepository repository=new WellBeingRepository();
    @Autowired
    public UserHealthRepository userHealthRepository;
    public DTO createDTO(String pressure, String headAche) throws Exception{
        DTO dto = new DTO(pressure,headAche);
        repository.writeToFile(dto);
        UserHealth userHealth=new UserHealth();
        userHealth.setId(String.valueOf(UUID.randomUUID()));
        userHealth.setPressure(pressure);
        userHealth.setHeadAche(headAche);
        userHealthRepository.save(userHealth);
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
