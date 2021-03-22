package gcd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author MScIT17
 */
public class SimpleFactorisation {

    public static void main(String[] args) {
        int M, N;

        ArrayList<Integer> divisorsM = new ArrayList<Integer>();
        ArrayList<Integer> divisorsN = new ArrayList<Integer>();

        Scanner s = new Scanner(System.in);

        System.out.println("Enter first number:");
        M = s.nextInt();
        System.out.println("Enter second number:");
        N = s.nextInt();
        System.out.println(M + " " + N);

        divisorsArray(divisorsM, M);
        divisorsArray(divisorsN, N);

        System.out.println(Arrays.toString(divisorsM.toArray()));
        System.out.println(Arrays.toString(divisorsN.toArray()));

        ArrayList<Integer> smallerArray, largerArray;
        if (divisorsM.size() >= divisorsN.size()) {
            smallerArray = divisorsN;
            largerArray = divisorsM;
        } else {
            smallerArray = divisorsM;
            largerArray = divisorsN;
        }

        int GCDValue = 1;
        while (smallerArray.size() > 0) {
            int value = smallerArray.get(0);
            if (largerArray.contains(value)) {
                GCDValue *= value;
                largerArray.remove(largerArray.indexOf(value));
                // largerArray.remove(value);
            }
            //smallerArray.remove(value);
            smallerArray.remove(smallerArray.indexOf(value));
        }

        System.out.println("GCD for " + M + " & " + N + " is : " + GCDValue);
    }

    static void divisorsArray(ArrayList<Integer> divisors, int no) {
        for (int i = 2; i < no; i++) {
            while (no % i == 0) {
                divisors.add(i);
                no = no / i;
            }
        }

        if (no > 2) {
            divisors.add(no);
        }
    }
}
