/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt19;
import java.io.File;
import java.util.Scanner;
/**
 *
 * @author Duy Lumiere
 */
public class bt19b2 {
    public static void main(String[] args) {
        String pathName;
        boolean rep;
        Scanner z = new Scanner(System.in);
        
        do{
            System.out.println("");
            System.out.println("Liệt kê file trong thư mục bất kỳ: ");
            System.out.println("Vui lòng nhập đường dẫn file hoặc folder: ");
            pathName = z.nextLine();
            File file = new File(pathName);

            //Kiểm tra thư mục có tồn tại?
            System.out.println("Thư mục có tồn tại: " + file.exists());
            System.out.println("");
            
            if(file.exists()){
                rep = false;
                System.out.println("Liệt kê theo đường dẫn: ");
                File[] fileChildren = file.listFiles();
                for (File selectedFile : fileChildren) {
                    System.out.println(selectedFile.getAbsolutePath());
                }

                System.out.println("");

                System.out.println("Liệt kê theo tên: ");
                String[] fileNames = file.list();
                for (String fileName : fileNames) {
                    System.out.println(fileName);
                }
            }
            else{
                System.out.println("Thư mục không tồn tại!");
                rep = true;
            }
        }
        while(rep == true);
    }
}
