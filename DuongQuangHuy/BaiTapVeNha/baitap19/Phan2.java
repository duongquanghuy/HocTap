/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap19;

import java.io.File;

/**
 *
 * @author DuongQuangHuy
 */
public class Phan2 {
    public static void main(String[] args) {
        System.out.println("File[] listFiles();\n");
        
        File dir = new File("C:\\Users\\DuongQuangHuy\\Documents\\NetBeansProjects\\BaiTap19\\test");
        
        File[] children = dir.listFiles();
        for (File file : children) {
            // lay ra duong dan chinh xac cua fine
            System.out.println(file.getAbsolutePath());
            
        }
        System.out.println("\n-------------");
            
         System.out.println("String[] list():\n");
         // lay ten cua fine
         String[] paths = dir.list();
           for (String path : paths) {
            System.out.println(path);
        }
    }
}
