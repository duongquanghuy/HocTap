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
public class Thread2 extends Thread{
    List<Character> listChar = new ArrayList<>();
    @Override
    public void run() {
        try {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int rad = random.nextInt(25) + 97;
                char c = (char) rad;
                System.out.println(">> T2 " + c);
                listChar.add(c);
            }
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
