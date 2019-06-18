/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap18;

import static baitap18.BaiTap18.students;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DuongQuangHuy
 */
public class BaiTap18 {

    /**
     * @param args the command line arguments
     */
    static List<Student> students = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int choose;

        do {
            showMenu();
            choose = Integer.parseInt(scan.nextLine());
            switch (choose) {
                case 1:

                    System.out.println("nhap so sinh vien can them");
                    int n = Integer.parseInt(scan.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.println("sinh vien thu : " + (i + 1));
                        Student st = new Student();
                        st.inputStudent();

                        students.add(st);
                    }
                    break;
                case 2:
                    System.out.println("nhap id sinh vien can sua");
                    String ma = scan.nextLine();
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getId().equalsIgnoreCase(ma)) {
                            students.get(i).edit();
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("nhap id sinh vien can xoa");
                    String deleteStudent = scan.nextLine();
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getId().equalsIgnoreCase(deleteStudent)) {
                            students.remove(i);
                            break;
                        }
                    }
                    break;
                case 4:

                    Collections.sort(students, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            if (o1.getGpa() < o2.getGpa()) {
                                return -1;
                            }
                            return 1;

                        }

                    });
                    for (int i = 0; i < students.size(); i++) {
                        students.get(i).displayStuDent();
                    }
                    break;
                case 5:
                    Collections.sort(students, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            return o1.getName().compareTo(o2.getName());
                        }
                    });
                    break;
                case 6:
                    for (Student std : students) {
                        std.displayStuDent();
                    }
                    break;
                case 7:
                    FileOutputStream fos = null;
                    ObjectOutputStream oos = null;
                    try {
                        fos = new FileOutputStream("student.obj");
                        oos = new ObjectOutputStream(fos);
                        oos.writeObject(students);
                    } catch (Exception e) {
                    } finally {
                        try {
                            if (fos != null) {
                                fos.close();
                            }
                            if (oos != null) {
                                oos.close();
                            }

                        } catch (IOException ex) {
                        }

                    }
                    break;
                case 8:
                    FileInputStream fis = null;
                    ObjectInputStream ois = null;

                    try {
                        fis = new FileInputStream("student.obj");
                        ois = new ObjectInputStream(fis);

                        students = (List<Student>) ois.readObject();
                    } catch (Exception e) {
                    } finally {
                        try {
                            if (fis != null) {
                                fis.close();
                            }
                            if (ois != null) {
                                ois.close();
                            }

                        } catch (IOException ex) {
                        }
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("nhap sai");
                    break;

            }

        } while (choose != 9);

    }

    public static void showMenu() {
        System.out.println("---------------------");
        System.out.println("1. Add student.");
        System.out.println("2. Edit student by id.");
        System.out.println("3. Delete student by id.");
        System.out.println("4. Sort student by gpa.");
        System.out.println("5. Sort student by name.");
        System.out.println("6. Show student.");
        System.out.println("7. Lưu thông tin sv vào file student.obj");
        System.out.println("8. Đọc thông tin sv từ file student.obj và hiển thị ra màn hình");
        System.out.println("0. Exit");
        System.out.println("choose : ");

    }
}
