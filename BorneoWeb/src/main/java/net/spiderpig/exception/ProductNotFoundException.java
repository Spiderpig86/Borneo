package net.spiderpig.exception;

import java.io.Serializable;

/**
 * Handle 500 error for when user requests undefined product
 */
public class ProductNotFoundException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;

    public ProductNotFoundException() {
        this("Product is not available!");
    }

    public ProductNotFoundException(String message) {
        this.message = System.currentTimeMillis() + ": " + message;
    }

    public String getMessage() {
        return message;
    }
}
