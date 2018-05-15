package net.spiderpig.DataAccessObjects;

import net.spiderpig.IDataAccessObjects.ICategoryDAO;
import net.spiderpig.DatatTransferObjects.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete implementation of the Category data access object. Main purpose
 * is to
 */
@Repository("categoryDAO") // Registers the object so it would be recognized
// in our front-end code
public class CategoryDAO implements ICategoryDAO {

    /**
     * Data fields
     */
    private static List<Category> categories = new ArrayList<>(); // List of
    // categories in teh store

    /* Initialize the dummy data for testing */
    static {
        Category category = new Category();
        category.setId(1);
        category.setCatName("TVs");
        category.setCatDescription("Description for the TV category");
        category.setCatImageURL("CAT_1.png");
        category.setActive(true);

        categories.add(category);

        category = new Category();
        category.setId(2);
        category.setCatName("Smartphones");
        category.setCatDescription("Description for smartphone category");
        category.setCatImageURL("CAT_2.png");
        category.setActive(true);

        categories.add(category);

        category = new Category();
        category.setId(2);
        category.setCatName("Laptops");
        category.setCatDescription("Description for laptops category");
        category.setCatImageURL("CAT_3.png");
        category.setActive(true);

        categories.add(category);
    }

    /**
     * Return a list of categories in the store
     * @return
     */
    @Override
    public List<Category> listCategories() {
        return categories;
    }

    @Override
    public Category get(int id) {
        /* Iterate over each category we have */
        for (Category c : categories) {
            if (c.getId() == id) return c; // Matching category id
        }

        return null; // Not found
    }
}
