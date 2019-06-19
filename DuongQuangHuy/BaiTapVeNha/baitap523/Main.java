/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap523;

/**
 *
 * @author DuongQuangHuy
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("hien thi ket qua t1");
       
        for (int i = 0; i < t1.list1.size() ; i++) {
            System.out.printf(" " + t1.list1.get(i));
        }
        
        System.out.println("\n gien thi ket qua t2");
        for (int i = 0; i < t2.list2.size(); i++) {
            System.out.println(" " + t2.list2.get(i));
        }
    }
}
