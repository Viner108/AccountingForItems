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
        LocalDate date = null;
        if (medicine.getDays() != 0) {
            date = medicine.getDateOfPurchase().plusDays(medicine.getDays());
        } else if (medicine.getMonths() != 0) {
            date = medicine.getDateOfPurchase().plusMonths(medicine.getMonths());
        } else if (medicine.getYears() != 0) {
            date = medicine.getDateOfPurchase().plusYears(medicine.getYears());
        }
        if (nowDate.isBefore(date)) {
            return true;
        }
        return false;
    }
}
