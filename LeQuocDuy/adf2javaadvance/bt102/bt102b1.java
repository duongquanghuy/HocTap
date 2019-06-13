/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt102;
import java.util.Scanner;

/**
 *
 * @author Duy Lumiere
 */
public class bt102b1 {
    public static void main(String[] args) {
        String source;
        String searching;
        
        int chiSoTimThay = 0;
        int ketQuaTimDuoc = -1;
        int chiSoBatDau = -1;
        
        Scanner z = new Scanner(System.in);
        
        System.out.print("Nhập chuỗi SOURCE: ");
        source = z.nextLine();
        
        System.out.print("Nhập chuỗi SEARCHING: ");
        searching = z.nextLine();
        
        while (chiSoTimThay != -1)
        {
            chiSoTimThay = source.toLowerCase().indexOf(searching.toLowerCase(), chiSoBatDau + 1);
            ketQuaTimDuoc++;
            chiSoBatDau = chiSoTimThay;
        }
        
        System.out.println("Số lần xuất hiện của chuỗi '" + searching + "' trong chuỗi '" + source + "' là: " + ketQuaTimDuoc);
    }
}
