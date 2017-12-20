package tutorial.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tutorial.core.entities.BlogEntry;
import tutorial.core.repositories.BlogEntryRepo;
import tutorial.core.services.BlogEntryService;

@Service
@Transactional
public class BlogEntryServiceImpl implements BlogEntryService {

    @Autowired
    private BlogEntryRepo entryRepo;

    public BlogEntry findBlogEntry(Long id) {
        return entryRepo.findBlogEntry(id);
    }

    public BlogEntry deleteBlogEntry(Long id) {
        return entryRepo.deleteBlogEntry(id);
    }

    public BlogEntry updateBlogEntry(Long id, BlogEntry data) {
        return entryRepo.updateBlogEntry(id, data);
    }
}
