package net.spiderpig.IDataAccessObjects;

import net.spiderpig.DataTransferObjects.Product;

import java.util.List;

/**
 * Collection of products in the store
 */
public interface IProductDAO {

    /**
     * Get the product by ID
     * @param productId - ID of the product
     * @return
     *      The product with matching ID
     */
    Product get(int productId);

    /**
     * List all products
     * @return
     */
    List<Product> list();

    /**
     * Add product to database
     * @param product
     * @return
     *      Return if product was added successfully
     */
    boolean add(Product product);

    /**
     * Update product in database
     * @param product
     * @return
     *      Return if product was updated successfully
     */
    boolean update(Product product);

    /**
     * Delete product in database (marks as inactive)
     * @param product
     * @return
     *      Returns if product was marked inactive
     */
    boolean delete(Product product);

    /* Store methods */

    /**
     * List all active products
     * @return
     */
    List<Product> listActiveProducts();

    /**
     * List all active products by category
     * @param categoryId
     * @return
     */
    List<Product> listActiveProductsByCategory(int categoryId);

    /**
     * Get the latest active product by amount
     * @param count - how many prducts to retrieve
     * @return
     */
    List<Product> getLatestActiveProducts(int count);

}
