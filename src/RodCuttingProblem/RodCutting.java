/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RodCuttingProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author MScIT17
 */
public class RodCutting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        
        System.out.println("Enter length of rod: ");
        int lengthofRod = sc.nextInt();
        List<Integer> lengthProfitPerPiece = new ArrayList<Integer>();
        lengthProfitPerPiece.add(2);
        lengthProfitPerPiece.add(5);
        lengthProfitPerPiece.add(9);
        lengthProfitPerPiece.add(6);
        
        int totalSizes = lengthProfitPerPiece.size();
        
        int[][] rodCostPerPiece = new int[lengthofRod][totalSizes];
        
        int costExcluding = 0;
        for(int i = 1; i < lengthofRod; i++){
            for(int j = 1; j < totalSizes; j++){
              
                
                
                if(i > j){
                    costExcluding = rodCostPerPiece[i][j-1];
                    rodCostPerPiece[i][j] = costExcluding;
                }else{
                    int costIncluding = 0;
                    if(i == j){
                        costExcluding = rodCostPerPiece[i-1][j];
                                
                        costIncluding = lengthProfitPerPiece.get(i);
                        
                    }else{
                        int totalLength = j;
                        costExcluding = rodCostPerPiece[i-1][j];
                        while(totalLength > 0){
                            int temp = i % totalLength;
                            if(totalLength == 1)
                                totalLength = 0; 
                            totalLength -= temp;
                            costIncluding += rodCostPerPiece[i][temp];
                        }
                    }
                    rodCostPerPiece[i][j] = Math.max( costExcluding, costIncluding);
                    System.out.println("i : " + i + " J :" + j + "Cost : "+ 10 + " " + costExcluding);
                    
                }
                
                //int profit = Math.max(j, j);
            }
        }
        int max = 0;
         for(int i = 0; i < lengthofRod; i++){
            System.out.println();
            for(int j = 0; j < totalSizes; j++){
                if(max < rodCostPerPiece[i][j])
                    max = rodCostPerPiece[i][j];
                System.out.print(rodCostPerPiece[i][j] + " ");
            }
         }
          
         System.out.println("\nMax obtainable cost is : " + max);
    }
    
}
