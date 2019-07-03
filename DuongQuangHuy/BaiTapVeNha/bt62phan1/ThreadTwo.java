/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt62phan1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DuongQuangHuy
 */
public class ThreadTwo extends Thread{
    String[] addressList = {"Hải Phòng","Hà Nội","Thái Nguyên","Hà Tĩnh","Quảng Ninh"};

    Object objSync;

    public ThreadTwo(Object objSync) {
        this.objSync = objSync;
    }
    @Override
    public void run() {
        for (int i = 0; i < addressList.length; i++) {
            synchronized(objSync) {
                objSync.notifyAll();
                try {
                    objSync.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadTwo.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                System.out.println("Address : " + addressList[i]);
            }
        }
        System.out.println("Thread Two >> Finish");
        synchronized(objSync) {
            objSync.notifyAll();
        }
    }
    
}
