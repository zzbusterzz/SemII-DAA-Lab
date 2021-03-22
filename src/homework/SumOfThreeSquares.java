/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

import java.util.Scanner;

/**
 *
 * @author 1
 */
public class SumOfThreeSquares {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int no = sc.nextInt();

        System.out.println("Is " + no + " sum of three squares : " + isSumofSquare(no));
    }

    private static boolean isSumofSquare(int no) {
        if (no < 0) {
            return false;
        }
        
        //no != 4^ a(8*b + 7) then 
        while (no > 0 && no % 4 == 0) 
            no = no / 4;//reduce 4 power from number
        return no % 8 != 7;//return true if remainder of no mod 8 is not 7
    }
}
