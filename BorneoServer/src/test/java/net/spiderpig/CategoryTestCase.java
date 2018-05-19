package net.spiderpig;

import net.spiderpig.DataAccessObjects.CategoryDAO;
import net.spiderpig.DataTransferObjects.Category;
import net.spiderpig.IDataAccessObjects.ICategoryDAO;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for categories
 */

public class CategoryTestCase {

    private static AnnotationConfigApplicationContext context; // Allows us
    // access to the entities (beans) we created

    private static ICategoryDAO categoryDAO; // Collection of categories
    private Category category;

    @BeforeClass // Init before the class initializes so data shared among tests
    public static void init() {
        context = new AnnotationConfigApplicationContext();
        context.scan("net.spiderpig");
        context.refresh();

        categoryDAO = (ICategoryDAO) context.getBean("categoryDAO"); // Get the
        // bean object
    }

    @Test
    public void testAddCategory() {
        category = new Category();
        category.setCatName("TVs");
        category.setCatDescription("Description for the TV category");
        category.setCatImageURL("CAT_1.png");

        assertEquals("Successfully added category inside the table", true,
                categoryDAO.add(category)); // Test if category is added
    }
}
