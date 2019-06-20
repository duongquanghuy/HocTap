/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt18;
import java.io.Serializable;
import java.util.Locale;
import java.util.Scanner;
/**
 *
 * @author Duy Lumiere
 */
public class Student implements Serializable {
    transient Scanner z = new Scanner(System.in).useLocale(Locale.ENGLISH);
    
    private String id;
    private String name;
    private int age;
    private String address;
    private double gpa;

    public Student(String id, String name, int age, String address, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }
    
    public Student(){}

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

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", gpa=" + gpa + '}';
    }
    
    public void addStudent(){
        System.out.print("Insert name: ");
        this.name = z.nextLine();
        System.out.print("Insert id: ");
        this.id = z.nextLine();
        System.out.print("Insert address: ");
        this.address = z.nextLine();
        System.out.print("Insert age: ");
        this.age = z.nextInt();
        System.out.print("Insert GPA: ");
        this.gpa = z.nextDouble();
    }
    
    public void editStudent(){
        z.nextLine();
        System.out.println("Edit name (Old: " + this.getName() + "): ");
        this.setName(z.nextLine());
        System.out.print("Edit address (Old: " + this.getAddress() + "): ");
        this.setAddress(z.nextLine());
        System.out.print("Edit age (Old: " + this.getAge() + "): ");
        this.setAge(z.nextInt());
        System.out.print("Edit GPA (Old: " + this.getGpa() + "): ");
        this.setGpa(z.nextDouble());
    }
}
