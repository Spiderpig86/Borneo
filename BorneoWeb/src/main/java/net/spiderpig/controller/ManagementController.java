package net.spiderpig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller that renders page for allowing admins to manage their products
 */
@Controller
@RequestMapping("/manage")
public class ManagementController {

    @RequestMapping(value="/products", method = RequestMethod.GET)
    public ModelAndView showManageProducts() {
        ModelAndView mv = new ModelAndView("page"); // Reuses master page
        mv.addObject("userClickManageProducts", true); // Attribute that
        // tells us that we are in the manage products page
        mv.addObject("title", "Manage Products");
        return mv;
    }

}
