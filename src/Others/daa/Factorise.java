/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Factorise {

    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("Enter two no to find Common factorial");

        int m = sc.nextInt();
        int n = sc.nextInt();

        List<Integer> divisorsofM = new ArrayList<Integer>();
        List<Integer> divisorsofN = new ArrayList<Integer>();
        
        
        GenerateDivisors(m, divisorsofM);
        GenerateDivisors(n, divisorsofN);
        
        printList(divisorsofM);
        printList(divisorsofN);
        
        //GCD
        int GCD = 1;
        while(divisorsofM.size() > 0 && divisorsofN.size() > 0){
            int value = divisorsofM.remove(0);
            
            if( divisorsofN.contains(value) )
            {
                divisorsofN.remove(divisorsofN.indexOf(value));
                GCD *= value;
            }
        }
        System.out.println("GCD : " + GCD);
    }
    
    public static void GenerateDivisors(int value, List<Integer> divisor){
        int beginint = 2;
        while (value > 1) {
            if (value % beginint == 0) {
                value = value / beginint;
                divisor.add(beginint);
            } else {
                beginint++;
            }
        }
    }
    
    public static void printList(List<Integer> divisor){
        System.out.println("Divisors Final:");
        System.out.println(Arrays.toString(divisor.toArray()));
    }
}
