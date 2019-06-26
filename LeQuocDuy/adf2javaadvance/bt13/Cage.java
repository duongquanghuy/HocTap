/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Duy Lumiere
 */
public class Cage {
    Scanner z = new Scanner(System.in);
    int cageId;
    List<Animal> animalList = new ArrayList<>();
    boolean  countCheck = false, delAnimalCheck = false;

    void addAnimal(Animal a) {
        animalList.forEach((ani) -> {
            if (ani.name.equalsIgnoreCase(ani.name)) {
                countCheck = true;
            }
        });
        if (countCheck) {
            System.out.println("This cage already had this animal!");
        } else {
            animalList.add(a);
            System.out.println("Animal add success!");
        }
    }

    void delAnimal(String name) {
        for(Animal a : animalList) {
            if (a.name.equalsIgnoreCase(name)) {
                animalList.remove(a);
                System.out.println("Animal removed success!");
                delAnimalCheck = true;
                break;
            }
        }
        if(delAnimalCheck == false) {
            System.out.println("Animal not found in this cage!");
        }
        delAnimalCheck = false;
    }
    
    void inputCage() {
        System.out.println("Add cage: ");
        System.out.print("Input cage Id: ");
        cageId = z.nextInt();
    }
}
