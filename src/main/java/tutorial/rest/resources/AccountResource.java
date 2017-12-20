package tutorial.rest.resources;

import org.springframework.hateoas.ResourceSupport;
import tutorial.core.entities.Account;

public class AccountResource extends ResourceSupport{

    private String name;
    private String password;

    public Account toAccount() {
        Account account = new Account();
        account.setName(this.name);
        account.setPassword(this.password);
        return account;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public class BlogEntryResource {
    }
}
