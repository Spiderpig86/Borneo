package net.spiderpig.dao;

import net.spiderpig.dto.Category;

import java.util.List;

/**
 * The interface for the category data access object.
 */
public interface ICategoryDAO {

    /**
     * Returns a list of all the categories in the store
     * @return
     *      A list of categories in the store.
     */
    List<Category> listCategories();
}
