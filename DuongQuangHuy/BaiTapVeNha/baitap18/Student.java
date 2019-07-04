/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap18;

import java.util.Scanner;

/**
 *
 * @author DuongQuangHuy
 */
public class Student implements Serializable{
    String id;
    String name;
    int age;
    String address;
    Float gpa;
    
    
    // nhap thong tin
    public void inputStudent(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("nhap ma sinh vien");
        id = scan.nextLine();
        System.out.println("nhap ten sinh vien");
        name = scan.nextLine();
        System.out.println("nhap tuoi sinh vien");
        age = Integer.parseInt(scan.nextLine());
        System.out.println("nhap dia chi sinh vien");
        address = scan.nextLine();
        System.out.println("nhap diem trung binh sinh vien");
        gpa = scan.nextFloat();
        
    }
    // hien thi thong tin sinh vien
    public  void displayStuDent(){
        System.out.println(toString());
    }
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", gpa=" + gpa + '}';
    }
    // sua thong thin sinh vien
    public void edit(){
         Scanner scan = new Scanner(System.in);
        
        
        System.out.println("nhap ten sinh vien");
        name = scan.nextLine();
        System.out.println("nhap tuoi sinh vien");
        age = Integer.parseInt(scan.nextLine());
        System.out.println("nhap dia chi sinh vien");
        address = scan.nextLine();
        System.out.println("nhap diem trung binh sinh vien");
        gpa = scan.nextFloat();
        
    }
    
    public Student() {
    }

    public Student(String id, String name, int age, String address, Float gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    Object getId(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
