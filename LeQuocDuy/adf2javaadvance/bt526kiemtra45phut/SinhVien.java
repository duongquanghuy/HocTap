/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt526kiemtra45phut;

/**
 *
 * @author Duy Lumiere
 */
public class SinhVien {
    private String fullName;
    private String gender;
    private String rollNo;
    private String email;
    private String address;

    public SinhVien(String fullName, String gender, String rollNo, String email, String address) {
        this.fullName = fullName;
        this.gender = gender;
        this.rollNo = rollNo;
        this.email = email;
        this.address = address;
    }

    public SinhVien() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
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
    
    
}
