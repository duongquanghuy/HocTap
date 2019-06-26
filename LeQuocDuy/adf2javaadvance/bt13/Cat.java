/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt13;

/**
 *
 * @author Duy Lumiere
 */
public class Cat extends Animal {
    @Override
    void sounding() {
        System.out.println("Gogo");
    }
    
    public Cat() {
    }

    public Cat(String name) {
        super(name);
    }
    
    public Cat(String name, int age) {
        super(name, age);
    }
    
    public Cat(String name, int age, String details) {
        super(name, age, details);
    }
}
