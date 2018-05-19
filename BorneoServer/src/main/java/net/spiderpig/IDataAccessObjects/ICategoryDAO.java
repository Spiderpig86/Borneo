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
     * @return
     *      The Category object
     */
    Category get(int id);

    /**
     * Add a category to the data base.
     * @param category - category object we will be adding
     * @return
     *      Return status telling us if adding the category was successful or
     *      not
     */
    boolean add(Category category);

    /**
     * Update details of existing category
     * @param category - category to update
     * @return
     *      Success of updating
     */
    boolean update(Category category);

    /**
     * Delete a category from the database
     * @param category - category to delete
     * @return
     *      Success of deletion
     */
    boolean delete(Category category);
}
