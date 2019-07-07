/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.bt201ass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author LQT
 */
public class Product {

    int id;
    String name;
    int price;
    String dateOfManufacture;
    int idCategory;
    String nameCategory;
    String status;

    public Product() {
    }

    public Product(int id, String name, int price, String dateOfManufacture, int idCategory, String nameCategory, String status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dateOfManufacture = dateOfManufacture;
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.status = status;
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

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String checkStatus(String dateOfManufacture) {
        String dateType = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(dateType);
        Date dfDateOfManufacture = null;
        try{
            dfDateOfManufacture = df.parse(dateOfManufacture);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        Long dfDateOfManufactureByLong = dfDateOfManufacture.getTime();
        Long dateNowByLong = new java.util.Date().getTime();
        
        if (dateNowByLong - dfDateOfManufactureByLong < 604800000) {
            return "Còn Hạn";
        }
        else if(dateNowByLong - dfDateOfManufactureByLong > 1209600000){
            return "Hết Hạn";
        }
        else{
            return "Sắp Hết Hạn";
        }

    }

}
