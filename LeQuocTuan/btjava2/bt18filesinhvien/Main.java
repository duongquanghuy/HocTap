/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.bt18filesinhvien;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LQT
 */
public class Main {

    public static void main(String[] args) {

        while (true) {
            showMenu();
            Scanner scanner = new Scanner(System.in);
            int sizeSv;
            int luachon;
            System.out.println("Mời bạn chọn 1 mục :");
            luachon = scanner.nextInt();

            switch (luachon) {
                case 1:
                    System.out.println("== Thêm sinh viên mới == \n");
                    System.out.println("Nhập vào số lượng sinh viên : ");
                    sizeSv = scanner.nextInt(); //tuong tu nhu tren
                    for (int i = 1; i <= sizeSv; i++) {
                        System.out.println("Nhập thông tin sinh viên thứ " + i);
                        Student student = new Student();
                        student.inputinfo();

                    }
                    break;

                case 2:
                    System.out.println("== Hiển thị thông tin tất cả các sinh viên ra màn hình == \n");
                    for (Student a : Student.listStudent) {
                        a.showinfo();
                    }
                    break;

                case 3:
                    //Có thể thêm điều kiện check điểm của student(i) trong mảng có thể bằng null nếu k check điểm nhập vào
                    System.out.println("== Hiển thị sinh viên có điểm trung bình cao nhất và sinh viên có điểm trung bình thấp nhất == \n");
                    Student maxdtb = null;
                    Student mindtb = null;
                    for (int i = 0; i < Student.listStudent.size(); i++) {

                        if (maxdtb == null || Student.listStudent.get(i).getDiemTrungBinh() >= maxdtb.getDiemTrungBinh()) {
                            maxdtb = Student.listStudent.get(i);
                        }
                    }
                    for (int i = 0; i < Student.listStudent.size(); i++) {

                        if (mindtb == null || Student.listStudent.get(i).getDiemTrungBinh() <= mindtb.getDiemTrungBinh()) {
                            mindtb = Student.listStudent.get(i);
                        }
                    }
                    System.out.println("Sinh viên có điểm trung bình cao nhất là : ");
                    maxdtb.showinfo();
                    System.out.println("Sinh viên có điểm trung bình thấp nhất là : ");
                    mindtb.showinfo();
                    break;
                case 4:
                    System.out.println("== Tìm kiếm sinh viên theo mã sinh viên ==");
                    String searchMaSinhVien;
                    System.out.println("Nhập vào mã sinh viên ");
                    scanner.nextLine();
                    searchMaSinhVien = scanner.nextLine();
                    for (int i = 0; i < Student.listStudent.size(); i++) {
                        if (searchMaSinhVien.equals(Student.listStudent.get(i).getMaSinhVien())) {
                            System.out.println("Thông tin sinh viên cần tìm là : ");
                            Student.listStudent.get(i).showinfo();
                        }
                    }
                case 5:
                    System.out.println("== Hiển thị tất cả các sinh viên theo tên A - Z == \n");
                    Collections.sort(Student.listStudent);
                    for (Student a : Student.listStudent) {
                        a.showinfo();
                        System.out.println("\n");
                    }
                    break;
                case 6:
                    System.out.println("== Hiển thị tất cả các sinh viên được học bổng == \n");
                    for (int i = 0; i < Student.listStudent.size(); i++) {
                        if (Student.listStudent.get(i).getDiemTrungBinh() >= 8) {
                            Student.listStudent.get(i).showinfo();
                            System.out.println("\n");
                        }
                    }
                    break;
                case 7:
                    System.out.println("== Sửa thông tin sinh viên ==");
                    System.out.println("Nhập mã sinh viên cần sửa : ");
                    scanner.nextLine();
                    String editByMaSinhVien = scanner.nextLine();
                    for (int i = 0; i < Student.listStudent.size(); i++) {
                        if (Student.listStudent.get(i).getMaSinhVien().equalsIgnoreCase(editByMaSinhVien)) {
                            Student.listStudent.get(i).inputinfo();
                        } else {
                            System.out.println("Khong co sinh vien ma nay");
                        }
                    }
                    break;
                case 8:
                    System.out.println("== Lưu thông tin sinh viên vào file danh sách ==");
                    System.out.print("== Nhap file can luu: ");
                    createFileListStudent(Student.listStudent, "E:/Sinhvien.obj");
                    System.out.println("Đã lưu thông tin các sinh viên vào file danh sách");
                    break;
                case 9:
                    System.out.println("== In thông tin sinh viên từ file danh sách");
                    ArrayList<Student> listStudent = readFileListStudent("E:/Sinhvien.obj");
                    listStudent.stream().forEach((std) -> {
                        std.showinfo();
                    });
                    break;
                case 10:
                    System.exit(0);
                    break;

            }

        }
    }

    static void showMenu() {
        System.out.println("========================");
        System.out.println("1: Nhập vào n sinh viên");
        System.out.println("2: Hiển thị thông tin tất cả các sinh viên ra màn hình");
        System.out.println("3: Hiển thị sinh viên có điểm trung bình cao nhất và sinh viên có điểm trung bình thấp nhất");
        System.out.println("4: Tìm kiếm sinh viên theo mã sinh viên");
        System.out.println("5: Hiển thị tất cả các sinh viên theo tên A - Z");
        System.out.println("6: Hiển thị tất cả các sinh viên được học bổng");
        System.out.println("7: Sửa thông tin sinh viên theo mã sinh viên");
        System.out.println("8: Ghi danh sách sinh viên vào file");
        System.out.println("9: Đọc thông tin sinh viên từ danh sách");
        System.out.println("10: Thoát");
    }

    static void createFileListStudent(ArrayList listStudent, String nameFileOutPut) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(nameFileOutPut));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listStudent);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    static ArrayList readFileListStudent(String nameFileInPut) {
        FileInputStream fis = null;
        ArrayList listStudent = new ArrayList();
        try {
            fis = new FileInputStream(new File(nameFileInPut));
            ObjectInputStream ois = new ObjectInputStream(fis);
            listStudent = (ArrayList) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listStudent;
    }
}
