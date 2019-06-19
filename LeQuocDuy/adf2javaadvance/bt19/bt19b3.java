/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt19;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duy Lumiere
 */
public class bt19b3 {

    public static void main(String[] args) {
        Scanner z = new Scanner(System.in);

        Thread randomNumber = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(bt19b3.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Random random = new Random();
                    int n = random.nextInt(10000);
                    System.out.println("Số ngẫu nhiên: " + n);
                }
            }
        };

        Thread tong0ToiN = new Thread() {
            @Override
            public void run() {
                while (true) {
                    int n;
                    int tong = 0;
                    System.out.print("Nhập N: ");
                    n = z.nextInt();
                    for (int i = 1; i < n; i++) {
                        tong += i;
                    }
                    System.out.println("Tổng các số từ 1 đến N là: " + tong);
                }
            }
        };

        tong0ToiN.start();
        randomNumber.start();
    }
}
