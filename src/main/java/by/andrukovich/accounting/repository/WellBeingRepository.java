package by.andrukovich.accounting.repository;

import by.andrukovich.accounting.entity.DTO;

import java.util.ArrayList;

public class WellBeingRepository {
    private ArrayList<DTO> dtoArrayList =new ArrayList<>();

    public ArrayList<DTO> readFileWithItems() {
        return dtoArrayList;
    }
    public void writeToFile(DTO dto) throws  Exception{
        dtoArrayList.add(dto);
    }
}
