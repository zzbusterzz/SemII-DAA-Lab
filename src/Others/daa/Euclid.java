/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa;

import static daa.Factorise.GenerateDivisors;
import static daa.Factorise.printList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Euclid {

    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("Enter two no to find Common factorial");

        int m = sc.nextInt();
        int n = sc.nextInt();

        int r = 0;
        while (n % m != 0) {
            r = n % m;
            n = m;
            m = r;
        }

        System.out.println("GCD:" + m);
    }
}
