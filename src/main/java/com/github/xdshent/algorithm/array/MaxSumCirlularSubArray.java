package com.github.xdshent.algorithm.array;

import java.util.Arrays;

/**
 * Maximum Sum Circular Sub Array
 * Given an circular array of integers, find sub-array in it which
 * has the largest sum.
 * <p>
 * For example:
 * Input: {2,1,-5,4,-3,1,-3,4,-1}
 * Output: Sub-array with the largest sum is {4,-1,2,1} with sum 6.
 * <p>
 * Input: {-3,1,-3,4,-1,2,1,-5,4}
 * Output: Sub-array with the largest sum is {4,-1,2,1} with sum 6.
 * <p>
 * The idea is to find the sequence which will have maximum negative
 * value. If we remove that minimum sum sequence from the input
 * sequence, then we will be left with maximum sum circular sequence.
 * Finally, we return maximum of the maximum-sum circular sequence
 * (includes corner elements) and maximum-sum non-circular sequence.
 * <p>
 * For example,consider the array {2,1,-5,4,-3,1,-3,4,-1}. The
 * sequence having maximum negative values is {-5,4,-3,1,-3} i.e. -6.
 * If we remove this minimum sum sequence from the array, we will get
 * the maximum sum circular sequence i.e. {2,1,4,-1} having sum 6.
 * Since maximum sum circular sequence is greater than the maximum
 * sum non-circular sequence i.e. {4} for the given array, it is the
 * answer.
 * <p>
 * We can find maximum-sum non-circular sequence in linear time by
 * using Kadane's algorithm. We can find maximum-sum circular
 * sequence by inverting the sign of all array elements and then
 * applying Kadane's algorithm.
 * <p>
 * For example, if we invert signs of array{1,1,-5,4,-3,1,-3,4,-1} we
 * get {-2,-1,5,-4,3,-1,3,-4,1} which has maximum sum sequence
 * {-5,4,-3,1,-3} having sum -6.
 */
public class MaxSumCirlularSubArray {

    /**
     * @param array
     * @return
     */
    private static int kadane(int[] array) {
        //stores maximum sum sub-array found so far
        int maxSoFar = array[0];

        //stores maximum sum of sub-array ending at current position
        int maxEndingHere = array[0];

        //traverse the given array
        for (int i = 1; i < array.length; i++) {
            maxEndingHere += array[i];

            //if maximum sum is negative, set it to 0(which represents
            // an empty sub-array)
            maxEndingHere = Integer.max(maxEndingHere, array[i]);

            //update result if current sub-array sum is found to be
            // greater
            maxSoFar = Integer.max(maxEndingHere, maxSoFar);
        }

        return maxSoFar;
    }

    /**
     * time complexity: O(N)
     * auxiliary used space: O(1)
     *
     * @param array
     * @return
     */
    public static int kadaneCircular(int[] array) {
        //negate all elements of the array
        for (int i = 0; i < array.length; i++) {
            array[i] = -array[i];
        }

        //run Kadane's algorithm on modified array
        int negMaxSum = kadane(array);

        //restore the array
        for (int i = 0; i < array.length; i++) {
            array[i] = -array[i];
        }

        /*
        return maximum of
        1: sum returned by Kadane's algorithm on original array.
        2: sum returned by Kadane's algorithm on modified array + sum
        of all elements of the array.
         */
        return Integer.max(kadane(array), Arrays.stream(array).sum() + negMaxSum);
    }
}
