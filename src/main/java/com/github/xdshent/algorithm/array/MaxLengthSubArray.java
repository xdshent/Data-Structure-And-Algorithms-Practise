package com.github.xdshent.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Find maximum length sub-array having given sum
 * <p>
 * Given an array of integers, find maximum length sub-array having given
 * sum.
 * <p>
 * For example, consider below array
 * <p>
 * A[] = {5,6,-5,5,3,5,3,-2,0}
 * sum = 8
 * <p>
 * Sub-arrays with sum 8 are:
 * {-5,5,3,5}
 * {3,5}
 * {5,3}
 * <p>
 * The longest sub-array is {-5,5,3,5} having length 4
 */
public class MaxLengthSubArray {

    /**
     * Naive solution would be to consider all sub-arrays and find their
     * sum. If sub-array sum is equal to given sum, we update maximum
     * length sub-array. The time complexity of naive solution is O(N^3)
     * as there are N^2 sub-arrays and it takes O(N) time to find sum of
     * its elements. The method can be optimized to run in O(N^2) time by
     * calculating sub-array sum in constant time.
     *
     * @param array
     * @param sum
     */
    public static void maxLengthSubArray1(int[] array, int sum) {
        int len = 0;
        int ending_index = -1;

        //consider all sub-arrays starting from i
        for (int i = 0; i < array.length; i++) {
            int s = 0;

            //consider all sub-arrays ending at j
            for (int j = i; j < array.length; j++) {
                s += array[j];

                if (s == sum) {
                    if (len < j - i + 1) {
                        len = j - i + 1;
                        ending_index = j;
                    }
                }
            }
        }
        System.out.println("[" + (ending_index - len + 1) + ", " + ending_index + "]");
    }

    /**
     * We can use map to solve this problem in linear time. The idea is to
     * create an empty map to store ending index of first sub-array having
     * given sum. We traverse the given array, and maintain sum of
     * elements seen so far.
     * <p>
     * If sum is seen for first time, insert the sum with its index into
     * the map.
     * <p>
     * If is seen before, there exists a sub-array with given sum which
     * ends at current index and we update maximum length sub-array having
     * sum sum if current sub-array has more length.
     *
     * time complexity: O(N)
     * auxiliary space used: O(N)
     * @param array
     * @param sum
     */
    public static void maxLengthSubArray2(int[] array, int sum) {
        Map<Integer, Integer> map = new HashMap<>();

        //insert (0,-1) pair into the set to handle the case when sub-array
        //with sum starts from index 0
        map.put(0, -1);

        int s = 0;
        int ending_index = -1;

        int len = 0;

        for (int i = 0; i < array.length; i++) {
            s += array[i];

            if (!map.containsKey(s)) {
                map.put(s, i);
            }

            if (map.containsKey(s - sum) && len < i - map.get(s - sum)) {
                len = i - map.get(s - sum);
                ending_index = i;
            }
        }
        System.out.println("[" + (ending_index - len + 1) + ", " + ending_index + "]");
    }
}
