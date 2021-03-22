package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OptimalStorage {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        new OptimalStorage();

    }

    public OptimalStorage() {

        List<Pair> tapeswithCost = new ArrayList<Pair>();

        tapeswithCost.add(new Pair(1, 5));
        tapeswithCost.add(new Pair(2, 10));
        tapeswithCost.add(new Pair(3, 3));

        tapeswithCost.sort(new incOrder());

        int finalCost = 0;
        for (int i = 0; i < tapeswithCost.size(); i++) {
            int tempSum = 0;
            for (int j = 0; j <= i; j++) {
                tempSum += tapeswithCost.get(j).value;
            }
            finalCost += tempSum;
        }

        System.out.println("min required optimal time is :" + (finalCost));

    }

    class incOrder implements Comparator<Pair> {

        public int compare(Pair i, Pair j) {
            if (i.value < j.value) {
                return -1;
            } else {
                return 1;
            }
        }

    }

    class Pair {

        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
