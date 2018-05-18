package net.spiderpig.controller;

import net.spiderpig.DataAccessObjects.CategoryDAO;
import net.spiderpig.DataTransferObjects.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * The controller that holds all the request mappings for our server
 */

@Controller
public class PageController {

    @Autowired // Tells spring to auto wire or dependency inject from backend
    private CategoryDAO categoryDAO; // This is the name we used in the DAO.
    // There is no need to reinstantiate a new CategoryDAO object

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("page"); // Create a model view
        // with page as the corresponding JSP name. Note that this is a
        // logical name, and does not point to the physical page

        /* Set the page properties */
        mv.addObject("title", "Home");
        mv.addObject("categories", categoryDAO.listCategories());
        mv.addObject("userClickHome", true); // This specifies the object
        // in the JSP with the value true meaning the user went to the homepage

        return mv;
    }

    @RequestMapping(value = "/about")
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "About");
        mv.addObject("userClickAbout", true);
        return mv;
    }

    @RequestMapping(value = "/contact")
    public ModelAndView contact() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Contact Us");
        mv.addObject("userClickContact", true);
        return mv;
    }

    /**
     * Display all products in the store
     * @return
     */
    @RequestMapping(value = {"/show/all/products"})
    public ModelAndView showAllProducts() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "All Products");
        mv.addObject("categories", categoryDAO.listCategories());
        mv.addObject("userClickAllProducts", true);

        return mv;
    }

    /**
     * Dynamically load products based on category
     * @return
     */
    @RequestMapping(value = {"/show/category/{id}/products"})
    public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("page");

        /* Fetch category properties */
        Category category = categoryDAO.get(id); // Get the category by ID

        mv.addObject("title", category.getCatName()); // Set title
        mv.addObject("categories", categoryDAO.listCategories()); // Set
        // list of categories <!-- Needed for sidebar -->
        mv.addObject("category", category); // The specific category we want
        // to show
        mv.addObject("userClickCategoryProducts", true);

        return mv;
    }

}
