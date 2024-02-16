package by.andrukovich.accounting.service;

import by.andrukovich.accounting.entity.items.Documents;

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
