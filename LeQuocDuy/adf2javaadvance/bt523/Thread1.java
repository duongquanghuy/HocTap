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
public class Thread1 extends Thread {
    ArrayList<Integer> list1 = new ArrayList<>();
    int a;
    Random rmd = new Random();

    @Override
    public void run() {
        while (list1.size() < 10) {
            try {
                Thread1.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
            }
            a = rmd.nextInt(101);
            list1.add(a);
            System.out.println(a);
        }
    }
}
