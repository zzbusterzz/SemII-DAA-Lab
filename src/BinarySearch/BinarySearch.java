/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author MScIT17
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    private static List<Integer> dataArray;
    
    public static void main(String[] args) {
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
       
        run = true;
        sc.next();
        while(run){
            System.out.println("Enter no to find:");
            if(sc.hasNextInt()){
                int value = Search(dataArray.size()/2, sc.nextInt(), 0, dataArray.size());
                if(value == -1)
                    System.out.println("Element not present");
                else
                    System.out.println("Element is present at : " + value);
            }else{
                run = false;
            }
        }
    }
    
    public static int Search(int index, int value, int indexBegin, int indexEnd){
        if(dataArray.get(index) == value)
            return index; 
        else if(indexBegin == index || indexEnd == index)
              return -1;
        
        if(dataArray.get(index) < value){
            indexBegin = index;
            index = index + ((dataArray.size() - index)/2);
           
        }else{
            indexEnd = index;
            index = index/2;
        }
        return Search(index, value, indexBegin, indexEnd);
    }
}
