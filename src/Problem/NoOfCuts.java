/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem;

import java.util.Scanner;

/**
 *
 * @author 1
 */
public class NoOfCuts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter width of rectangle");
        int m = sc.nextInt();
        System.out.println("Enter height of rectangle");
        int n = sc.nextInt();
        
        //No of minimum cuts is given by formula log2(m) + log2(n)
        //Reduce by half method
        double no_of_cuts =  Math.ceil(returnLog2(m) + returnLog2(n));
        
        System.out.println("No of minimum cuts required to get " + m*n + " squares are "+ no_of_cuts );
    }
    
    private static double returnLog2(int n){
        return (Math.log(n)/Math.log(2));
    }
    
}
