package tutorial.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tutorial.core.entities.Blog;
import tutorial.core.entities.BlogEntry;
import tutorial.core.exception.BlogNotFoundException;
import tutorial.core.repositories.BlogEntryRepo;
import tutorial.core.repositories.BlogRepo;
import tutorial.core.services.BlogService;
import tutorial.core.util.BlogEntryList;
import tutorial.core.util.BlogList;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepo blogRepo;

    @Autowired
    private BlogEntryRepo entryRepo;

    public BlogEntry createBlogEntry(Long blogId, BlogEntry data) {
        Blog blog = blogRepo.findBlog(blogId);
        if(blog == null)
        {
            throw new BlogNotFoundException();
        }
        BlogEntry entry = entryRepo.createBlogEntry(data);
        entry.setBlog(blog);
        return entry;
    }

    public BlogList findAllBlogs() {
        return new BlogList(blogRepo.findAllBlogs());
    }

    public BlogEntryList findAllBlogEntries(Long blogId) {
        Blog blog = blogRepo.findBlog(blogId);
        if(blog == null)
        {
            throw new BlogNotFoundException();
        }
        return new BlogEntryList(blogId, entryRepo.findByBlogId(blogId));
    }

    public Blog findBlog(Long id) {
        return blogRepo.findBlog(id);
    }
}
