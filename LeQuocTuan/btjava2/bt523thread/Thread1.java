/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.bt523thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LQT
 */
public class Thread1 extends Thread{
    List<Integer> listInt = new ArrayList<>();
    

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {           
            int rad = random.nextInt(100);
            System.out.println("> T1 " + rad);
            listInt.add(rad);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
