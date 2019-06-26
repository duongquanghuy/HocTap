/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt13;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duy Lumiere
 */
public class Zoo {
    List<Cage> cageList = new ArrayList<>();
    boolean countCheck = false;
    boolean delCageCheck = false;
    
    void addCage(Cage c) {
        cageList.forEach((cage) -> {
            if(cage.cageId == c.cageId){
                countCheck = true;
            }
        });
        if(countCheck) {
            System.out.println("This zoo already had this cage");
        }
        else {
            cageList.add(c);
            System.out.println("Add cage success");
        }
    }
    
    void delCage(int cid) {
        for(Cage cage : cageList) {
            if(cage.cageId == cid) {
                cageList.remove(cage);
                System.out.println("Cage removed Success");
                delCageCheck = true;
                break;
            }
        }
        if(delCageCheck == false) {
            System.out.println("Cage not found!");
        }
        delCageCheck = false;
    }
    
}
