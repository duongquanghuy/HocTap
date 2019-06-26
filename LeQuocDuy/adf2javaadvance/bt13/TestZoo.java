/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt13;

import java.util.Scanner;

/**
 *
 * @author Duy Lumiere
 */
public class TestZoo {

    public static void main(String[] args) {
        Scanner z = new Scanner(System.in);
        int choose, aniChoose, cageChoose;
        int delCageId;
        String delAniName;
        boolean checkAniName = false, cageCheck;
        Zoo zoo = new Zoo();

        while (true) {
            showMenu();
            choose = z.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("");
                    Cage cage = new Cage();
                    cage.inputCage();
                    zoo.addCage(cage);
                    break;

                case 2:
                    System.out.println("");
                    if (zoo.cageList.isEmpty()) {
                        System.out.println("There is no cage on the zoo!");
                    } else {
                        System.out.print("Input Cage Id: ");
                        delCageId = z.nextInt();
                        zoo.delCage(delCageId);
                    }
                    break;

                case 3:
                    System.out.println("");
                    if (zoo.cageList.isEmpty()) {
                        System.out.println("There is no cage on the zoo!");
                    } else {
                        System.out.println("Zoo contains: ");
                        zoo.cageList.forEach((cag) -> {System.out.print("Cage " + cag.cageId + ", ");});
                        do {
                            System.out.println("Choose a Cage by Id to add your animal: ");
                            cageChoose = z.nextInt();
                            cageCheck = false;
                            for (Cage cag : zoo.cageList) {
                                if (cag.cageId == cageChoose) {
                                    cageCheck = true;
                                    System.out.println("Your cage now is: Cage " + cag.cageId + ":");
                                    cag.animalList.forEach((anime) -> {System.out.println("Animals: " + anime.name + ", ");});
                                    System.out.println("Which type of animal that you want to add?");
                                    System.out.println("1. Tiger");
                                    System.out.println("2. Dog");
                                    System.out.println("3. Cat");
                                    System.out.print("Please choose: ");
                                    aniChoose = z.nextInt();

                                    switch (aniChoose) {
                                        case 1:
                                            Tiger tiger = new Tiger();
                                            tiger.inputAnimal();
                                            cag.addAnimal(tiger);
                                            break;
                                        case 2:
                                            Dog dog = new Dog();
                                            dog.inputAnimal();
                                            cag.addAnimal(dog);
                                            break;
                                        case 3:
                                            Cat cat = new Cat();
                                            cat.inputAnimal();
                                            cag.addAnimal(cat);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                }
                            }
                            if (cageCheck == false) {
                                System.out.println("Wrong cage Id input!");
                            }
                        } while (cageCheck == false);
                    }
                    break;

                case 4:
                    System.out.println("");
                    if (zoo.cageList.isEmpty()) {
                        System.out.println("There is no cage, please add cage and animal to cage!");
                    } else {
                        z.nextLine();
                        System.out.print("Input animal's name: ");
                        delAniName = z.nextLine();
                        for (Cage cageItem : zoo.cageList) {
                            for (Animal anime : cageItem.animalList) {
                                if (anime.name.equalsIgnoreCase(delAniName)) {
                                    cageItem.delAnimal(delAniName);
                                    checkAniName = true;
                                }
                            }
                        }
                        if(checkAniName == false) {
                            System.out.println("Animal not found!");
                        }
                    }
                    break;

                case 5:
                    System.out.println("");
                    if (zoo.cageList.isEmpty()) {
                        System.out.println("There is no cage, please add cage and animal to cage!");
                    } else {
                        System.out.println("Show all Animals from every Cages");
                        for (Cage cageItem : zoo.cageList) {
                            System.out.println("Cage " + cageItem.cageId + ": ");
                            if (cageItem.animalList.isEmpty()) {
                                System.out.println("There is no animal(s) live in this cage!");
                            } else {
                                cageItem.animalList.forEach((animal) -> {
                                    System.out.println(animal.toString());
                                    animal.sounding();
                                });
                            }
                        }
                    }

                    break;

                case 6:
                    System.exit(0);

                default:
                    System.out.println("Wrong choose!");
                    break;
            }
        }
    }

    public static void showMenu() {
        System.out.println("");
        System.out.println(" === ZOO MANAGER PROGRAM === ");
        System.out.println("1. Add Cage");
        System.out.println("2. Remove Cage");
        System.out.println("3. Add Animal");
        System.out.println("4. Remove Animal");
        System.out.println("5. Show All Animals");
        System.out.println("6. Exit");
        System.out.print("Please choose: ");
    }
}
