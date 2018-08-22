package com.github.xdshent.algorithm.array;

/**
 * Find minimum difference between index of two given elements present in the array
 * <p>
 * Given two integers, find minimum difference between their index in a given array in linear time and single traversal of the array
 * For example:
 * Input: {1,3,5,4,8,2,4,3,6,5}
 * x=3, y=2
 * Output: Minimum difference between index is 2
 */
public class MinDifferenceBetweenIndex {
    /**
     * The idea is to traverse the array and keep track of last occurrence of x and y.
     * 1: if element x is encountered , we find the absolute difference between current index of x and index
     * of last occurrence of y and update the result if required.
     * <p>
     * 2: if element y is encountered, we find the absolute difference between current index of y and index of last
     * occurrence of x and update the result if required.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param array
     * @param x
     * @param y
     * @return
     */
    public static int findMinDifference(int[] array, int x, int y) {
        int n = array.length;
        int x_index = n, y_index = n;
        int min_diff = Integer.MAX_VALUE;

        //traverse the given array
        for (int i = 0; i < n; i++) {
            if (array[i] == x) {
                //set x_index to current index
                x_index = i;

                //if y is seen before, update the result if required
                if (y_index != n) {
                    min_diff = Integer.min(min_diff, Math.abs(x_index - y_index));
                }
            }

            //if current element is y
            if (array[i] == y) {
                //set y_index to current index
                y_index = i;

                //if x is seen before, update the result if required
                if (x_index != n) {
                    min_diff = Integer.min(min_diff, Math.abs(x_index - y_index));
                }
            }
        }
        return min_diff;
    }
}
