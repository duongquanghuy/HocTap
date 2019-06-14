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
public class Bai102Ba {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        final String A = "searching";
        int n;
        String m;
        
        
        
        System.out.println("nhap so muon them");
        n  = Integer.parseInt(scan.nextLine());
        
        for (int i = 0; i < n; i++) {
            StringBuild sb = new StringBuild();
            System.out.println("nhap phan tu thu : "+(i+1));
            m = scan.nextLine();
            
            sb.addString(m);
            
        }
    }
    
    
    static class StringBuild{
        StringBuild sb = new StringBuild();

        private void addString(String m) {
            //appending string to string builder
            sb.append(m);
            System.out.println("Final string is: " + sb.toString());
            
        }

        private void append(String m) {
            String s = m1.concat(m2);
        }
    }
}
