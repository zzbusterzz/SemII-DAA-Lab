package gcd;

import java.util.Scanner;

/**
 *
 * @author MScIT17
 */

public class EuclidGCD {
    
    public static void main(String[] args){
        int m,n,i, temp;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter M");
        m = sc.nextInt();
        System.out.println("Enter N");
        n = sc.nextInt();
        System.out.println("First Number is : "+m);
        System.out.println("Second Number is : "+n);
        
        while(n%m != 0){
            
                temp = n%m;
                n = m;
                m = temp;
            }
        System.out.println("GCD is : "+m);
    }
}
