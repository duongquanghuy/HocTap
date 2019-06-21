/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.bt102.Bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap chuoi ");
        String aSentence = input.nextLine();
        System.out.println("Nhap chuoi can tim trong chuoi da nhap ");
        String aWord = input.nextLine();
        System.out.println("Vi tri dau tien: " + aSentence.indexOf(aWord));
        System.out.println("Vi tri tiep theo: " + aSentence.indexOf(aWord, aSentence.indexOf(aWord) + 1));

        List<Integer> indexs = listOfWordInSentence(aWord, aSentence);
        System.out.println("Cau: " + aSentence);
        System.out.println("Tu: " + aWord);
        if (indexs.size() == 0) {
            System.out.println("Khong co tu '" + aWord + "' trong cau tren.");
        } else {
            System.out.println("Vi tri cua tu '" + aWord + "' trong cau tren la:");
            for (Integer e : indexs) {
                System.out.println(" " + e);
            }
            System.out.println("so lan xuat hien la " + indexs.size());
        }

    }
//    Ham xu ly tim chi so cua chuoi can tim kiem tra va tra ve mang vi tri
    private static List<Integer> listOfWordInSentence(String aWord, String aSentence) {
        int indexOfPreviousWord = -1;
        int indexOfThisWord = 0;

        List<Integer> listOfWord = new ArrayList<Integer>();
        while (true) {
            indexOfThisWord = aSentence.indexOf(aWord, indexOfPreviousWord + 1);
            if (indexOfThisWord != -1) {
                listOfWord.add(indexOfThisWord);
                indexOfPreviousWord = indexOfThisWord;
            } else {
                break;
            }
        }
        return listOfWord;
    }

}
