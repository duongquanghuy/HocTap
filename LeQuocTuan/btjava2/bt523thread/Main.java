/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.bt523thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LQT
 */
public class Main {

    public static void main(String[] args) {
        
            Thread1 t1 = new Thread1();
            Thread2 t2 = new Thread2();
            
            t1.start();
            t2.start();
        try {   
            t1.join();
            t2.join();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Ket qua : ");
        System.out.println("Cac so ngau nhien cua T1 là : ");
        for (int i = 0; i < t1.listInt.size(); i++) {
            System.out.print(" " + t1.listInt.get(i));
        }
        System.out.println(" ");
        System.out.println("Cac chu ngau nhien cua t2 la : ");
        for (int i = 0; i < t2.listChar.size(); i++) {
            System.out.print(" " + t2.listChar.get(i));
        }
        System.out.println(" ");
    }
}
