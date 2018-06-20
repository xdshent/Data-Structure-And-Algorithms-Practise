package com.github.xdshent.algorithm.array;

import java.util.LinkedList;

/**
 * Sliding window maximum
 * A long array array[] is given to you.
 * There is a sliding window of size w which is moving
 * from the very left of the array to the very right.
 * You can only see the w numbers in the window. Each time
 * the sliding window moves rightwards by one position. Following is an example:
 * <p>
 * The array is [1,3,-1,-3,5,3,6,7] and w is 3.
 * Window position             max
 * ---------------             ---
 * [1,3,-1],-3,5,3,6,7          3
 * 1,[3,-1,-3],5,3,6,7          3
 * 1,3,[-1,-3,5],3,6,7          5
 * 1,3,-1,[-3,5,3],6,7          5
 * 1,3,-1,-3,[5,3,6],7          6
 * 1,3,-1,-3,5,[3,6,7]          7
 * <p>
 * Input: A long array array[], and a window width w
 * Output: An array max[], max[i] is the maximum value of from array[i] to array[i+w-1]
 * Requirement: Find a good optimal way to get max[i]
 */
public class SlidingWindowMaximum {
    /**
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param array
     * @param w
     * @return
     */
    public static int[] maxSlidingWindow(int[] array, int w) {
        //stores sliding window max value
        int[] max = new int[array.length - w + 1];

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            while (!queue.isEmpty() && array[i] >= array[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        for (int i = w; i < array.length; i++) {
            max[i - w] = array[queue.peekFirst()];

            while (!queue.isEmpty() && array[i] >= array[queue.peekLast()]) {
                queue.pollLast();
            }

            while (!queue.isEmpty() && i - queue.peekFirst() >= w) {
                queue.pollFirst();
            }
            queue.offerLast(i);
        }

        max[array.length - w] = array[queue.pollFirst()];
        return max;
    }
}
