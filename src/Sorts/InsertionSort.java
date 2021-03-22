package Sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author MScIT17
 */
public class InsertionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value, non int to cancel");
        List<Integer> array = new ArrayList();
        while (sc != null && sc.hasNext()) {
            if (sc.hasNextInt()) {
                int no = sc.nextInt();
                array.add(no);
            } else {
                sc.next();
                sc.close();
                sc = null;
            }
        }

        InsertionSortArray(array);
    }

    public static void InsertionSortArray(List<Integer> array) {
        for (int i = 1; i < array.size(); i++) {
            int value = array.get(i);
            int firstArrayIndex = i - 1;

            while (firstArrayIndex >= 0 && array.get(firstArrayIndex) > value) {
                array.set(firstArrayIndex + 1, array.get(firstArrayIndex));
                firstArrayIndex--;
            }
            array.set(firstArrayIndex + 1, value);
        }

        System.out.println("Divisors Final:");
        System.out.println(Arrays.toString(array.toArray()));
    }
}
