package tutorial.core.repositories.jpa;

import org.springframework.stereotype.Repository;
import tutorial.core.entities.BlogEntry;
import tutorial.core.repositories.BlogEntryRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JpaBlogEntryRepo implements BlogEntryRepo {
    @PersistenceContext
    private EntityManager em;

    public BlogEntry findBlogEntry(Long id) {
        return em.find(BlogEntry.class, id);
    }

    public BlogEntry deleteBlogEntry(Long id) {
        BlogEntry entry = em.find(BlogEntry.class, id);
        em.remove(entry);
        return entry;
    }

    public BlogEntry updateBlogEntry(Long id, BlogEntry data) {
        BlogEntry entry = em.find(BlogEntry.class, id);
        entry.setTitle(data.getTitle());
        entry.setContent(data.getContent());
        return entry;
    }

    public BlogEntry createBlogEntry(BlogEntry data) {
        em.persist(data);
        return data;
    }

    public List<BlogEntry> findByBlogId(Long blogId) {
        Query query = em.createQuery("SELECT b FROM BlogEntry b WHERE b.blog.id=?1");
        query.setParameter(1, blogId);
        return query.getResultList();
    }
}
