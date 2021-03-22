/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class HillValley {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        boolean isAdding  = true;
        System.out.println("Enter integer, enter character to exit");
        List<Integer> data = new ArrayList<>();
        while(isAdding){
            if(sc.hasNextInt()){
                data.add(sc.nextInt());
            }else{
                isAdding = false;
                sc.next();
            }
        }
        Integer[] in = data.toArray(new Integer[data.size()]);
        System.out.println("Is array hillvalley : " + hillValley(in));
        
//        int[] value1 = {1,2,3,4,3,2,1};
//        
//        int[] value2 = {4,3,2,1,2,3,4};
//        
//        int[] value3 = {1,1,2,8,4,6,9};
//        
//        int[] value4 = {1,1};
//        
//        int[] value5 = {1};
//        
//        System.out.println(" is hillvallye : " + hillValley(value1));
//        
//        System.out.println(" is hillvallye : " + hillValley(value2)); 
//        
//        System.out.println(" is hillvallye : " + hillValley(value3));
//        
//        System.out.println(" is hillvallye : " + hillValley(value4));
//        
//        System.out.println(" is hillvallye : " + hillValley(value5));
    }
    
    public static boolean hillValley(Integer[] values){
        if(values.length >= 2 && (isHill(values) || isValley(values)))
            return true;
        return false;
    }
    
    private static boolean isHill(Integer[] values){//acending and descending
        boolean isAscending = true;
        boolean isDescending = true;
        
        boolean hasAscendedAtleastOnce = false;
        
        for(int i = 0; i < values.length - 1 ; i++){
            if(values[i] == values[i+1])
                return false;
            
            if(isAscending){
                if(values[i] > values[i+1])
                    isAscending = false;
                else{
                    hasAscendedAtleastOnce = true;
                }
            }else{
                if(values[i] < values[i+1]){
                    isDescending = false;
                    break;
                }
            }
        }
        
        if(!isAscending && hasAscendedAtleastOnce && isDescending)
            return true;
        else        
            return false;
    }
    
    private static boolean isValley(Integer[] values){
        boolean isAscending = true;
        boolean isDescending = true;
        
        boolean hasDecendedAtleastOnce = false;
          
        for(int i = 0; i < values.length - 1 ; i++){
            if(values[i] == values[i+1])
                return false;
        
            if(isDescending){
                if(values[i] < values[i+1])
                    isDescending = false;
                else{
                    hasDecendedAtleastOnce = true;
                }
            }else{
                if(values[i] > values[i+1]){
                    isAscending = false;
                    break;
                }
            }
        }
        
        if(!isDescending && hasDecendedAtleastOnce && isAscending)
            return true;
        else        
            return false;
    }
    
}
