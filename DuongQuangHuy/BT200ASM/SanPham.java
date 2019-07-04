/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt200;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author DuongQuangHuy
 */
public class SanPham implements Serializable {

    String maSP;
    String codeSP;
    String tenSP;
    int giaSP;
    String ngayNhap;
    String ngayban;
    String hanSuDung;
    String moTaSanPham;

    public void inputSanPham() {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Scanner scan = new Scanner(System.in);

        System.out.println("nhap ma san pham : ");
        maSP = scan.nextLine();
        System.out.println("nhap ten San pham ; ");
        tenSP = scan.nextLine();
        System.out.println("nhap gia san Pham : ");
        giaSP = Integer.parseInt(scan.nextLine());

        while (true) {
            boolean kiemTra = true;
            System.out.println("nhap ngay nhap kho : ");
            ngayNhap = scan.nextLine();
            if (true) {
                df.setLenient(false); // set false để kiểm tra tính hợp lệ của date. VD: tháng 2 phải có 28-29 ngày, năm có 12 tháng,....
                try {
                    df.parse(ngayNhap); // parse dateString thành kiểu Date

                } catch (ParseException e) { // quăng lỗi nếu dateString ko hợp lệ
                    System.err.println("Invalid date");
                    kiemTra = false;
                }
            }
            if (kiemTra == true) {
                break;
            }

        }

        while (true) {
            boolean kiemtra1 = true;
            String yes = "y";
            String no = "n";
            System.out.println("san pham da dk ban chua y / n");

            String chon = scan.nextLine();
            if (!chon.equalsIgnoreCase(yes) && !chon.equalsIgnoreCase(no)) {
                System.out.println("chon ko phu hop");
            
            }
            while (chon.equalsIgnoreCase(yes)) {
                boolean kiemTra2 = true;
                if (true) {
                    System.out.println("nhap ngay ban ");
                    ngayban = scan.nextLine();
                    df.setLenient(false); // set false để kiểm tra tính hợp lệ của date. VD: tháng 2 phải có 28-29 ngày, năm có 12 tháng,....
                    try {
                        df.parse(ngayban); // parse dateString thành kiểu Date
                    } catch (ParseException e) { // quăng lỗi nếu dateString ko hợp lệ
                        System.err.println("Invalid date");
                        kiemTra2 = false;
                    }
                }
                if (kiemTra2 == true) {
                    kiemtra1 = false;
                    break;
                   
                }
            }

            if (kiemtra1 == false || chon.equalsIgnoreCase(no)) {
                break;
            }

        }

        while (true) {
            boolean kiemTra2 = true;
            System.out.println("nhap han su dung : ");
            hanSuDung = scan.nextLine();
            if (true) {
                df.setLenient(false); // set false để kiểm tra tính hợp lệ của date. VD: tháng 2 phải có 28-29 ngày, năm có 12 tháng,....
                try {
                    df.parse(hanSuDung); // parse dateString thành kiểu Date
                } catch (ParseException e) { // quăng lỗi nếu dateString ko hợp lệ
                    System.err.println("Invalid date");
                    kiemTra2 = false;
                }
            }
            if (kiemTra2 == true) {
                break;
            }

        }
        System.out.println("nhap mo ta san pham : ");
    }

    public void displaySanPham() {
        System.out.println(toString());

    }

    @Override
    public String toString() {
        return "SanPham{" + "maSP=" + maSP + ", codeSP=" + codeSP + ", tenSP=" + tenSP + ", giaSP=" + giaSP + ", ngayNhap=" + ngayNhap + ", ngayban=" + ngayban + ", hanSuDung=" + hanSuDung + ", moTaSanPham=" + moTaSanPham + '}';
    }

    public SanPham() {
    }

    public SanPham(String maSP, String codeSP, String tenSP, int giaSP, String ngayNhap, String ngayban, String hanSuDung, String moTaSanPham) {
        this.maSP = maSP;
        this.codeSP = codeSP;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.ngayNhap = ngayNhap;
        this.ngayban = ngayban;
        this.hanSuDung = hanSuDung;
        this.moTaSanPham = moTaSanPham;
    }

    public String getMaSp() {
        return maSP;
    }

    public void setMaSp(String maSp) {
        this.maSP = maSp;
    }

    public String getCodeSP() {
        return codeSP;
    }

    public void setCodeSP(String codeSP) {
        this.codeSP = codeSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(int giaSP) {
        this.giaSP = giaSP;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getNgayban() {
        return ngayban;
    }

    public void setNgayban(String ngayban) {
        this.ngayban = ngayban;
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

}
