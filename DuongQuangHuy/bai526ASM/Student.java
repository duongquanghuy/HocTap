/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai526;

/**
 *
 * @author DuongQuangHuy
 */
public class Student {
    String rollNo;
    String fullName;
    String sex;
    String email;
    String adress;

    public Student() {
    }

    public Student(String rollNo, String fullName, String sex, String email, String adress) {
        this.rollNo = rollNo;
        this.fullName = fullName;
        this.sex = sex;
        this.email = email;
        this.adress = adress;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }


    
    
    
}
