package net.spiderpig.DataAccessObjects;

import net.spiderpig.IDataAccessObjects.ICategoryDAO;
import net.spiderpig.DataTransferObjects.Category;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection of category beans supporting CRUD methods.
 */
@Repository("categoryDAO") // Registers the object so it would be recognized
// in our front-end code
@Transactional // This method runs in a transaction context (managed by Spring)
public class CategoryDAO implements ICategoryDAO {

    @Autowired
    private SessionFactory sessionFactory; // Used for creating sessions

    /**
     * Data fields
     */
    private static List<Category> categories = new ArrayList<>(); // List of
    // categories in teh store

    /* Initialize the dummy data for testing */
//    static {
//        Category category = new Category();
//        category.setCatName("TVs");
//        category.setCatDescription("Description for the TV category");
//        category.setCatImageURL("CAT_1.png");
//        category.setActive(true);
//
//        categories.add(category);
//
//        category = new Category();
//        category.setCatName("Smartphones");
//        category.setCatDescription("Description for smartphone category");
//        category.setCatImageURL("CAT_2.png");
//        category.setActive(true);
//
//        categories.add(category);
//
//        category = new Category();
//        category.setCatName("Laptops");
//        category.setCatDescription("Description for laptops category");
//        category.setCatImageURL("CAT_3.png");
//        category.setActive(true);
//
//        categories.add(category);
//    }

    /**
     * Return a list of categories in the store
     * @return
     */
    @Override
    public List<Category> listCategories() {
        String selectActiveCategory = "FROM Category WHERE is_active = :active";
        // Must use entity name, not the table name (this is HQL not SQL)
        // Selects all active categories

        Query query = sessionFactory.getCurrentSession().createQuery
                (selectActiveCategory); // Create query for db
        query.setParameter("active", true); // Fetching parameter where
        // value is true

        return query.getResultList(); // Get list of entries that are active
    }

    @Override
    public Category get(int id) {
        return sessionFactory.getCurrentSession().get(Category.class, Integer
                .valueOf(id)); // Get a single category using the autowired
        // session factory (Boxing is needed since method only takes in object)
    }

    /**
     * Add a category to the data base.
     *
     * @param category - category object we will be adding
     * @return Return status telling us if adding the category was successful or
     * not
     */
    @Override
    public boolean add(Category category) {
        try {
            // Add the category to the database table using the session factory
            sessionFactory.getCurrentSession().persist(category); // Persists
            // the category inside the database

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Update details of existing category
     *
     * @param category - category to update
     * @return Success of updating
     */
    @Override
    public boolean update(Category category) {
        try {
            sessionFactory.getCurrentSession().update(category); // Updates
            // with new category object

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete a category from the database
     *
     * @param category - category to delete
     * @return Success of deletion
     */
    @Override
    public boolean delete(Category category) {
        category.setActive(false); // Set the category as false (so it won't
        // appear)

        try {
            sessionFactory.getCurrentSession().update(category); // Updates
            // with new category object
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
