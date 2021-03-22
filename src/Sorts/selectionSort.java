/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class selectionSort {

    /**
     * @param args the command line arguments
     */
    
    private static List<Integer> dataArray;
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Enter array values (Char values to break)");
        
        Scanner sc = new Scanner(System.in);
        dataArray = new ArrayList<>();
        
        boolean run = true;
        
        while(run){
            if(sc.hasNextInt()){
                dataArray.add(sc.nextInt());
            }else{
                run = false;
            }
        }
        
        System.out.println("Initial values of array:");
        for(int i = 0; i < dataArray.size(); i++){
             System.out.println(dataArray.get(i));
        }
        
        int index = 0;
        int temp;
        for(int i = 0; i < dataArray.size() - 1; i++){
            index = i;
            for(int j = i+1; j < dataArray.size(); j++){
                if(dataArray.get(index) > dataArray.get(j)){
                    index = j;
                }
            }
            
            if(index != i){//Swap
                temp = dataArray.get(index);
                dataArray.set(index, dataArray.get(i));
                dataArray.set(i, temp);
            }
        }
        
        System.out.println("Final values of array:");
        for(int i = 0; i < dataArray.size(); i++){
             System.out.println(dataArray.get(i));
        }
    }
}
