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
 * @author 1
 */
public class DAA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value, non int to cancel");
        List<Integer> array = new ArrayList();
        
         
        boolean run = true;
        
        
        while (run) {
            if (sc.hasNextInt()) {
                int no = sc.nextInt();
                array.add(no);
            } else {
                run = false;
            }
        }
        //InsertionSort(array);
        //SelectionSort(array);
        //QuickSort(array, 0, array.size()-1);
        MergeSort(array, 0, array.size() - 1);
       
       //DivideArray(array, 0, array.size() - 1);
        System.out.println(Arrays.toString(array.toArray()));
        
        run = true;
        sc.next();
        while(run){
            System.out.println("Enter no to find:");
            if(sc.hasNextInt()){
                int value = BinarySearch(array,sc.nextInt(), 0, array.size()/2, array.size());
                if(value == -1)
                    System.out.println("Element not present");
                else
                    System.out.println("Element is present at : " + value);
            }else{
                run = false;
            }
        }
    }
    
    static void InsertionSort(List<Integer> arr){
        for(int i =1 ; i < arr.size(); i++){
            int index = i-1;
            int value = arr.get(i);
            
            while(index >= 0 && arr.get(index) > value){
                arr.set(index+1, arr.get(index));
                index--;
            }
            arr.set(index+1, value);
        }
    }
    
    static void SelectionSort(List<Integer> arr){
        for(int i = 0; i < arr.size(); i++){
            int minValueIndex = i;
            
            for(int j = i+1; j < arr.size(); j++){
                if(arr.get(minValueIndex) > arr.get(j))
                    minValueIndex = j;
            }
            
            if(minValueIndex != i){
                int temp = arr.get(minValueIndex);
                arr.set(minValueIndex, arr.get(i));
                arr.set(i, temp);
            }
        }
    }
    
    static void QuickSort(List<Integer> arr, int low, int high){
        if(low < high){
            int pivot = Partition(arr, low, high);
            QuickSort(arr,low, pivot-1);
            QuickSort(arr,pivot+1, high);
        }
    }
    
    static int Partition(List<Integer> arr, int low, int pivot){
        int i = low-1;
        int value = arr.get(pivot);
        
        int temp;
        for(int j = low; j < pivot; j++){
            if(arr.get(j) <= value){
                i++;
                temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        temp = arr.get(i+1);
        arr.set(i+1, arr.get(pivot));
        arr.set(pivot, temp);
        
        return i+1;
    }
    
    static void MergeSort(List<Integer> arr, int begin, int end){
        if(begin < end){
            int mid = (end+begin)/2; 
            
            MergeSort(arr, begin, mid);
            MergeSort(arr, mid+1, end);
            
            Merge(arr, begin, mid, end);
        }
    }
    
    
    static void Merge(List<Integer> arr, int begin, int mid, int end){
        int start = begin;
        int start2 = mid+1;
        
        
        while(start <= mid && start2 <= end){
            System.out.println("Start +  " + start + " : " + start2);
            if(arr.get(start) <= arr.get(start2)){
                start++;
            }
            else
            {
                int index = start2;
                int value = arr.get(start2);
                
                while(index != start ){
                   arr.set(index, arr.get(index-1));
                   index--;
                }
                    
                mid++;
            
                arr.set(start2, arr.get(start));
                arr.set(start, value);
                start2++;
            }
        }
    }
        

    
    static int BinarySearch(List<Integer> arr, int value,int beginIndex, int pivot,  int endIndex){
        if(arr.get(pivot) == value)
            return pivot;
        else if(beginIndex == pivot || endIndex == pivot)
              return -1;
        
        if(arr.get(pivot) < value){
          beginIndex = pivot;
          pivot =  pivot + ((endIndex - pivot)/2);
        } else{
            endIndex = pivot;
            pivot = pivot/2;
        }
        
        return BinarySearch(arr, value,beginIndex, pivot,  endIndex);
    }
    
  
}