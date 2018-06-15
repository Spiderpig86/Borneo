package net.spiderpig.controller;

import net.spiderpig.DataTransferObjects.Category;
import net.spiderpig.DataTransferObjects.Product;
import net.spiderpig.IDataAccessObjects.ICategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Controller that renders page for allowing admins to manage their products
 */
@Controller
@RequestMapping("/manage")
public class ManagementController {

    @Autowired
    private ICategoryDAO categoryDAO; // Get the categoryDAO in other classes

    @RequestMapping(value="/products", method = RequestMethod.GET)
    public ModelAndView showManageProducts() {
        ModelAndView mv = new ModelAndView("page"); // Reuses master page
        mv.addObject("userClickManageProducts", true); // Attribute that
        // tells us that we are in the manage products page
        mv.addObject("title", "Manage Products");

        // We need to create a new product object that will be attached to
        // our form
        Product newProduct = new Product(); // Creates new Product object in
        // database as well
        newProduct.setSupplierId(1); // Set to 1 for now to denote admin
        newProduct.setActive(true); // Set new product to be active by default

        mv.addObject("product", newProduct); // Add that object to the view

        return mv;
    }

    @ModelAttribute("categories") // Binds a method parameter or method
    // return value to a named model attribute and then exposes it to a web view.
    public List<Category> getCategories() {
        return categoryDAO.listCategories();
    }

}
