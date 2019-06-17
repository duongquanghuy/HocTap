/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.bt102;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LQT
 */
public class Bai3 {

    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<StringBuilder> stb = new ArrayList<>();
        
        
        int size;
        System.out.println("Nhap so luong chuoi : ");
        size = Integer.parseInt(input.nextLine());
        
        for(int i = 0; i < size; i++){
        StringBuilder sb = new StringBuilder();
        System.out.println("Nhap noi dung chuoi " + (i+1));
        sb.append(input.nextLine());
        stb.add(sb);
        }
        
        System.out.println("Nhap vao chuoi can tim : ");
        String searching = input.nextLine();
        System.out.println("Cac chuoi chua chuoi " + searching + " la : ");
        for(int i = 0; i < size; i++){
            String convertStb = stb.get(i).toString();
            if(convertStb.contains(searching)){
                System.out.println(convertStb);
            }

        }
    }
}
