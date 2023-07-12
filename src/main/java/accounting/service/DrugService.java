package accounting.service;

import accounting.items.Medicines;

import java.time.LocalDate;

public class DrugService {
    private Medicines medicine;

    public DrugService(Medicines medicines) {
        this.medicine = medicines;
    }

    public boolean drugExpirationDate() {
        LocalDate nowDate = LocalDate.now();
        if (nowDate.isBefore(medicine.getValidByDate())) {
            return true;
        }
        return false;
    }
}
