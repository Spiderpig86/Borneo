package net.spiderpig.DataAccessObjects;

import net.spiderpig.DataTransferObjects.Product;
import net.spiderpig.IDataAccessObjects.IProductDAO;

import java.util.List;

/**
 * Serves as the collection of products
 */
public class ProductDAO implements IProductDAO {

    /**
     * Get the product by ID
     *
     * @param productId - ID of the product
     * @return The product with matching ID
     */
    @Override
    public Product get(int productId) {
        return null;
    }

    /**
     * List all products
     *
     * @return
     */
    @Override
    public List<Product> list() {
        return null;
    }

    /**
     * Add product to database
     *
     * @param product
     * @return Return if product was added successfully
     */
    @Override
    public boolean add(Product product) {
        return false;
    }

    /**
     * Update product in database
     *
     * @param product
     * @return Return if product was updated successfully
     */
    @Override
    public boolean update(Product product) {
        return false;
    }

    /**
     * Delete product in database (marks as inactive)
     *
     * @param product
     * @return Returns if product was marked inactive
     */
    @Override
    public boolean delete(Product product) {
        return false;
    }

    /**
     * List all active products
     *
     * @return
     */
    @Override
    public List<Product> listActiveProducts() {
        return null;
    }

    /**
     * List all active products by category
     *
     * @param categoryId
     * @return
     */
    @Override
    public List<Product> listActiveProductsByCategory(int categoryId) {
        return null;
    }

    /**
     * Get the latest active product by amount
     *
     * @param count - how many prducts to retrieve
     * @return
     */
    @Override
    public List<Product> getLatestActiveProducts(int count) {
        return null;
    }
}
