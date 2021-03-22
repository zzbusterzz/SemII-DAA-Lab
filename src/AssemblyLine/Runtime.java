/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssemblyLine;

/**
 *
 * @author Student
 */
public class Runtime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[][] assembly = {{7,9,3,4,8,4 },{8,5,6,4,5,7} };
        int[][] transfer = {{2,3,1,3,4},{2,1,2,2,1}};
        int[] entry = {2,4};
        int[] exit = {3,2};
        
        FastestWay(assembly, transfer, entry,exit,assembly[0].length);
    }
    
    
    //a - assemblyCost
    //t - transferCost
    //e - entryCost
    //x - exitCost
    //n - assembly length
    public static void FastestWay(int[][] a, int[][] t, int[] e, int[] x , int n){
        int maxSizeOfAssemblyModule = a[0].length;
        
        int[] f1 = new int[maxSizeOfAssemblyModule];//First assembly line
        int[] f2 = new int[maxSizeOfAssemblyModule];//Second assembly line
        
        f1[0] =  a[0][0] + e[0];
        f2[0] =  a[1][0] + e[1];
        
        int[] l1 = new int[maxSizeOfAssemblyModule];//tracks min cost station on f1
        int[] l2 = new int[maxSizeOfAssemblyModule];//tracks min cost station on f2
        
        for(int i = 1; i < maxSizeOfAssemblyModule ; i++){
            if(f1[i - 1] + a[1][i] <= f2[i - 1] + a[0][i] + t[1][i-1] ){
                f1[i] = f1[i-1] + a[0][i];
                l1[i] = 1;
            }else{
                f1[i] = f2[i-1] + a[0][i] + t[1][i-1];
                l1[i] = 2;
            }
            
            if(f2[i - 1] + a[1][i] <= f1[i - 1] + a[1][i] + t[0][i-1] ){
                f2[i] = f2[i-1] + a[1][i];                
                l2[i] = 2;
            }else{
                f2[i] = f1[i-1] + a[1][i] + t[0][i-1];
                l2[i] = 1;
            }
        }
        
        int totalMinCost = 0;
        int lastExitPath = 0;
        if(f1[n - 1] + x[0]  <= f2[n -1] + x[1]){
            totalMinCost = f1[n - 1] + x[0];
            lastExitPath = 1;
        }else{
            totalMinCost = f2[n - 1] + x[1];
            lastExitPath = 1;
        }
        
        System.out.println("Total min cost : " + totalMinCost);
        
        int i = lastExitPath;
        System.out.println("Station :" + n + " is at Line : " + i );
        
        for(int j = n-1; j > 0; j--){
            if(i == 1){
                i = l1[j];
            }else{
                i = l2[j];
            }
            System.out.println("Station :" + (j) + " is at Line : " + i );
        }
    }
}
