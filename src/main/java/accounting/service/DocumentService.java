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
        if (nowDate.isBefore(document.getValidByDate())) {
            return true;
        }
        return false;
    }
}
