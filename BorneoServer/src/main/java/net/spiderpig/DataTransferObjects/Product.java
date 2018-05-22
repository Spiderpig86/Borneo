package net.spiderpig.DataTransferObjects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

/**
 * Transfer object class for the different products in the store
 */
@Entity
public class Product {

    /**
     * The different fields of each product from the database
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Auto generated and incremented ID
    private String code; // Unique ID for the product
    private String name;
    private String brand;
    @JsonIgnore // Ignore during JSON conversion of this object
    private String description;
    @Column(name = "unit_price")
    private double unitPrice;
    private int quantity;
    @JsonIgnore
    @Column(name = "is_active")
    private boolean active;
    @JsonIgnore
    @Column(name = "category_id")
    private int categoryId;
    @JsonIgnore
    @Column(name = "supplier_id")
    private int supplierId;
    private int purchases;
    private int views;

    public Product() {
        this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
        // Get a random product ID that is 26 chars long
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
