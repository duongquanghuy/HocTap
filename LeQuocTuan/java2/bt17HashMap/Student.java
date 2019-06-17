/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.bt17;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author LQT
 */
public class Student {
    private int rollNo;
    private String name;
    private String sex;
    private int age;
    private String email;
    private String address;

    public Student(int rollNo, String name, String sex, int age, String email, String address) {
        this.rollNo = rollNo;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.address = address;


    }

    public Student() {

    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public static HashMap<Integer, Student> mapStudent = new HashMap<>();
    public void input(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap vao ma so : ");
        rollNo = Integer.parseInt(input.nextLine());
        mapStudent.put(rollNo, this);
        System.out.println("Nhap vao ten : ");
        name = input.nextLine();
        System.out.println("Nhap vao gioi tinh : ");
        sex = input.nextLine();
        System.out.println("Nhap vao tuoi : ");
        age = Integer.parseInt(input.nextLine());
        System.out.println("Nhap vao email : ");
        email = input.nextLine();
        System.out.println("Nhap vao dia chi : ");
        address = input.nextLine();
    }
    
    public void show(){
        System.out.println("Ma so : "+ rollNo);
        System.out.println("Ten : " + name);
        System.out.println("Gioi tinh : "+ sex);
        System.out.println("Tuoi : "+ age);
        System.out.println("Email : "+ email);
        System.out.println("Dia chi : "+address);
    }

    
    
}
