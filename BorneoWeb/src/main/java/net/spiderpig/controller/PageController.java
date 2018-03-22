package net.spiderpig.controller;

import net.spiderpig.daoimpl.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * The controller that holds all the request mappings for our server
 */

@Controller
public class PageController {

    @Autowired // Tells spring to auto wire or dependency inject from backend
    private CategoryDAO categoryDAO;

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

}
