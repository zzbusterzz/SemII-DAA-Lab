/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrixChainMult;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Runtime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 30*35 35*15 15*5 5*10 10*20 20*25 as N size 7 as in 7 unique values
        System.out.println("Enter Dimension size");
        
        //Unique dimension values ie 30,35,15,5,10,20,25
        int n = sc.nextInt();
        System.out.println("Enter D0...Dn values");
        int[] data = new int[n];
        for(int i = 0; i < n; i++){
            if(sc.hasNextInt())
                data[i] = sc.nextInt();
            else
                i--;
        }
        
        MatrixChain(data);
    }
        
    private static void MatrixChain(int[] data){
        int n = data.length - 1;
        int[][] minTable = new int[n][n];
        int[][] bracketTable = new int[n][n];
        
        for(int len = 1; len < n; len++){
            for(int i = 0; i < n - len; i++){
                int j = i + len;
                minTable[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    int cost = minTable[i][k] + minTable[k+1][j] + data[i]*data[k+1]*data[j+1];
                    if(cost < minTable[i][j]){
                        minTable[i][j] = cost;
                        bracketTable[i][j] = k+1;
                    }
                }
            }
        }
        
        System.out.println("Cost Table : ");
        for(int i = 0; i < minTable.length; i++){
            System.out.println(Arrays.toString(minTable[i]));
        }
        
        System.out.println("Brackets Table : ");
        for(int i = 0; i < bracketTable.length; i++){
            System.out.println(Arrays.toString(bracketTable[i]));
        }
        
        PrintParenthesis(bracketTable, 0, bracketTable.length -1 , data);
    }
    
    private static void PrintParenthesis(int[][] bracketTable, int i, int j, int[] data){
        if(i == j)
            System.out.print(data[i] + " ");
        else{
            System.out.print("(");
            PrintParenthesis(bracketTable, i, bracketTable[i][j]-1 , data);
            PrintParenthesis(bracketTable, bracketTable[i][j]-1+1, j , data);
            System.out.print(")");
        }
    }
}