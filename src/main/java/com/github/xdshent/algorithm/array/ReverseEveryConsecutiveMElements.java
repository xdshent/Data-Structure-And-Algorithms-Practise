package com.github.xdshent.algorithm.array;

/**
 * Reverse every consecutive m elements of the given sub array
 * Given an array, reverse every group of consecutive m elements in given sub array of it.
 * <p>
 * For example, consider the array
 * A[] = {1,2,3,4,5,6,7,8,9,10}
 * m=3
 * <p>
 * Then for sub array[i,j] where i and j is
 * i=1,j=7 or 8
 * Output: {1,4,3,2,7,6,5,8,9,10}
 * <p>
 * i=1,j=9
 * Output: {1,2,3,6,5,4,7,8,9,10}
 * <p>
 * i=3,j=4
 * Output: {1,2,3,4,5,6,7,8,9,10}
 */
public class ReverseEveryConsecutiveMElements {
    /**
     * Since we are passing the end points of the sub-array we want to reverse to the second reverse function
     * and the sub-array size would be exactly m, it's complexity would be O(M). Inside the main reverse function,
     * there will be exactly n/m calls made to second reverse function, so the overall time complexity will be m*(n/m)=O(N).
     * Auxiliary space used by the program is O(1).
     *
     * @param array
     * @param beg
     * @param end
     * @param m
     */
    public static void reverse(int[] array, int beg, int end, int m) {
        //return if sub-array length is less than m
        if (m > end - beg + 1) {
            return;
        }

        //reverse every consecutive m elements
        for (int i = beg; i <= end; i += m) {
            if (i + m - 1 <= end) {
                reverse(array, i, i + m - 1);
            }
        }
    }

    /**
     * @param array
     * @param i
     * @param j
     * @return
     */
    private static int[] reverse(int[] array, int i, int j) {
        if (i >= j) {
            return array;
        }

        //else swap two elements
        swap(array, i, j);

        //recurse for next pair
        return reverse(array, i + 1, j - 1);
    }

    /**
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
