/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt523;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duy Lumiere
 */
public class Thread2 extends Thread {
    ArrayList<Character> list2 = new ArrayList<>();
    char c;
    String aToZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random rmd = new Random();

    @Override
    public void run() {
        while (list2.size() < 10) {
            try {
                Thread1.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
            }
            c = aToZ.charAt(rmd.nextInt(aToZ.length()));
            list2.add(c);
            System.out.println(c);
        }
    }
}
