/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt13;

import java.util.Scanner;

/**
 *
 * @author Duy Lumiere
 */
public abstract class Animal {
    String name;
    int age;
    String details;
    Scanner z = new Scanner(System.in);

    @Override
    public String toString() {
        return "Animal{" + "Name=" + name + ", Age=" + age + "\nDetails=" + details + '}';
    }   
    
    void showInfor() {
        this.toString();
    }
    
    abstract void sounding();

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal(String name, int age, String details) {
        this.name = name;
        this.age = age;
        this.details = details;
    }
    
    public void inputAnimal(){
        System.out.print("Input name: ");
        name = z.nextLine();
        System.out.print("Input age: ");
        age = z.nextInt();
        z.nextLine();
        System.out.print("Input details: ");
        details = z.nextLine();
    }
}
