package tutorial.rest.resources;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tutorial.core.entities.Account;
import tutorial.rest.mvc.AccountController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class AccountResourceAsm extends ResourceAssemblerSupport<Account,AccountResource> {

    public AccountResourceAsm() {
        super(AccountController.class, AccountResource.class);
    }


    public AccountResource toResource(Account account) {
        AccountResource accountResource = new AccountResource();
        accountResource.setName(account.getName());
        accountResource.setPassword(account.getPassword());
        accountResource.add(linkTo(methodOn(AccountController.class).getAccount(account.getId())).withSelfRel());
        return accountResource;
    }
}
