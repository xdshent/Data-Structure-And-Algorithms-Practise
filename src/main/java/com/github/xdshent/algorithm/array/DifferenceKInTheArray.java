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

    /**
     * we can avoid using extra space by performing binary search for element(array[i]-diff) or
     * (array[i]+diff) in stead of using hashing
     * <p>
     * time complexity: O(NlogN)
     * auxiliary space used: O(1)
     *
     * @param array
     * @param diff
     */
    public static void findPair3(int[] array, int diff) {
        //sort array in ascending order
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            //to avoid printing duplicates (skip adjacent duplicates)
            while (i < array.length - 1 && array[i] == array[i + 1]) {
                i++;
            }

            //perform binary search for element (array[i]-diff)
            if (Arrays.binarySearch(array, array[i] - diff) > 0) {
                System.out.println("(" + array[i] + "," + (array[i] - diff) + ")");
            }
        }
    }

    /**
     * The idea is somewhat similar to findign pair with given sum in the array.But instead of
     * starting from two end-points of the array, we start from begining of the sorted array.
     * <p>
     * time complexity: O(NlogN)
     * auxiliary space used: O(1)
     *
     * @param array
     * @param diff
     */
    public static void findPair4(int[] array, int diff) {
        //sort array in ascending in the array
        Arrays.sort(array);

        //maintain two indicates in the array
        int i = 0, j = 0;
        int n = array.length;

        while (i < n && j < n) {
            //to avoid printing duplicate
            while (i < n - 1 && array[i] == array[i + 1]) {
                i++;
            }

            while (j < n - 1 && array[j] == array[j + 1]) {
                j++;
            }

            //increasing i if current difference is more than the desired difference
            if (array[j] - array[i] > diff) {
                i++;
            }
            //increasing j if current difference is less than the desired difference
            else if (array[j] - array[i] < diff) {
                j++;
            }
            //print the pair and increasing both i, j if current difference is same as the desired
            // difference
            else {
                System.out.println("(" + array[j] + "," + array[i] + ")");
                i++;
                j++;
            }
        }
    }
}
