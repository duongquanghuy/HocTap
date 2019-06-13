/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt102;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Duy Lumiere
 */
public class bt102b3 {
    public static void main(String[] args) {
        Scanner z = new Scanner(System.in);
        
        int n;
        int resultCount = 0;
        String strCheck;
        List<StringBuilder> arr = new ArrayList<>();
        
        System.out.print("Nhập số lượng chuỗi muốn nhập: ");
        n = z.nextInt();
        z.nextLine();
        
        if(n <= 0){
            System.out.println("Bạn đã nhập sai, vui lòng thử lại!");
        }
        else{
            for (int i = 0; i < n; i++) {
                System.out.print("Nhập chuỗi thứ " + (i+1) + ": ");
                StringBuilder str = new StringBuilder(z.nextLine());
                arr.add(str);
            }
            
            System.out.print("\nNhập chuỗi kiểm tra: ");
            strCheck = z.nextLine();
            
            System.out.println("Kết quả: ");
            
            for (StringBuilder st : arr) {
                if(st.indexOf(strCheck)!=-1){
                    System.out.println(st);
                    resultCount++;
                }
            }
            if(resultCount == 0){
                System.out.println("Không tìm thấy chuỗi nào phù hợp!");
            }
        }
    }
}
