package net.spiderpig.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Handle general errors in the application such as invalid URLs
 */
@ControllerAdvice // Annotation used to specify that this class handles our
// exceptions
public class GlobalDefaultExceptionHandler {

    // Add exception handler to specific exception where a handler (page)
    // does not exist
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNoHandlerFoundException() {
        ModelAndView mv = new ModelAndView("error"); // Create error view
        mv.addObject("errorTitle", "This page does not exist");
        mv.addObject("errorDescription", "The request page does not " +
                "currently exist");
        mv.addObject("title", "404 Error Page");
        return mv;
    }

    /**
     * Handle exceptions for products that don't exist
     */
    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handlerProductNotFoundException() {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorTitle", "Product not available!");
        mv.addObject("errorDescription", "The product that you are looking " +
                "for is not available right now");
        mv.addObject("title", "Product Unavailable");
        return mv;
    }


    /**
     * Handler generic exceptions
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException(Exception ex) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorTitle", "Contact Your Administrator");

        /* DEBUG ONLY (for printing full stack trace) */
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);

        mv.addObject("errorDescription", sw.toString());
        mv.addObject("title", "Error");
        return mv;
    }

}
