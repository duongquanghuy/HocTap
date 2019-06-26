/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.bt62thread;

/**
 *
 * @author LQT
 */
public class Main {

    public static void main(String[] args) {
        ShareData sharedata = new ShareData();

        Thread1 t1 = new Thread1(sharedata);
        Thread2 t2 = new Thread2(sharedata);
        
        t1.start();
        t2.start();
        
        
    }
}
