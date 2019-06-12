/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt102;

import java.util.Scanner;

/**
 *
 * @author DuongQuangHuy
 */
public class Bai1 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        String source;
        String searching;
        
        System.out.println("nhap chuoi source");
        source  = input.nextLine();
        System.out.println("nhap chuoi searching");
        searching = input.nextLine();
        
        String[] words = source.split("\\s");
        int count = 0;
         for (String w : words) {
            if(w == null ? searching == null : w.equals(searching)){
                
                count++;
            }
        }

         System.out.println("so lan xuat hien cua chuoi la : "+ count);
    }
    
    
    
}
