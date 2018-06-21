package com.github.xdshent.algorithm.array;

/**
 * Find the length of smallest sub-array whose sum of elements is greater
 * than the given number
 * Given an array of integers, find the length of smallest sub-array
 * whose sum of elements is greater than the given positive number.
 * <p>
 * For example:
 * Input: {1,2,3,4,5,6,7,8} k=20
 * Output: {6,7,8}
 * <p>
 * Input: {1,2,3,4,5,6,7,8} k=7
 * Output: {8}
 */
public class SmallestSubArray {
    /**
     * We can solve this problem by using a sliding window. The idea is
     * to maintain a window that ends at the current element and sum of
     * its elements is less than or equal to the given sum. If current
     * window's sum becomes more than the given sum at any point of
     * time, then the window is unstable and continue removing elements
     * from the window left till it becomes stable again. We also update
     * the result if unstable window's length is less than minimum found
     * so far.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param array
     * @param k
     * @return
     */
    public static void smallestSubArray(int[] array, int k) {
        //stores the current window sum
        int windowSum = 0;

        //stores the result
        int len = Integer.MAX_VALUE;

        //stores window's starting index
        int left = 0;

        for (int right = 0; right < array.length; right++) {
            //include current element in the window
            windowSum += array[right];

            //(to handle negative numbers in the array) if window's sum
            // becomes negative, discard the window
            if (windowSum <= 0) {//Kadane's algorithm
                left = right;
                windowSum = 0;
            }

            //window becomes unstable if its sum becomes more than k
            while (windowSum > k && left <= right) {
                //update the result if current window's length is less
                // than minimum found so far
                len = Integer.min(len, right - left + 1);

                //remove elements from the window's left side till window
                //becomes stable again
                windowSum -= array[left];
                left++;
            }

        }

        if (len != Integer.MAX_VALUE) {
            System.out.println("Smallest sub-array length is " + len);
        } else {
            System.out.println("No sub-array exists");
        }
    }
}
