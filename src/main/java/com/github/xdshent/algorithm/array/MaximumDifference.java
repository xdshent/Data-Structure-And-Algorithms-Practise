package com.github.xdshent.algorithm.array;

/**
 * Find maximum difference between two elements in the
 * array by satisfying given constraints.
 * <p>
 * Given an array of integers, find maximum difference
 * between two elements in the array such that smaller
 * element appears before the larger element.
 * <p>
 * For example:
 * Input: {2,7,9,5,1,3,5}
 * Output: The maximum difference is 7
 * The pair is {2,9}
 */
public class MaximumDifference {

    /**
     * Naive solution is to consider every pair present
     * in the array and keep track of maximum difference
     * found so far.
     * <p>
     * time complexity: O(N^2)
     * auxiliary space used: O(1)
     *
     * @param array
     * @return
     */
    public static int diff1(int[] array) {
        int diff = Integer.MIN_VALUE;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                diff = Integer.max(diff, Math.abs(array[j] - array[i]));
            }
        }
        return diff;
    }

    /**
     * We can solve this problem in linear time. The idea is to traverse the
     * array from the right and keep track of maximum difference found so
     * far. If the current element is less than the maximum element found so
     * far and their difference is more than maximum difference found so
     * far, then we update the maximum difference with current difference.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param array
     * @return
     */
    public static int diff2(int[] array) {
        int diff = Integer.MIN_VALUE;
        int maxValue = array[array.length - 1];

        for (int i = array.length - 2; i >= 0; i--) {

            //update max if current element is greater than the max element
            if (array[i] > maxValue) {
                maxValue = array[i];
            } else {
                //if the current element is less than the maximum element,
                //then update the difference if required
                diff = Integer.max(diff, maxValue - array[i]);
            }
        }
        return diff;
    }
}
