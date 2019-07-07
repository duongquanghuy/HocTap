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
public class Category implements Serializable{
    public static ArrayList<Category> listCategory = new ArrayList<>();
    int idCategory;
    String nameCategory;
    
    public static Scanner input = new Scanner(System.in);
    
    public Category() {
    }

    public Category(int idCategory, String nameCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
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
    
    public void inputCategory(){
        System.out.println("Nhập vào tên danh mục : ");
        nameCategory = input.nextLine();
        System.out.println("Nhập vào mã danh mục : ");
        idCategory = Integer.parseInt(input.nextLine());
        
    }
    
    public void showCategory(){
        System.out.println("Tên danh mục : " + nameCategory);
        System.out.println("Mã danh mục : " + idCategory);
    }
}
