package tutorial.core.services;

import tutorial.core.entities.Account;
import tutorial.core.entities.Blog;
import tutorial.core.exception.AccountExistsException;
import tutorial.core.util.AccountList;
import tutorial.core.util.BlogList;

public interface AccountService {
    public Account findAccount(Long id);
    public Account createAccount(Account data);
    public Blog createBlog(Long accountId, Blog data);
    public BlogList findBlogsByAccount(Long accountId);
    public AccountList findAllAccounts();
    public Account findByAccountName(String name);
}
