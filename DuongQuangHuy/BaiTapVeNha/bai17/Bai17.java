/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai17;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author DuongQuangHuy
 */
public class Bai17 {

    /**
     * @param args the command line arguments
     */
    static Scanner s = new Scanner(System.in);
    static Map<String, Student> studentMap = new HashMap<>();
    public static void main(String[] args) {
        // TODO code application logic here
       
        int choose;
        do {

            showMenu();
            choose = Integer.parseInt(s.nextLine());
            switch (choose) {
                case 1:
                    input();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("nhap ko dung");
                    break;
            }

        } while (choose != 4);

    }

    private static void showMenu(){
        System.out.println("1. nhap n sinh vien");
        System.out.println("2. hien thi sinh vien");
        System.out.println("3. tim kiem sinh vien");
        System.out.println("4. thoat");
    }
    private static void input() {
        
        System.out.println("nhap n sinh vien muon the,");
        int n = Integer.parseInt(s.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("nhap sinh vien thu : "+(i+1));
            Student sv =  new Student();
            sv.inputStudent();
            studentMap.put(sv.getRoollNo(), sv);
            
           
        }
    }

    private static void display() {
        Set set = studentMap.keySet();
        for (Object  key : set) {
            
            System.out.println(studentMap.get(key));
        }
    }

    private static void searchStudent() {
        System.out.println("nhap ma sinh vien can tim ");
        String ma = s.nextLine();
        
        if(studentMap.containsKey(ma)){
            System.out.println(studentMap.get(ma).toString());
        }
        else{
        
            System.out.println("khong tim thay");
        }
        
        }
    
    
}
