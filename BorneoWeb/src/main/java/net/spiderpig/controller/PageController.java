package net.spiderpig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * The controller that holds all the request mappings for our server
 */

@Controller
public class PageController {

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("page"); // Create a model view
        // with page as the corresponding JSP name. Note that this is a
        // logical name, and does not point to the physical page
        mv.addObject("greeting", "Hey, this is working!");

        return mv;
    }

    /**
     * UNCLEAN URL, REQUIRES "?q="
     */
//    /**
//     * This is an example of having a mapping take into account the custom
//     * query parameter, denoted by "?greeting=", and extract the value after it
//     *
//     * Note that this still takes effect on page.jsp
//     * To make the request param not throw a 404 if the param is missing, add
//     * that required = false.
//     * @return
//     */
//    @RequestMapping(value = "/test")
//    public ModelAndView test(@RequestParam(value = "greeting", required =
//            false) String greeting) {
//        if (greeting == null)
//            greeting = "Hello there"; // Default greeting if absent
//        ModelAndView mv = new ModelAndView("test");
//        mv.addObject("greeting", greeting);
//        return mv; // Return the page logic
//    }

    /**
     * CLEAN URL, only needs /test/argument_here (uses PathVariable instead)
     */
    /**
     * This is an example of having a mapping take into account the custom
     * query parameter, denoted by "?greeting=", and extract the value after it
     *
     * Note that this still takes effect on page.jsp
     * To make the request param not throw a 404 if the param is missing, add
     * that required = false.
     * @return
     */
    @RequestMapping(value = "/test/{greeting}") // Remember to include the var
    public ModelAndView test(@PathVariable("greeting") String greeting) {
        if (greeting == null)
            greeting = "Hello there"; // Default greeting if absent
        ModelAndView mv = new ModelAndView("test");
        mv.addObject("greeting", greeting);
        return mv; // Return the page logic
    }

}
