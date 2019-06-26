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
public class Tiger extends Animal {
    @Override
    void sounding() {
        System.out.println("Grawwww");
    }
    
    public Tiger() {
    }

    public Tiger(String name) {
        super(name);
    }
    
    public Tiger(String name, int age) {
        super(name, age);
    }
    
    public Tiger(String name, int age, String details) {
        super(name, age, details);
    }
    
    public void inputAnimal() {
        super.inputAnimal();
    }
}
