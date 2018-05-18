package net.spiderpig.IDataAccessObjects;

import net.spiderpig.DataTransferObjects.Category;

import java.util.List;

/**
 * The interface for the category data access object. This holds multiple
 * categories.
 */
public interface ICategoryDAO {

    /**
     * Returns a list of all the categories in the store
     * @return
     *      A list of categories in the store.
     */
    List<Category> listCategories();

    /**
     * Get a specific category by ID
     * @param id - id of the category
     * @return - the Category object
     */
    Category get(int id);
}
