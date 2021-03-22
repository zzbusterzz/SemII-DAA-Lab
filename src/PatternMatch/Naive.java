/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatternMatch;

import java.util.Scanner;

/**
 *
 * @author 1
 */
public class Naive {
  
    public static void search(String txt, String pat) 
    { 
        int M = pat.length(); 
        int N = txt.length(); 
  
        for (int i = 0; i <= N - M; i++) { 
            int j; 
            for (j = 0; j < M; j++) 
                if (txt.charAt(i + j) != pat.charAt(j)) 
                    break; 
  
            if (j == M) 
                System.out.println("Pattern found at index " + i); 
        } 
    } 
  
    public static void main(String[] args) 
    { 
        Scanner sc = new  Scanner(System.in);
        System.out.println("Enter string");
        String txt = sc.nextLine();
        
        System.out.println("Enter pattern");
        String ptn = sc.nextLine();
        
        search(txt, ptn); 
    } 
}
