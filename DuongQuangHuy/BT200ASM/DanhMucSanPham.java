/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt200;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author DuongQuangHuy
 */
public class DanhMucSanPham implements Serializable{
    String maDanhMuc;
    String tenDanhMuc;
    
    
    
    
    
    
    public void inputDanhMuc(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("nhap ma danh muc : ");
        maDanhMuc = scan.nextLine();
        System.out.println("nhap ten danh muc : ");
        tenDanhMuc = scan.nextLine();
        System.out.println("ket thuc ...........");
    
    }
    public void diaplayDanhMuc(){
        System.out.println(toString());
        
    }

    @Override
    public String toString() {
        return "DanhMucSanPham{" + "maDanhMuc=" + maDanhMuc + ", tenDanhMuc=" + tenDanhMuc + '}';
    }
    
    public DanhMucSanPham() {
    }

    public DanhMucSanPham(String maDanhMuc, String tenDanhMuc) {
        this.maDanhMuc = maDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }
    
}
