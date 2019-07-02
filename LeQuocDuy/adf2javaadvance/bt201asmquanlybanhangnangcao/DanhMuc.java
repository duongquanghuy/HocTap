/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt201asmquanlybanhangnangcao;

import java.util.Scanner;

/**
 *
 * @author Duy Lumiere
 */
public class DanhMuc {
    transient Scanner z = new Scanner(System.in);
    private String maDanhMuc;
    private String tenDanhMuc;

    public DanhMuc() {
    }

    public DanhMuc(String maDanhMuc, String tenDanhMuc) {
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
    
    public void nhapDanhMuc() {
        System.out.print("- Nhập Mã danh mục: ");
        this.maDanhMuc = z.nextLine();
        System.out.print("- Nhập Tên danh mục: ");
        this.tenDanhMuc = z.nextLine();
        System.out.println("Nhập Danh mục thành công!");
    }
    
    public void hienDanhMuc() {
        System.out.println("Mã danh mục: " + maDanhMuc + "; Tên danh mục: " + tenDanhMuc);
    }
}
