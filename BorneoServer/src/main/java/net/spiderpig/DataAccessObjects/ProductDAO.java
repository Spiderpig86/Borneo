package net.spiderpig.DataAccessObjects;

import net.spiderpig.DataTransferObjects.Product;
import net.spiderpig.IDataAccessObjects.IProductDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Serves as the collection of products
 */
@Repository("productDAO") // Expose to front-end
@Transactional // All methods run in a transaction, Spring will handle this
public class ProductDAO implements IProductDAO {

    @Autowired
    private SessionFactory sessionFactory; // Get the session factory
    // responsible for current user session

    /**
     * Get the product by ID
     *
     * @param productId - ID of the product
     * @return The product with matching ID
     */
    @Override
    public Product get(int productId) {
        try {
            return sessionFactory
                    .getCurrentSession()
                    .get(Product.class, Integer.valueOf(productId)); // Get a
            // product object based on the ID from the database
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * List all products
     *
     * @return
     */
    @Override
    public List<Product> list() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM Product", Product.class) // Specify the
                // class
                .getResultList(); // Gets all the entries
    }

    /**
     * Add product to database
     *
     * @param product
     * @return Return if product was added successfully
     */
    @Override
    public boolean add(Product product) {
        try {
            sessionFactory
                    .getCurrentSession()
                    .persist(product); // Add product as entry in database
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        try {
            sessionFactory
                    .getCurrentSession()
                    .update(product); // Update specific product
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        try {
            product.setActive(false); // Hide product
            return this.update(product); // Update that product with new data
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * List all active products
     *
     * @return
     */
    @Override
    public List<Product> listActiveProducts() {
        String activeProductsQuery = "FROM Product WHERE active = :active";
        // Active parameter
        return sessionFactory
                .getCurrentSession()
                .createQuery(activeProductsQuery, Product.class) // Build our query
                .setParameter("active", true) // The param we use for
                // checking (:active) and the value we check for
                .getResultList();
    }

    /**
     * List all active products by category
     *
     * @param categoryId
     * @return
     */
    @Override
    public List<Product> listActiveProductsByCategory(int categoryId) {
        String activeProductsByCatQuery = "FROM Product WHERE active = " +
                ":active AND categoryId = :categoryId";
        // Active parameter
        return sessionFactory
                .getCurrentSession()
                .createQuery(activeProductsByCatQuery, Product.class) // Build our query
                .setParameter("active", true) // The param we want and value
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    /**
     * Get the latest active product by amount
     *
     * @param count - how many prducts to retrieve
     * @return
     */
    @Override
    public List<Product> getLatestActiveProducts(int count) {
        String activeProductsCountQuery = "FROM Product WHERE active = " +
                ":active ORDER BY id";
        // Active parameter
        return sessionFactory
                .getCurrentSession()
                .createQuery(activeProductsCountQuery, Product.class) // Build our query
                .setParameter("active", true) // The param we want and value
                .setFirstResult(0) // Index starts from 0
                .setMaxResults(count) // Get products from index [0, count)
                .getResultList();
    }
}
