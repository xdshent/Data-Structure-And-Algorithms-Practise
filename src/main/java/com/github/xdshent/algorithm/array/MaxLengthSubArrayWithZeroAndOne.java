package com.github.xdshent.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Find maximum length sub-array having equal number of 0's and 1's
 * <p>
 * Given an binary array containing 0 and 1, find maximum length
 * sub-array having equal number of 0's and 1's.
 * <p>
 * For example,
 * Input: {0,0,1,0,1,0,0}
 * <p>
 * Output: Largest sub-array is{0,1,0,1} or {1,0,1,0}
 * <p>
 * Naive solution would be to consider all sub-arrays and for each
 * sub-array, we count total number of 0's and 1's present. If
 * sub-array contains equal number of 0's and 1's, we update maximum
 * length sub-array if required. The time complexity of naive
 * solution is O(N^3) as there are N^2 sub-arrays and it takes O(N)
 * time to find count 0's and 1's. The method can be optimized to
 * run in O(N^2) time by calculating count of 0's and 1's in
 * constant time.
 * <p>
 * We can use map to solve this problem in linear time. The idea is
 * to replace 0 with -1 and find out the largest sub-array with 0
 * sum. To find largest sub-array with 0 sum, we create an empty map
 * which stores the ending index of first sub-array having giving
 * sum. We traverse the given array, and maintain sum of elements
 * seen so far.
 * <p>
 * If sum is seen for first time, insert the sum with its index into
 * the map.
 * <p>
 * If sum is seen before, there exists a sub-array with 0 sum which
 * ends at current index and we update maximum length sub-array if
 * current sub-array has more length.
 */
public class MaxLengthSubArrayWithZeroAndOne {
    public static void maxLenSubArray(int[] array) {

        //create an empty hash map to store ending index of
        //first sub-array having some sum
        Map<Integer, Integer> map = new HashMap<>();

        //insert (0,-1) pair into the set to handle the case when
        //sub-array with sum 0 starts form index 0
        map.put(0, -1);

        int len = 0;
        int ending_index = -1;

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += (array[i] == 0) ? -1 : 1;
            if (map.containsKey(sum)) {

                //update length and ending index of maximum length
                //sub-array having sum 0
                if (len < i - map.get(sum)) {
                    len = i - map.get(sum);
                    ending_index = i;
                } else {
                    //if sum is seen for first time, insert sum with
                    // its index into the map
                    map.put(sum, i);
                }
            }
        }

        if (ending_index != -1) {
            System.out.println("[" + (ending_index - len + 1) + "," + ending_index + "]");
        } else {
            System.out.println("No sub-array exists");
        }
    }
}
