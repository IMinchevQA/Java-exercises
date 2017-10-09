package workshop.models;

import java.util.Date;

public class Product {
    private int id;
    private String description;
    private String productType;
    private String weightType;
    private double weightValue;
    private String brandName;
    private String brandCountry;
    private String productName;
    private double productPrice;
    private Date expirationDate;

    public Product() {

    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public String getProductType() {
        return this.productType;
    }

    public String getWeightType() {
        return this.weightType;
    }

    public double getWeightValue() {
        return this.weightValue;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public String getBrandCountry() {
        return this.brandCountry;
    }

    public String getProductName() {
        return this.productName;
    }

    public double getProductPrice() {
        return this.productPrice;
    }

    public Date getExpirationDate() {
        return this.expirationDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setWeightType(String weightType) {
        this.weightType = weightType;
    }

    public void setWeightValue(double weightValue) {
        this.weightValue = weightValue;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setBrandCountry(String brandCountry) {
        this.brandCountry = brandCountry;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
