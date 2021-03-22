/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OBST;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 1
 */
public class Runtime {

    /**
     * @param args the command line arguments
     */
    static int optimalSearchTree(Integer keys[], Integer freq[], int n) { 
        int cost[][] = new int[n + 1][n + 1]; 
        for (int i = 0; i < n; i++) 
            cost[i][i] = freq[i]; 
  
        for (int L = 2; L <= n; L++) { 
            for (int i = 0; i <= n - L + 1; i++) { 
                int j = i + L - 1; 
                cost[i][j] = Integer.MAX_VALUE; 
                for (int r = i; r <= j; r++) { 
                    int c = ((r > i) ? cost[i][r - 1] : 0) 
                            + ((r < j) ? cost[r + 1][j] : 0) + sum(freq, i, j); 
                    if (c < cost[i][j]) 
                        cost[i][j] = c; 
                } 
            } 
        } 
        return cost[0][n - 1]; 
    } 
  
    static int sum(Integer freq[], int i, int j) { 
        int s = 0; 
        for (int k = i; k <= j; k++) { 
            if (k >= freq.length) 
                continue; 
            s += freq[k]; 
        } 
        return s; 
    } 
  
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter keys");
        
        List<Integer> keys = new ArrayList<Integer>();
        
        List<Integer> freq = new ArrayList<Integer>();
        
        boolean run = true;
        
        while(run){
            if(sc.hasNextInt()){
                keys.add(sc.nextInt());
            }else{
                run = false;
            }
        }
        
        run = true;
        sc.next();
        System.out.println("Enter freq");
        
        while(run){
            if(sc.hasNextInt()){
                freq.add(sc.nextInt());
            }else{
                run = false;
            }
        }
        
        int size = keys.size(); 
        if(size == freq.size() && (size > 0)){
            
            Integer[] arr = new Integer[keys.size()]; 
            arr = keys.toArray(arr); 
            
            Integer[] arr2 = new Integer[keys.size()]; 
            arr2 = freq.toArray(arr2); 
            
            System.out.println("Cost of Optimal BST is " + optimalSearchTree(arr, arr2, size)); 
        }else{
            System.out.println("Entered values are not equal or 0"); 
        }        
    }    
}
