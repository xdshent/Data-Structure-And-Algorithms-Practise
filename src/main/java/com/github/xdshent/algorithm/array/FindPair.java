package com.github.xdshent.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given unsorted array of integers, find a pair with given sum in it.
 * <p>
 * For example:
 * <p>
 * Input:
 * arr = [8,7,2,5,3,1]
 * sum = 10
 * <p>
 * Output:
 * Pair found at index 0 and 2 (8 + 2)
 * or
 * Pair found at index 1 and 4 (7 + 3)
 */
public class FindPair {

    /**
     * Naive method to find a pair in an array with given sum.
     * <p>
     * time complexity: O(N^2)
     * auxiliary space used: O(1)
     *
     * @param array
     * @param sum
     */
    public static void findPair1(int[] array, int sum) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    System.out.printf("Pair found at index %d and %d \n", i, j);
                    return;
                }
            }
        }
        System.out.println("Pair not found.");
    }

    /**
     * Naive method to find a pair in an array with given sum.
     * <p>
     * time complexity: O(Nlog(N))
     * auxiliary space used: O(1)
     *
     * @param array
     * @param sum
     */
    public static void findPair2(int[] array, int sum) {
        // sort the array in ascending order
        Arrays.sort(array);//O(Nlog(N))

        //maintain two indicates pointing to end-points of the array
        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            //sum found
            if (array[low] + array[high] == sum) {
                System.out.printf("Pair found at index %d and %d \n", low, high);
                return;
            }

            if (array[low] + array[high] < sum) {
                low++;
            } else {
                high--;
            }
        }
        System.out.println("Pair not found.");
    }

    /**
     * Naive method to find a pair in an array with given sum.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(N)
     *
     * @param array
     * @param sum
     */
    public static void findPair3(int[] array, int sum) {
        //create an empty Hash Map
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(sum - array[i])) {
                System.out.printf("Pair found at index %d and %d \n", map.get(sum - array[i]), i);
                return;
            }

            //store index of current element in the map
            map.put(array[i], i);
        }
        System.out.println("Pair not found.");
    }
}
