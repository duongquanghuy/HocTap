/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.bt62thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LQT
 */
public class Thread1 extends Thread {

    ShareData sharedata;

    public Thread1(ShareData sharedata) {
        this.sharedata = sharedata;
    }

    @Override
    public void run() {
        synchronized (sharedata) {
            for (int i = 0; i < 5; i++) {
                System.out.println("Ho va ten : " + sharedata.listName[i]);
                try {
                    sharedata.notifyAll();
                    sharedata.wait();

                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            sharedata.notifyAll();
        }

    }
}
