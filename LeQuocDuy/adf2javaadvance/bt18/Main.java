/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duy Lumiere
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner z = new Scanner(System.in);

        int choose, choose2, choose3;
        String idInput, confirm;
        boolean replayLoop = false;
        Map<String, Student> studentMap = new HashMap<>();
        File studentObj = new File("C:\\Users\\Duy Lumiere\\Documents\\NetBeansProjects\\T1811E\\src\\adf2javaadvance\\bt18\\student.obj");

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
                    if (studentMap.isEmpty()) {
                        System.out.println("There is no Student added! Back to menu and choose 1");
                    } else {
                        z.nextLine();
                        System.out.print("Insert Student Id: ");
                        idInput = z.nextLine();
                        if (studentMap.containsKey(idInput)) {
                            System.out.println("Student with id " + idInput + ": ");
                            System.out.println(studentMap.get(idInput).toString());
                            System.out.println("Edit Information (beware that Student id cannot be change!): ");
                            studentMap.get(idInput).editStudent();
                            System.out.println("Edit Information Success!");
                            System.out.println(studentMap.get(idInput).toString());
                        } else {
                            System.out.println("No result matching this Id Inserted!");
                        }
                    }
                    break;

                case 3:
                    System.out.println("");
                    if (studentMap.isEmpty()) {
                        System.out.println("There is no Student added! Back to menu and choose 1");
                    } else {
                        z.nextLine();
                        System.out.print("Insert Student Id: ");
                        idInput = z.nextLine();
                        if (studentMap.containsKey(idInput)) {
                            System.out.println("Student with id " + idInput + ": ");
                            System.out.println(studentMap.get(idInput).toString());
                            do {
                                System.out.print("Are you sure? (y/n): ");
                                confirm = z.nextLine();
                                if (confirm.length() == 1) {
                                    if (confirm.equalsIgnoreCase("n")) {
                                        replayLoop = false;
                                    } else if (confirm.equalsIgnoreCase("y")) {
                                        studentMap.remove(idInput);
                                        System.out.println("Remove Student Success");
                                        replayLoop = false;
                                    } else {
                                        replayLoop = true;
                                    }
                                } else {
                                    replayLoop = true;
                                }
                            } while (replayLoop == true);
                        } else {
                            System.out.println("No result matching this Id Inserted!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("");
                    if (studentMap.isEmpty()) {
                        System.out.println("There is no Student added! Back to menu and choose 1");
                    } else {
                        do {
                            System.out.println("SORT STUDENTS BY GPA");
                            System.out.println("1. ASCENDING");
                            System.out.println("2. DESCENDING");
                            System.out.print("PLEASE CHOOSE: ");
                            choose2 = z.nextInt();
                            switch (choose2) {
                                case 1:
                                    List<Map.Entry<String, Student>> compareListGpaAsc = new ArrayList<>();
                                    compareListGpaAsc.addAll(studentMap.entrySet());

                                    Collections.sort(compareListGpaAsc, (Map.Entry<String, Student> o1, Map.Entry<String, Student> o2) -> {
                                        if (o1.getValue().getGpa() < o2.getValue().getGpa()) {
                                            return -1;
                                        } else {
                                            return 1;
                                        }
                                    });

                                    compareListGpaAsc.forEach((s) -> {
                                        System.out.println(s);
                                    });
                                    break;
                                case 2:
                                    List<Map.Entry<String, Student>> compareListGpaDes = new ArrayList<>();
                                    compareListGpaDes.addAll(studentMap.entrySet());

                                    Collections.sort(compareListGpaDes, (Map.Entry<String, Student> o1, Map.Entry<String, Student> o2) -> {
                                        if (o1.getValue().getGpa() > o2.getValue().getGpa()) {
                                            return -1;
                                        } else {
                                            return 1;
                                        }
                                    });

                                    compareListGpaDes.forEach((s) -> {
                                        System.out.println(s);
                                    });
                                    break;
                                default:
                                    replayLoop = true;
                                    System.out.println("YOU CHOOSE WRONG! PLEASE TRY AGAIN!");
                                    break;
                            }
                        } while (replayLoop == true);
                    }
                    break;

                case 5:
                    System.out.println("");
                    if (studentMap.isEmpty()) {
                        System.out.println("There is no Student added! Back to menu and choose 1");
                    } else {
                        do {
                            System.out.println("SORT STUDENTS BY NAME");
                            System.out.println("1. A to Z");
                            System.out.println("2. Z to A");
                            System.out.print("PLEASE CHOOSE: ");
                            choose3 = z.nextInt();
                            switch (choose3) {
                                case 1:
                                    List<Map.Entry<String, Student>> compareListNameAsc = new ArrayList<>();
                                    compareListNameAsc.addAll(studentMap.entrySet());

                                    Collections.sort(compareListNameAsc, (Map.Entry<String, Student> o1, Map.Entry<String, Student> o2) -> {
                                        return o1.getValue().getName().compareTo(o2.getValue().getName());
                                    });

                                    compareListNameAsc.forEach((s) -> {
                                        System.out.println(s);
                                    });
                                    break;
                                case 2:
                                    List<Map.Entry<String, Student>> compareListNameDes = new ArrayList<>();
                                    compareListNameDes.addAll(studentMap.entrySet());

                                    Collections.sort(compareListNameDes, (Map.Entry<String, Student> o1, Map.Entry<String, Student> o2) -> {
                                        return (-1) * (o1.getValue().getName().compareTo(o2.getValue().getName()));
                                    });

                                    compareListNameDes.forEach((s) -> {
                                        System.out.println(s);
                                    });
                                    break;
                                default:
                                    replayLoop = true;
                                    System.out.println("YOU CHOOSE WRONG! PLEASE TRY AGAIN!");
                                    break;
                            }
                        } while (replayLoop == true);
                    }
                    break;

                case 6:
                    System.out.println("");
                    if (studentMap.isEmpty()) {
                        System.out.println("There is no Student added! Back to menu and choose 1");
                    } else {
                        System.out.println("STUDENTS LIST: ");
                        studentMap.entrySet().forEach((s) -> {
                            System.out.println(s);
                        });
                    }
                    break;

                case 7:
                    System.out.println("");
                    if (studentMap.isEmpty()) {
                        System.out.println("There is no Student added! Back to menu and choose 1");
                    } else {
                        try {
                            FileOutputStream fos = new FileOutputStream(studentObj);
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(studentMap);
                            System.out.println("Save Success!");
                            fos.close();
                            oos.close();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                case 8:
                    System.out.println("");
                    if (studentMap.isEmpty()) {
                        System.out.println("There is no Student added! Back to menu and choose 1");
                    }else if(!studentObj.exists()){
                        System.out.println("Data file not have any contents yet!");
                    }else {
                        FileInputStream fis = new FileInputStream(studentObj);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        Map<String, Student> temp = (Map<String, Student>) ois.readObject();
                        temp.entrySet().forEach((s) -> {
                            System.out.println(s.toString());
                        });
                        fis.close();
                        ois.close();
                    }
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
