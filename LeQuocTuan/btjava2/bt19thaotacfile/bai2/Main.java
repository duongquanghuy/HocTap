/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.bt19thaotacfile.bai2;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author LQT
 */

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String url;
        System.out.println("Nhap vao dia chi thu muc : ");
        url = input.nextLine();
        System.out.println("Hien thi cac file trong thu muc : " + url);
        File folder = new File(url);
        File[] childrenFile = folder.listFiles();
        for (File file : childrenFile) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
