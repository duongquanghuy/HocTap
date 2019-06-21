/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt74;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DuongQuangHuy
 */
public class Thread1 extends Thread {

    SharedData sharedData;

    public Thread1(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
//        try {
//            Thread.sleep(1100);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
//        }

        for (int i = 0; i < 25; i++) {
            synchronized (sharedData) {
                int rad = i;
                sharedData.setRad(rad);
                System.out.println("rad : " + rad);
                if (i == 20) {
                    try {
                        
                        Thread.sleep(2000);
                        
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                try {
                    sharedData.notifyAll();
                    sharedData.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        synchronized (sharedData) {
            sharedData.notifyAll();
        }
    }
}
