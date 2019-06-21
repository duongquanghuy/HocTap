/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt74;

/**
 *
 * @author DuongQuangHuy
 */
public class BT47 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        
        Thread1 t1 = new Thread1(sharedData);
        Thread2 t2 = new Thread2(sharedData);
        
        t2.start();
        t1.start();
    }
    
}
