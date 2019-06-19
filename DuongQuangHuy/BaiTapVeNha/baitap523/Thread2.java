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
public class Thread2 extends Thread {
//
//    @Override
//    public void run() {
//        ArrayList<String> thread2 = new ArrayList<>();
//        Random rd = new Random();
//        int n ;
//        for (int i = 0; i < 10; i++) {
//            //  65 la ky tu A va 26 la tong so ky tu va math.random() chay tu 0.0 --> 1.0
//            n =  (int) (65 + Math.random() * 26);
//            char ktUpper = (char) n;
//            System.out.println("Ký tự in hoa là " + ktUpper);
//        }
//    }
  ArrayList<Character> list2 = new ArrayList<>();
    @Override
    public void run() {
        
       
        Random rd = new Random();

        int min = (int) 'A';
        int max = (int) 'Z';
        int limit = max - min;
        
        for (int i = 0; i < 10; i++) {
            
            int n = rd.nextInt(limit) + min;
            char c = (char) n;

            list2.add(c);
            
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
