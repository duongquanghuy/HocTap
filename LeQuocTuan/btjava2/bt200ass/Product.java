/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.bt200ass;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LQT
 */
public class Product implements Serializable{
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Product> listProduct = new ArrayList<>();
    int idProduct;
    int idCategory;
    String nameProduct;
    int price;
    String dateAdd;
    String dateSale;
    String dateExpiry;
    String description;

    public Product() {
    }

    public Product(int idProduct, int idCategory, String nameProduct, int price, String dateAdd, String dateSale, String dateExpiry, String description) {
        this.idProduct = idProduct;
        this.idCategory = idCategory;
        this.nameProduct = nameProduct;
        this.price = price;
        this.dateAdd = dateAdd;
        this.dateSale = dateSale;
        this.dateExpiry = dateExpiry;
        this.description = description;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getDateSale() {
        return dateSale;
    }

    public void setDateSale(String dateSale) {
        this.dateSale = dateSale;
    }

    public String getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(String dateExpiry) {
        this.dateExpiry = dateExpiry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void inputProduct(){
        System.out.println("Nhập vào mã sản phẩm : ");
        idProduct = Integer.parseInt(input.nextLine());
        System.out.println("Các danh mục hiện có");
        for (int i = 0; i < Category.listCategory.size(); i++) {
            System.out.println(Category.listCategory.get(i).getIdCategory() +" : " +Category.listCategory.get(i).getNameCategory());
        }
        System.out.println("Nhập và mã danh mục : ");
        idCategory = Integer.parseInt(input.nextLine());
        System.out.println("Nhập vào tên sản phẩm : ");
        nameProduct = input.nextLine();
        System.out.println("Nhập vào giá sản phẩm : ");
        price = Integer.parseInt(input.nextLine());
        System.out.println("Nhập vào ngày thêm (dd-mm-yyyy) : ");
        dateAdd = input.nextLine();
        System.out.println("Nhập vào ngày bán (dd-mm-yyyy) : ");
        dateSale = input.nextLine();
        System.out.println("Nhập vào hạn sử dụng (dd-mm-yyyy): ");
        dateExpiry = input.nextLine();
    }
    
    public void showProduct(){
        System.out.println("Mã sản phẩm : " + idProduct);
        System.out.println("Mã danh mục " + idCategory);
        System.out.println("Tên sản phẩm : " + nameProduct);
        System.out.println("Giá sản phẩm : "+ price);
        System.out.println("Ngày thêm " + dateAdd);
        System.out.println("Ngày bán : " + dateSale);
        System.out.println("Hạn sử dụng : " + dateExpiry);
    }
}
