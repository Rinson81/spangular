package tutorial.mvc;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tutorial.core.entities.Blog;
import tutorial.core.entities.BlogEntry;
import tutorial.core.exception.BlogExistsException;
import tutorial.core.services.BlogEntryService;
import tutorial.core.services.BlogService;
import tutorial.rest.mvc.BlogEntryController;

import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class BlogEntryControllerTest {

    @InjectMocks
    private BlogEntryController blogEntryController;

    @Mock
    private BlogEntryService blogEntryService;

    @Mock
    private BlogService blogService;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(blogEntryController).build();

    }

    @Test
    public void getExistingBlogEntryTest() throws Exception {}

}
