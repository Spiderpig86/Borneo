package net.spiderpig.dto;

/**
 * The base class for categories for different categories of items sold.
 */
public class Category {

    /**
     * Private Fields
     */
    private int id;
    private String catName;
    private String catDescription;
    private String catImageURL;
    private boolean isActive = true; // Determines if a category will be
    // shown in the store and is controlled by the admin

    /**
     * GETTERS AND SETTERS
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    public String getCatImageURL() {
        return catImageURL;
    }

    public void setCatImageURL(String catImageURL) {
        this.catImageURL = catImageURL;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
