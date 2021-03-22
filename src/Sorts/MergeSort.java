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
public class MergeSort {

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
        
        DivideArray(dataArray, 0, dataArray.size()-1);
        
        System.out.println("Final values of array:");
        for(int i = 0; i < dataArray.size(); i++){
             System.out.println(dataArray.get(i));
        }
    }
    
    public static void DivideArray(List<Integer> array, int begin, int end){
        
        if(begin < end){
            int mid = (end - begin)/2;
            mid = begin + mid;
            
           // System.out.println("Begin :" + begin + "Mid : " + mid + "End : " + end);
            
            DivideArray(array, begin, mid);
            DivideArray(array, mid+1, end);

            Merge(array, begin, mid, end);
        }
    }
    
    public static void Merge(List<Integer> array, int start, int mid,int end)
    {
        int start2 = mid+1;
        
        while(start <= mid && start2 <= end){
            //System.out.println("start :" + start + "mid : " + mid + "end : " + end );
            if(array.get(start) <= array.get(start2)){
                start++;
            }else{
                int index = start2;
                int value = array.get(start2);
                
                //move values to right
                while(index != start){
                    array.set(index, array.get(index-1));
                    index--;
                }
                array.set(index, value);                
                start2++;
            }
        }
    }
}
