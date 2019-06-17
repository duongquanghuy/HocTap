/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.bt17;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author LQT
 */
public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choose;
        do {
            showMenu();
            System.out.println("Moi chon : ");
            choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Nhap vao so sinh vien can them : ");
                    int size = Integer.parseInt(input.nextLine());
                    for (int i = 0; i < size; i++) {
                        Student student = new Student();
                        System.out.println("Nhap thong tin sinh vien thu " + (i + 1));
                        student.input();
                    }
                    break;

                case 2:
                    Set<Integer> keyset = Student.mapStudent.keySet();
                    for (Integer i : keyset) {
                        System.out.println("** Sinh vien thu " + i);
                        Student.mapStudent.get(i).show();
                    }
                    break;

                case 3:
                    System.out.println("Nhap vao ma sinh vien can tim : ");
                    int rollNoSearch = Integer.parseInt(input.nextLine());
                    if (Student.mapStudent.containsKey(rollNoSearch)) {
                        Student.mapStudent.get(rollNoSearch).show();
                    } else {
                        System.out.println("Khong co sinh vien ma so nay !!!");
                    }
                    break;

                case 4:
                    System.out.println("Thoat chuong trinh !!!");
                    break;
            }
        } while (choose != 4);
    }

    static void showMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Nhap N sinh vien ");
        System.out.println("2. In thong tin tat ca cac sinh vien");
        System.out.println("3. Tim thong tin sinh vien theo ma so");
        System.out.println("4. Thoat chuong trinh");
    }
}
