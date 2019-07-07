/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.bt201ass;

/**
 *
 * @author LQT
 */
public class ProductSold {
    int id;
    String name;
    String nameCategory;
    int price;
    String dateOfManufacture;
    String dateOfSold;

    public ProductSold() {
    }

    public ProductSold(int id, String name, String nameCategory, int price, String dateOfManufacture, String dateOfSold) {
        this.id = id;
        this.name = name;
        this.nameCategory = nameCategory;
        this.price = price;
        this.dateOfManufacture = dateOfManufacture;
        this.dateOfSold = dateOfSold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getDateOfSold() {
        return dateOfSold;
    }

    public void setDateOfSold(String dateOfSold) {
        this.dateOfSold = dateOfSold;
    }
    
    
}
