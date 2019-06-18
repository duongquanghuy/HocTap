/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author DuongQuangHuy
 */
public class BaiTap19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        File file = new File("vidu.txt");
        final String OUTPUT_FOLDER = "C:\\Users\\DuongQuangHuy\\Documents\\NetBeansProjects\\BaiTap19\\test";

        if (file.isFile()) {
            System.out.println("File");
            System.out.println("\n-------------------");
         
        } else {

            System.out.println("not Found");
        }

    }

}
