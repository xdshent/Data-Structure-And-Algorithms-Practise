package com.github.xdshent.algorithm.array;

/**
 * Find smallest window in array sorting which will make entire array
 * sorted
 * Given an array of integers, find the smallest window in array sorting
 * which will make the entire array sorted in increasing order.
 * <p>
 * For example:
 * Input: {1,2,3,7,5,6,4,8}
 * Output: Sort the array from index 3 to 6
 * <p>
 * Input: {1,3,2,7,5,6,4,8}
 * Output: Sort the array from index 1 to 6
 * <p>
 * We can easily solve this problem in linear time. Below is the
 * complete algorithm.
 * 1: Traverse array from left to right keeping track of maximum so far
 * and note the last encountered index j which is less than the maximum
 * so far.
 * 2: Traverse array from right to left keeping track of minimum so far
 * and note the last encountered index i which is more than the minimum
 * so far.
 * 3: Finally we sort the array from index i to j
 * <p>
 * For example, consider below array
 * {1,2,3,7,5,6,8}
 * If we traverse the array from left to right, the last encountered
 * index which is less than the maximum so far is 6. Similarly, if we
 * traverse the array from right to left, the last encountered index
 * which is more than the minimum so far is 3. So, we need to sort the
 * array from index 3 to 6.
 */
public class SmallestWindow {
    /**
     *
     */
    public static void findSubArray(int[] array) {
        int leftIndex = -1, rightIndex = -1;

        //traverse from left to right and keep track of maximum so far
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (maxSoFar < array[i]) {
                maxSoFar = array[i];
            }

            //find the last position that is less than the maximum so far
            if (array[i] < maxSoFar) {
                rightIndex = i;
            }
        }

        //traverse from right to left and keep track of minimum so far
        int minSoFar = Integer.MAX_VALUE;
        for (int i = array.length - 1; i >= 0; i--) {
            if (minSoFar > array[i]) {
                minSoFar = array[i];
            }

            //find the last position that is more than the minimum so far
            if (array[i] > minSoFar) {
                leftIndex = i;
            }
        }

        System.out.println("Sort array from index " + leftIndex + " to " + rightIndex);
    }
}
