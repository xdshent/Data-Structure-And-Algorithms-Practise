package com.github.xdshent.algorithm.array;

/**
 * Find largest sub-array formed by consecutive integers
 * <p>
 * Given an array of integers, find largest sub-array
 * formed by consecutive integers. The sub-array should
 * contain all distinct values.
 * <p>
 * For example:
 * Input: {2,0,2,1,4,3,1,0}
 * Output: The largest sub-array is {0,2,1,4,3}
 * <p>
 * The idea is to consider every sub-array and keep track
 * of largest sub-array found so far which is formed by
 * consecutive integers. In order for an sub-array to
 * contain consecutive integers,
 * <p>
 * The difference between maximum and minimum in it
 * should be exactly equal to length of the sub-array
 * minus one.
 * <p>
 * All elements in the array should be distinct(we can
 * check this by inserting the elements in set or using a
 * visited array.
 */
public class MaxSubArray {

    /**
     * time complexity: O(N^3)
     * auxiliary space used: O(N)
     *
     * @param array
     */
    public static void findMaxSubArray(int[] array) {
        int len = 1;
        int start = 0, end = 0;

        //consider each sub-array formed by array[i..j]
        for (int i = 0; i < array.length - 1; i++) {
            int minValue = array[i], maxValue = array[i];

            for (int j = i + 1; j < array.length; j++) {
                minValue = Math.min(minValue, array[j]);
                maxValue = Math.max(maxValue, array[j]);

                if (isConsecutive(array, i, j, minValue, maxValue)) {
                    if (len < maxValue - minValue + 1) {
                        len = maxValue - minValue + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        System.out.println("The largest sub-array is[" + start + ", " + end + "]");
    }

    private static boolean isConsecutive(int[] array, int i, int j, int minValue, int maxValue) {

        //in order for an array to contain consecutive integers, the
        // difference between maximum and minimum element in it should be
        // exactly j-i
        if (maxValue - minValue != j - i) {
            return false;
        }
        boolean[] visited = new boolean[j - i + 1];

        //traverse the sub-array and checks if each element appears only once
        for (int k = i; k <= j; k++) {
            //if element is seen before, return false
            if (visited[array[k] - minValue]) {
                return false;
            }

            //mark element as seen
            visited[array[k] - minValue] = true;
        }

        //we reach here when all elements in array are distinct
        return true;
    }
}
