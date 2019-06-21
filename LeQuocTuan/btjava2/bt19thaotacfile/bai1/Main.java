/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.bt19thaotacfile.bai1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/**
 *
 * @author LQT
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("E:/bigtext.txt");
            File file = new File("E:/vidu.txt");
            if (file.createNewFile()) {
                System.out.println("Da tao file nen");
            } else {
                System.out.println("File vidu.data da ton tai !!!");
            }
            fos = new FileOutputStream("E:/vidu.txt");
            DeflaterOutputStream dos = new DeflaterOutputStream(fos);
            int data;
            while ((data = fis.read()) != -1) {
                dos.write(data);
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
}
