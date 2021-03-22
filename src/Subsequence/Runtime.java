/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subsequence;

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

        System.out.println("Enter first string");
        String s1 = sc.nextLine();
        System.out.println("Enter second string");
        String s2 = sc.nextLine();

        int m = s1.length();
        int n = s2.length();

        int[][] c = getLength(s1, s2, m, n);

        String sub = LCSString(c, s1, s2, m, n);

        System.out.println("Longest common subsequnce is " + sub);
    }

    public static int[][] getLength(String s1, String s2, int m, int n) {
        int[][] c = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Math.max(c[i][j - 1], c[i - 1][j]);
                }
            }
        }
        return c;
    }

    public static String LCSString(int[][] c, String s1, String s2, int i, int j) {
        if (i == 0 || j == 0) {
            return "";
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return LCSString(c, s1, s2, i - 1, j - 1) + s1.charAt(i - 1);
        }

        if (c[i][j - 1] > c[i - 1][j]) {
            return LCSString(c, s1, s2, i, j - 1);
        }

        return LCSString(c, s1, s2, i - 1, j);
    }
}
