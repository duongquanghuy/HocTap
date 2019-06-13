/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt17;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Duy Lumiere
 */
public class Main {

    public static void main(String[] args) {
        Scanner z = new Scanner(System.in);

        int luaChon;
        int soLuongSv;
        int ketQuaTimDuoc = 0;

        String chuoiKiemTra;

        Map<String, Student> sinhVienMap = new HashMap<>();

        do {
            System.out.println("");
            showMenu();
            luaChon = z.nextInt();
            switch (luaChon) {
                case 1:
                    System.out.println("");
                    System.out.println("NHẬP THÔNG TIN SINH VIÊN");
                    System.out.print("Nhập số lượng SV muốn thêm: ");
                    soLuongSv = z.nextInt();

                    for (int i = 0; i < soLuongSv; i++) {
                        Student std = new Student();
                        System.out.println("Sinh viên thứ " + (i + 1) + ":");
                        std.inputStudent();
                        sinhVienMap.put(std.getRollNo(), std);
                        System.out.println("Thêm thông tin SV " + std.getName() + " thành công!");
                        System.out.println("");
                    }
                    break;

                case 2:
                    System.out.println("");
                    if (sinhVienMap.isEmpty()) {
                        System.out.println("Chưa có thông tin Sinh viên nào");
                    } else {
                        System.out.println("IN THÔNG TIN SINH VIÊN");
                        sinhVienMap.entrySet().forEach((sv) -> {
                            System.out.println(sv.toString());
                        });
                    }
                    break;

                case 3:
                    System.out.println("");
                    z.nextLine();
                    if (sinhVienMap.isEmpty()) {
                        System.out.println("Chưa có thông tin Sinh viên nào");
                    } else {
                        System.out.println("");
                        System.out.println("TÌM KIẾM THÔNG TIN SINH VIÊN");
                        System.out.print("Nhập Mã SV: ");
                        chuoiKiemTra = z.nextLine();
                        for (Map.Entry sv : sinhVienMap.entrySet()) {
                            if ((sv.getKey()).equals(chuoiKiemTra)) {
                                ketQuaTimDuoc++;
                            }
                        }
                        if (ketQuaTimDuoc == 0) {
                            System.out.println("Không tìm thấy SV khớp với Mã SV đã nhập!");
                            ketQuaTimDuoc = 0;
                        } else {
                            System.out.println(sinhVienMap.get(chuoiKiemTra).toString());
                            ketQuaTimDuoc = 0;
                        }
                    }
                    break;

                case 4:
                    System.exit(0);
            }
        } while (true);
    }

    public static void showMenu() {
        System.out.println("=== CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ===");
        System.out.println("1. Nhập thông tin Sinh viên.");
        System.out.println("2. In thông tin Sinh viên.");
        System.out.println("3. Tìm kiếm Sinh viên.");
        System.out.println("4. Thoát");
        System.out.print("Mời bạn chọn: ");
    }
}
