/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt17;
import java.util.Scanner;
/**
 *
 * @author Duy Lumiere
 */
public class Student {
    Scanner z = new Scanner(System.in);
    
    private String rollNo;
    private String name;
    private String sex;
    private String email;
    private String address;
    
    public Student(){}

    public Student(String rollNo, String name, String sex, String email, String address) {
        this.rollNo = rollNo;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.address = address;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" + "rollNo=" + rollNo + ", name=" + name + ", sex=" + sex + ", email=" + email + ", address=" + address + '}';
    }
    
    public void inputStudent(){
        System.out.print("Nhập Mã SV: ");
        this.rollNo = z.nextLine();
        System.out.print("Nhập tên SV: ");
        this.name = z.nextLine();
        System.out.print("Nhập Giới tính SV: ");
        this.sex = z.nextLine();
        System.out.print("Nhập Email SV: ");
        this.email = z.nextLine();
        System.out.print("Nhập Địa chỉ SV: ");
        this.address = z.nextLine();
    }
}
