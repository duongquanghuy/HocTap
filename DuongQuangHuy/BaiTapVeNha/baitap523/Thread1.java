/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap523;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DuongQuangHuy
 */
public class Thread1 extends Thread {
     ArrayList<Integer> list1 = new ArrayList<>();
    @Override
    public void run() {
       
        Random rd = new Random();

        for (int i = 0; i < 10; i++) {
            int random = rd.nextInt(100);
            list1.add(random);
          
            try {
                Thread.sleep(10);

            } catch (InterruptedException ex) {
                Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
