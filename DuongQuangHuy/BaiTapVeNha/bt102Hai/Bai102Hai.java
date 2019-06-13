/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt102;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author DuongQuangHuy
 */
public class Bai102Hai {

    public static void main(String[] args) {
        int n, number;
        Random rd = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số phần tử của arrList: ");
        n = scanner.nextInt();
        List<Integer> arrList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            number = rd.nextInt(1000);
            arrList.add(number);
        }
        System.out.println(arrList);

    }

}
