/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt18;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Duy Lumiere
 */
public class Main {

    public static void main(String[] args) {
        Scanner z = new Scanner(System.in);

        int choose, choose2;
        String idInput, confirm;
        boolean replayLoop = false;
        Map<String, Student> studentMap = new HashMap<>();

        while (true) {
            showMenu();

            choose = z.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("");
                    Student std = new Student();
                    std.addStudent();
                    studentMap.put(std.getId(), std);
                    System.out.println("Add Student " + std.getName() + " Success!");
                    break;
                    
                case 2:
                    System.out.println("");
                    if(studentMap.isEmpty()){
                        System.out.println("There is no Student added! Back to menu and choose 1");
                    }
                    else{
                        z.nextLine();
                        System.out.print("Insert Student Id: ");
                        idInput = z.nextLine();
                        if(studentMap.containsKey(idInput)){
                            System.out.println("Student with id " + idInput + ": ");
                            System.out.println(studentMap.get(idInput).toString());
                            System.out.println("Edit Information (beware that Student id cannot be change!): ");
                            studentMap.get(idInput).editStudent();
                            System.out.println("Edit Information Success!");
                            System.out.println(studentMap.get(idInput).toString());
                        }
                        else{
                            System.out.println("No result matching this Id Inserted!");
                        }
                    }
                    break;
                    
                case 3:
                    System.out.println("");
                    if(studentMap.isEmpty()){
                        System.out.println("There is no Student added! Back to menu and choose 1");
                    }
                    else{
                        z.nextLine();
                        System.out.print("Insert Student Id: ");
                        idInput = z.nextLine();
                        if(studentMap.containsKey(idInput)){
                            System.out.println("Student with id " + idInput + ": ");
                            System.out.println(studentMap.get(idInput).toString());
                            do{
                                System.out.print("Are you sure? (y/n): ");
                                confirm = z.nextLine();
                                if(confirm.length() == 1){
                                    if(confirm.equalsIgnoreCase("n")){
                                        replayLoop = false;
                                    }
                                    else if(confirm.equalsIgnoreCase("y")){
                                        studentMap.remove(idInput);
                                        System.out.println("Remove Student Success");
                                        replayLoop = false;
                                    }
                                    else{
                                        replayLoop = true;
                                    }
                                }
                                else{
                                    replayLoop = true;
                                }
                            }
                            while(replayLoop == true);
                        }
                        else{
                            System.out.println("No result matching this Id Inserted!");
                        }
                    }
                    break;
                    
                case 4:
                    System.out.println("");
                    if(studentMap.isEmpty()){
                        System.out.println("There is no Student added! Back to menu and choose 1");
                    }
                    else{
                        do{
                            System.out.println("SORT STUDENT BY GPA");
                            System.out.println("1. ASCENDING");
                            System.out.println("2. DESCENDING");
                            System.out.print("PLEASE CHOOSE: ");
                            choose2 = z.nextInt();
                            switch(choose2){
                                case 1:
                                    Collections.sort(studentMap, (Student sv1, Student sv2) -> {
                                        if ((sv1.getGpa()).compareTo((sv2.getGpa())) < 0) {
                                            return -1;
                                        }
                                        else{
                                            return 1;
                                        }
                                    });
                                    break;
                                case 2:

                                    break;
                                default:
                                    replayLoop = true;
                                    System.out.println("YOU CHOOSE WRONG! PLEASE TRY AGAIN!");
                                    break;
                            }
                        }
                        while(replayLoop == true);
                    }
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    System.exit(0);
            }
        }
    }

    public static void showMenu() {
        System.out.print("\n\n\n");
        System.out.println("=== STUDENT MANAGEMENT ===");
        System.out.println("1. ADD STUDENT");
        System.out.println("2. EDIT STUDENT BY ID");
        System.out.println("3. DELETE STUDENT BY ID");
        System.out.println("4. SORT STUDENT BY GPA");
        System.out.println("5. SORT STUDENT BY NAME");
        System.out.println("6. SHOW STUDENT");
        System.out.println("7. SAVE STUDENT INFORMATION INTO FILE student.obj");
        System.out.println("8. READ STUDENT INFORMATION FROM FILE student.obj AND SHOW TO SCREEN");
        System.out.println("9. EXIT");
        System.out.print("PLEASE CHOOSE AN OPTION: ");
    }
}
