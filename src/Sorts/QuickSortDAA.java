/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorts;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class QuickSortDAA {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        ArrayList<Integer> nosList = new ArrayList<>(); 
        System.out.println("Enter new values in array, other characters to exit");
        while(run){
            if(sc.hasNextInt())
            {
                nosList.add(sc.nextInt());
            }
            else
            {
                run = false;
            }
        }
        
        quickSort(nosList, 0 , nosList.size() - 1);
    }
    
   public static void quickSort(ArrayList<Integer> arrayA, int beginP, int endP){
        if(beginP != endP && endP > 0 ){
            int q = sort(arrayA, beginP, endP);
            quickSort(arrayA, beginP, q-1);
            quickSort(arrayA, q+1, endP);
        }
   }
    
    public static int sort(ArrayList<Integer> arrayA, int beginP, int endP){
        int i = beginP-1;
        int x = arrayA.get(endP);
        
        int temp;
        for(int j = beginP; j < endP; j++){
            if(arrayA.get(j) <= x){
                i++;
                temp = arrayA.get(i);
                arrayA.set(i, arrayA.get(j));
                arrayA.set(j, temp);
            }
        }
        
        temp = arrayA.get(i+1);
        arrayA.set(i+1, arrayA.get(endP));
        arrayA.set(endP,temp);
        
        PrintArray(arrayA);
       
        return i+1;
    }
    
    public static void PrintArray(ArrayList<Integer> arrayA){
        System.out.println();
        for (Integer arrayA1 : arrayA) {
            System.out.print(arrayA1);
        }
    }
    
}
