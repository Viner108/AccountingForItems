package accounting.controller;

import accounting.AccountingForItemsApplication;
import accounting.entify.places.Place;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/repository")
public class RepositoryController <T>{
    private AccountingForItemsApplication accountingForItemsApplication;

    public RepositoryController() {
        accountingForItemsApplication = new AccountingForItemsApplication();
    }
}
