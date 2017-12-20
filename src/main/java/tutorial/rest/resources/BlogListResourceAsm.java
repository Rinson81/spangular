package tutorial.rest.resources;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import tutorial.core.util.BlogList;
import tutorial.rest.mvc.BlogController;

public class BlogListResourceAsm extends ResourceAssemblerSupport<BlogList, BlogListResource> {

    public BlogListResourceAsm()
    {
        super(BlogController.class, BlogListResource.class);
    }

    public BlogListResource toResource(BlogList blogList) {
        BlogListResource res = new BlogListResource();
        res.setBlogs(new BlogResourceAsm().toResources(blogList.getBlogs()));
        return res;
    }
}