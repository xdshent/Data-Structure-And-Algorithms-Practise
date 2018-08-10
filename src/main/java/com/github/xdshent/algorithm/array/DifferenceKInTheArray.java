package com.github.xdshent.algorithm.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Find pairs with given difference k in the array
 * Given an unsorted array of integers, print all pairs with given difference k in it.
 * <p>
 * For example,
 * Input:
 * arr = {1,5,2,2,2,5,5,4}
 * k=3
 * <p>
 * Output:
 * {2,5} and {1,4}
 */
public class DifferenceKInTheArray {
    /**
     * We can use set to solve this problem in linear time. The idea is to insert each element
     * of the array array[i] in a set. We also checks if element(array[i]-diff) or (array[i]+diff)
     * already exists in the set or not. If the element is seen before, we print the pair (array[i],array[i]-diff)
     * or (array[i]+diff,array[i])
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(N)
     *
     * @param array
     * @param diff
     */
    public static void findPair1(int[] array, int diff) {
        //take an empty set
        Set<Integer> set = new HashSet<>();

        for (int i : array) {
            //check if pair with given difference (i, i-diff) exist
            if (set.contains(i - diff)) {
                System.out.println("(" + i + "," + (i - diff) + ")");
            }

            //check if pair with given difference (i+diff,i) exist
            if (set.contains(i + diff)) {
                System.out.println("(" + (i + diff) + "," + i + ")");
            }

            //insert element into the set
            set.add(i);
        }
    }

    /**
     * hand duplicates
     *
     * @param array
     * @param diff
     */
    public static void findPair2(int[] array, int diff) {
        //sort array in ascending order
        Arrays.sort(array);

        //take an empty set
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            //to avoid printing duplicates(skip adjacent duplicates)
            while (i + 1 < array.length && array[i] == array[i + 1]) {
                i++;
            }

            //check if pair with given difference(array[i], array[i]-diff) exists
            if (set.contains(array[i] - diff)) {
                System.out.println("(" + array[i] + "," + (array[i] - diff));
            }

            //check if pair with given difference(array[i]+diff,array[i]) exists
            if (set.contains(array[i] + diff)) {
                System.out.println("(" + (array[i] + diff) + "," + array[i] + ")");
            }

            //insert element into the set
            set.add(array[i]);
        }
    }
}
