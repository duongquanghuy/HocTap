/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt62phan1;

/**
 *
 * @author DuongQuangHuy
 */
public class BT62Phan1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Object objSync = new Object();

        ThreadOne threadOne = new ThreadOne(objSync);
        ThreadTwo threadTwo = new ThreadTwo(objSync);

        threadOne.start();
        threadTwo.start();
    }
}
