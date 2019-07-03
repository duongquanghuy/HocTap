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
public class ThreadOne extends Thread{
    Object objSync;

    public ThreadOne(Object objSync) {
        this.objSync = objSync;
    }
    
    String[] usernameList = {"Nguyen Ngoc Lan","Duong Tien Nam","Ngo Anh Quan","Pham Van Duc","Tran Thi Ha"};

   

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadOne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < usernameList.length; i++) {
            synchronized(objSync) {
                System.out.println("User Name : " + usernameList[i]);
                
                objSync.notifyAll();
                try {
                    objSync.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadOne.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println("Thread One >> Finish");
    }
    
}
