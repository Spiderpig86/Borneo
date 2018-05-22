package net.spiderpig.controller;

import net.spiderpig.DataTransferObjects.Product;
import net.spiderpig.IDataAccessObjects.IProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/json/data") // Will run this file on this route
public class JsonDataController {

    @Autowired
    private IProductDAO productDAO; // Get the object from backend

    /**
     * Since we are only working with JSON, no need to return ModelAndView
     * @return
     */
    @RequestMapping("/all/products")
    @ResponseBody // Only return the response body, which is the JSON
    public List<Product> getAllProducts() {
        // Get the products from the product DAO
        return productDAO.listActiveProducts();
    }

    @RequestMapping("/category/{id}/products")
    @ResponseBody
    public List<Product> getProductsByCategory(@PathVariable int id) {
        return productDAO.listActiveProductsByCategory(id); // Get category
        // from path
    }

}
