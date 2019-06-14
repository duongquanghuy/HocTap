/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai17;

import java.util.Scanner;

/**
 *
 * @author DuongQuangHuy
 */
public class Student {

    String roollNo;
    String name;
    String sex;
    int age;
    String email;
    String address;

    public void inputStudent() {
        Scanner s = new Scanner(System.in);

        System.out.println("nhap ma sinh vien");
        roollNo = s.nextLine();
        System.out.println("nhap ten sinh vien");
        name = s.nextLine();
        System.out.println("nhap gioi tinh sinh vien");
        sex = s.nextLine();
        System.out.println("nhap tuoi sinh vien");
        age = Integer.parseInt(s.nextLine());
        System.out.println("nhap email sinh vien");
        email = s.nextLine();
        System.out.println("nhap dia chi sinh vien");
        address = s.nextLine();

    }
    public void display(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Student{" + "roollNo=" + roollNo + ", name=" + name + ", sex=" + sex + ", age=" + age + ", email=" + email + ", address=" + address + '}';
    }
    public Student() {
    }

    public Student(String roollNo, String name, String sex, int age, String email, String sddress) {
        this.roollNo = roollNo;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.address = sddress;
    }

    public String getRoollNo() {
        return roollNo;
    }

    public void setRoollNo(String roollNo) {
        this.roollNo = roollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSddress() {
        return address;
    }

    public void setSddress(String sddress) {
        this.address = sddress;
    }

}
