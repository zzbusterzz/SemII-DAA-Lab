/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeWork;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Repfree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println("Is The character is repeated : " + repFrees(s));
    }

    public static boolean repFrees(String S) {
        int length = S.length();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j && S.charAt(i) == S.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

}
