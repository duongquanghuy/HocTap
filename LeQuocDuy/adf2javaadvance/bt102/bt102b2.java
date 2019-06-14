/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt102;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Duy Lumiere
 */
public class bt102b2 {
    public static void main(String[] args) {
        Scanner z = new Scanner(System.in);
        
        int n;
        boolean rep = false;
        
        do{
            System.out.print("Nhập số phần tử của mảng nguyên: ");
            n = z.nextInt();

            if( n > 0 ){
                List<Integer> arr = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    System.out.print("Nhập giá trị cho phần tử thứ arr[" + i + "]: ");
                    arr.add(z.nextInt());
                }
                System.out.println("Mảng vừa nhập là: ");
                System.out.println(arr);
            } 
            else {
                System.out.println("Số phần tử nhập vào không thỏa mãn");
                rep = true;
            }
        }
        while(rep==true);    
    }
}
