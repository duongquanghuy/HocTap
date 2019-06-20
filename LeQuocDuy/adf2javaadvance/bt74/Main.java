/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt74;

/**
 *
 * @author Duy Lumiere
 */
public class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        Thread1 t1 = new Thread1(sharedData);
        Thread2 t2 = new Thread2(sharedData);
        
        t2.start();
        t1.start();
    }
}
