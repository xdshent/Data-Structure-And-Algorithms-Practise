package com.github.xdshent.algorithm.array;

/**
 * Print continuous sub-array with maximum sum
 * Given an array of integers, find and print contiguous sub-array with
 * maximum sum in it.
 * <p>
 * For example:
 * Input: {-2,1,-3,4,-1,2,1,-5,4}
 * Output: The continuous sub-array with the largest sum is {4,-1,2,1}
 */
public class KadaneAlgorithm {

    /**
     * We can easily solve this problem in linear time using Kadane's
     * algorithm by maintaining maximum sub sub-array ending at each index
     * of the array. Then this sub-array is:
     * <p>
     * either empty in which case its sum is zero or
     * consists of one more element than the maximum sub-array ending at the
     * previous index.
     * <p>
     * We have already discussed this approach here that only output the sum
     * f contiguous sub-array having the largest sum but do not print the
     * sub-array itself. We can easily modify the algorithm to keep track of
     * the starting and ending indices of the maximum sub-array.
     *
     * time complexity: O(N)
     * auxiliary space used: (1)
     * @param array
     */
    public static void kadane(int[] array) {
        //stores maximum sum sub-array found so far
        int maxSoFar = array[0];

        //stores maximum sum of sub-array ending at current position
        int maxEndingHere = array[0];

        //stores end-points of maximum sum sub-array found so far
        int start = 0, end = 0;

        //stores starting index of a positive sum sequence
        int beg = 0;

        for (int i = 0; i < array.length; i++) {
            //update maximum sum of sub-array ending at index i
            maxEndingHere += array[i];

            //if maximum sum is negative, set it to 0
            if (maxEndingHere < array[i]) {
                maxEndingHere = array[i];
                beg = i;
            }

            //update result if current sub-array sum is found to be greater
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                start = beg;
                end = i;
            }
        }
        System.out.println("The sum of contiguous sub-array with the largest sum is: " + maxSoFar);
        System.out.println("The contiguous sub-array with the largest sum is:  ");
        for (int j = start; j <= end; j++) {
            System.out.print(array[j] + " ");
        }
    }
}
