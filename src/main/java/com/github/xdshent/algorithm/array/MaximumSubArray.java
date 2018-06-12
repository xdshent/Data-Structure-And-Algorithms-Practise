package com.github.xdshent.algorithm.array;

import java.util.Arrays;

/**
 * Maximum Sub-Array Problem(Kadane's algorithm)
 * Given an array of integers, find contiguous sub-array within it which has
 * the largest sum.
 * <p>
 * For example:
 * Input: {-2,1,-3,4,-1,2,1,-5,4}
 * Output: Sub-array with the largest sum is{4,-1,2,1} with sum 6.
 */
public class MaximumSubArray {

    /**
     * We can easily solve this problem in linear time using kadane's
     * algorithm. The idea is to maintain maximum(positive sum) sub-array
     * ending at each index of the given array. This sub-array is either
     * empty(in which case its sum is zero) or consists of one more element
     * than the maximum sub-array ending at the previous index.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param array
     * @return
     */
    public static int kadane1(int[] array) {
        //stores maximum sum of sub-array ending at current position
        int maxSoFar = 0;

        //stores maximum sum of sub-array ending at current position
        int maxEndingHere = 0;

        for (int i : array) {
            //update maximum sum of sub-array ending at index i(by adding
            // current element to maximum sum ending at previous index i-1)
            maxEndingHere = maxEndingHere + i;

            //if maximum sum is negative, set it to 0(which represents an
            //empty sub-array)
            maxEndingHere = Integer.max(maxEndingHere, 0);

            //update result if current sub-array sum is found to be greater
            maxSoFar = Integer.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    /**
     * Above code doesn't handle the case when all elements of the array are
     * negative. If the array contains all negative values, the answer is
     * the maximum element. We can easily place this check before continuing
     * to the algorithm. The implementation can be seen below.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: (1)
     *
     * @param array
     * @return
     */
    public static int kadane2(int[] array) {

        //stores maximum sum sub-array found so far
        int maxSoFar = array[0];

        //stores maximum sum of sub-array ending at current position
        int maxEndingHere = array[0];

        //traverse the given array
        for (int i = 1; i < array.length; i++) {
            //update maximum sum of sub-array ending at index i(by
            //adding current element to maximum sum ending at previous index
            // i-1)
            maxEndingHere = maxEndingHere + array[i];

            //maximum sum is should be more than the current element
            maxEndingHere = Integer.max(maxEndingHere, array[i]);

            //update result if current sub-array sum is found to be greater
            maxSoFar = Integer.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    /**
     * But this approach requires two traversals of the input array. We can
     * easily modify the main algorithm to handle negative integers as well.
     * The implementation is shown below.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param array
     * @return
     */
    public static int kadane3(int[] array) {
        //find maximum element present in given array
        int max = Arrays.stream(array).max().getAsInt();

        //if array contains all negative values, return maximum element
        if (max < 0) {
            return max;
        }

        //stores maximum sum sub-array found so far
        int maxSoFar = 0;

        //stores maximum sum of sub-array ending at current position
        int maxEndingHere = 0;

        for (int i : array) {
            //update maximum sum of sub-array ending at index i(by adding
            // current element to maximum sum ending at previous index i-1)
            maxEndingHere = maxEndingHere + i;

            //if maximum sum is negative, set it to 0(which represents an
            // empty sub-array)
            maxEndingHere = Integer.max(maxEndingHere, 0);

            //update result if current sub-array sum is found to be greater
            maxSoFar = Integer.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
}
