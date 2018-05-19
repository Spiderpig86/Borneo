package net.spiderpig.DataTransferObjects;

import javax.persistence.*;

/**
 * The base class for categories for different categories of items sold.
 */
@Entity // Use annotation to tell Hibernate that this is an entity class for DB
public class Category {

    /**
     * Private Fields with annotations for database
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto
    // generate/increment ID
    private int id; // Matches with ID stored in column in DB
    @Column(name = "name") // Map to image_url in SQL field. Not needed if
    // same name
    private String catName;
    @Column(name = "description")
    private String catDescription;
    @Column(name = "image_url")
    private String catImageURL;
    @Column(name = "is_active")
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

    @Override
    public String toString() {
        return "Category [id = " + id + ", name = " + catName + ", " +
                "description = " + catDescription + ", active = " + isActive
                + "]";
    }
    
}
