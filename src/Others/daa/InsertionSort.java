/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class InsertionSort {
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("Enter value, non int to cancel");
        
        while(sc.hasNext()){
            if(sc.hasNextInt()){
                int no = sc.nextInt();
                
            }else
            {
                sc.next();
                sc.close();
            }
            
            
        }
    }
    
    public static void InsertInArray(int no, List<Integer> array){
        array.add(no);
        int  i = 0;
        for(int j = 2; j < array.size(); j++)
        {
            int key = array.get(j);
            i = j - 1;
            
            while(i > 0 & array.get(i) > key){
                int temp = array.get(i);
                array.set(i, array.get(i - 1));
                array.set(i-1, temp);
                i--;
            }
            
            //array.get(i+1)
        }
        
        System.out.println("Divisors Final:");
        System.out.println(Arrays.toString(array.toArray()));
    }
}
