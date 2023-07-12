package accounting.service;

import accounting.items.Documents;

import java.time.LocalDate;

public class DocumentService {
    private Documents document;

    public DocumentService(Documents document) {
        this.document = document;
    }

    public boolean documentExpirationDate() {
        LocalDate nowDate = LocalDate.now();
        LocalDate date = null;
        if (this.document.getDays() != 0) {
            date = this.document.getDateOfPurchase().plusDays(this.document.getDays());
        } else if (this.document.getMonths() != 0) {
            date = this.document.getDateOfPurchase().plusMonths(this.document.getMonths());
        } else if (this.document.getYears() != 0) {
            date = this.document.getDateOfPurchase().plusYears(this.document.getYears());
        }
        if (nowDate.isBefore(date)) {
            return true;
        }
        return false;
    }
}
