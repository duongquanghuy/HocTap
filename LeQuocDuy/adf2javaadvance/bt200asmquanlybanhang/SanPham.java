/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt200asmquanlybanhang;

import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.*;

/**
 *
 * @author Duy Lumiere
 */
public class SanPham implements Serializable {

    transient Scanner z = new Scanner(System.in);
    private String maSanPham;
    private String maDanhMuc;
    private String tenSanPham;
    private String gia;
    private String ngayNhap;
    private String ngayBan;
    private String hanSuDung;
    private String moTaSanPham;

    private String regex = "[0-9]{1,2}-[0-9]{1,2}-[0-9]{1,4}";

    public SanPham() {
    }

    public SanPham(String maSanPham, String maDanhMuc, String tenSanPham, String gia, String ngayNhap, String ngayBan, String hanSuDung, String moTaSanPham) {
        this.maSanPham = maSanPham;
        this.maDanhMuc = maDanhMuc;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.ngayNhap = ngayNhap;
        this.ngayBan = ngayBan;
        this.hanSuDung = hanSuDung;
        this.moTaSanPham = moTaSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }

    public String getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(String hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public String getMoTaSanPham() {
        return moTaSanPham;
    }

    public void setMoTaSanPham(String moTaSanPham) {
        this.moTaSanPham = moTaSanPham;
    }

    public void nhapSanPham() {
        while (true) {
            System.out.print("- Nhập Mã sản phẩm: ");
            this.maSanPham = z.nextLine();
            if (maSanPham.equalsIgnoreCase("")) {
                System.out.println("Bạn bắt buộc phải nhập Mã Sản phẩm!");
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("- Nhập Mã danh mục của Sản phẩm: ");
            this.maDanhMuc = z.nextLine();
            if (maDanhMuc.equalsIgnoreCase("")) {
                System.out.println("Bạn bắt buộc phải nhập Mã Danh mục!");
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("- Nhập Tên sản phẩm: ");
            this.tenSanPham = z.nextLine();
            if (tenSanPham.equalsIgnoreCase("")) {
                System.out.println("Bạn bắt buộc phải nhập Tên sản phẩm!");
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("- Nhập Giá sản phẩm: ");
            this.gia = z.nextLine();
            if (gia.matches("[0-9]+")) {
                break;
            } else {
                System.out.println("Bạn chỉ có thể nhập số!");
            }
        }
        while (true) {
            System.out.print("- Nhập Ngày Nhập của sản phẩm (định dạng dd-MM-yyyy): ");
            this.ngayNhap = z.nextLine();
            if (ngayNhap.equalsIgnoreCase("")) {
                break;
            } else {
                if (kiemTraNgayThang(ngayNhap)) {
                    break;
                }
            }
        }
        while (true) {
            System.out.print("- Nhập Ngày Bán của sản phẩm (định dạng dd-MM-yyyy): ");
            this.ngayBan = z.nextLine();
            if (ngayBan.equalsIgnoreCase("")) {
                break;
            } else {
                if (kiemTraNgayThang(ngayBan)) {
                    break;
                }
            }
        }
        while (true) {
            System.out.print("- Nhập Hạn sử dụng của sản phẩm (định dạng dd-MM-yyyy): ");
            this.hanSuDung = z.nextLine();
            if (hanSuDung.equalsIgnoreCase("")) {
                System.out.println("Bạn bắt buộc phải nhập HSD");
            } else {
                if (kiemTraNgayThang(hanSuDung)) {
                    break;
                }
            }
        }
        System.out.print("- Nhập Mô tả của sản phẩm: ");
        this.moTaSanPham = z.nextLine();
        System.out.println("Nhập Sản phẩm thành công!");
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSanPham=" + maSanPham + ", maDanhMuc=" + maDanhMuc + ", tenSanPham=" + tenSanPham + ", gia=" + gia + ", ngayNhap=" + ngayNhap + ", ngayBan=" + ngayBan + ", hanSuDung=" + hanSuDung + ", moTaSanPham=" + moTaSanPham + '}';
    }

    public void hienSanPham() {
        System.out.println(this.toString());
    }

    public boolean kiemTraNgayThang(String st) {
        if (st.matches(regex)) {
            int ngay = Integer.parseInt(st.substring(0, st.indexOf("-")));
            int thang = Integer.parseInt(st.substring(st.indexOf("-") + 1, st.lastIndexOf("-")));
            int nam = Integer.parseInt(st.substring(st.lastIndexOf("-") + 1, st.length()));

            if ((1 <= ngay) && (ngay <= 31) && (1 <= thang) && (thang <= 12) && (1 <= nam)) {
                return true;
            } else {
                if (!((1 <= thang) && (thang <= 12))) {
                    System.out.println("Tháng phải nằm trong khoảng từ 1 đến 12!");
                }
                if (!(1 <= nam)) {
                    System.out.println("Năm không được nhỏ hơn 1!");
                }
                if (!((1 <= ngay) && (ngay <= 31))) {
                    System.out.println("Ngày phải nằm trong khoảng từ 1 đến 31!");
                }
                return false;
            }
        } else {
            System.out.println("Bạn đã nhập sai định dạng ngày tháng (dd-MM-yyyy)!");
            return false;
        }
    }
}
