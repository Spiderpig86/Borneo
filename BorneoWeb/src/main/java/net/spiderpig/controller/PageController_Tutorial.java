package net.spiderpig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * NOTE THAT THIS IS NOT PART OF THE PROJECT ITSELF, JUST A TUTORIAL PAGE FOR
 * SHOWING REQUEST PARAMETERS
 * The controller that holds all the request mappings for our server
 */

@Controller
public class PageController_Tutorial {

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("page"); // Create a model view
        // with page as the corresponding JSP name. Note that this is a
        // logical name, and does not point to the physical page
        mv.addObject("greeting", "Hey, this is working!");

        return mv;
    }

}
