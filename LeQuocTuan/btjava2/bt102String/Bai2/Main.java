/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.bt102.Bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author LQT
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        System.out.println("Nhap vao so phan tu trong mang so ngau nhien : ");
        size = Integer.parseInt(input.nextLine());
        List<Integer> myListRandomInt = listRandomInt(size);
        System.out.println("Mang so ngau nhien la : ");
        for(Integer e : myListRandomInt){
            System.out.print(" "+ e);
        }
        
    }
    
    private static List<Integer> listRandomInt(int size){
        List<Integer> listRandomInt = new ArrayList<>();
        Random rd = new Random();
        for(int i = 0; i< size; i++){
            int number = rd.nextInt();
            listRandomInt.add(number);
        }
        return listRandomInt;
    }
    
}
