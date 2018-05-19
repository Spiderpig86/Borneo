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

    /**
     * Add to category.
     * INSERT INTO category (name, description, image_url, is_active) VALUES ('Laptop', 'Laptop description', 'CAT_4.png', true);
     */
//    @Test
//    public void testAddCategory() {
//        category = new Category();
//        category.setCatName("TVs");
//        category.setCatDescription("Description for the TV category");
//        category.setCatImageURL("CAT_1.png");
//
//        assertEquals("Successfully added category inside the table", true,
//                categoryDAO.add(category)); // Test if category is added
//    }

//    @Test
//    public void testGetCategory() {
//        category = categoryDAO.get(3); // Get the third category
//        assertEquals("Successfully fetched category from table", "Tablet",
//                category.getCatName()); // Check for matching category name
//    }

//    @Test
//    public void testUpdateCategory() {
//        category = categoryDAO.get(1);
//        category.setCatName("Television"); // Update category name
//        assertEquals("Successfully updated category in table", true,
//                categoryDAO.update(category));
//    }

//    @Test
//    public void testDeleteCategory() {
//        category = categoryDAO.get(4);
//        category.setCatName("Television"); // Update category name
//        assertEquals("Successfully deleted category in table", true,
//                categoryDAO.delete(category));
//    }

//    @Test
//    public void testListCategory() {
//        assertEquals("Successfully fetched list of active categories", 3,
//                categoryDAO.listCategories().size());
//    }

    /**
     * Test all functionality of database operations
     *
     * Before testing:
     *      Run DROP TABLE category
     *      Run the table creation query
     */
    @Test
    public void testCRUDCategory() {

        /* Add entries to DB */
        category = new Category();
        category.setCatName("TVs");
        category.setCatDescription("Description for the TV category");
        category.setCatImageURL("CAT_1.png");
        assertEquals("Successfully added category inside the table", true,
                categoryDAO.add(category));

        category = new Category();
        category.setCatName("Smartphones");
        category.setCatDescription("Description for smartphone category");
        category.setCatImageURL("CAT_2.png");
        assertEquals("Successfully added category inside the table", true,
                categoryDAO.add(category));

        category = new Category();
        category.setCatName("Laptops");
        category.setCatDescription("Description for laptops category");
        category.setCatImageURL("CAT_3.png");
        assertEquals("Successfully added category inside the table", true,
                categoryDAO.add(category));

        /* Fetch and update category */
        category = categoryDAO.get(1);
        category.setCatName("Television"); // Update category name
        assertEquals("Successfully updated category in table", true,
                categoryDAO.update(category));

        /* Delete category */
        category = categoryDAO.get(1);
        category.setCatName("Television"); // Update category name
        assertEquals("Successfully deleted category in table", true,
                categoryDAO.delete(category));

        /* Test List */
        assertEquals("Successfully fetched list of active categories", 2,
                categoryDAO.listCategories().size());

    }

}
