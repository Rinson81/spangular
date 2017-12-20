package tutorial.core.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import tutorial.core.entities.Account;
import tutorial.core.exception.AccountExistsException;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class) //JUnit RunWith annotation which allows injection using SpringJUnit classrunner
@ContextConfiguration("classpath:spring/business-config.xml") //allows specifiying configuration for injection to beans
//Maven looks resources class to find classpath resources, so create the folder in resources directory
public class AccountRepoTest {

    @Autowired
    private AccountRepo accountRepo; //Needs to do components scan for AccountRepo's package for Autowire to work

    Account account;

    @Before
    @Transactional
    @Rollback(false)
    public void setUp() throws AccountExistsException {
        account = new Account();
        account.setName("name");
        account.setPassword("password");
        accountRepo.createAccount(account);
    }

    @Test
    @Transactional
    public void testFind(){
        assertNotNull(accountRepo.findAccount(account.getId()));
    }
}
