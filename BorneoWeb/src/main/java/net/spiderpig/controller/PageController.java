package net.spiderpig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * The controller that holds all the request mappings for our server
 */

@Controller
public class PageController {

    @RequestMapping(value = {"/", "/home", "/index"}) // We can handle
    // mappings for multiple URL names
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("page"); // Create a model view
        // with page as the corresponding JSP name
        mv.addObject("greeting", "Hey, this is working!");

        return mv;
    }

}
