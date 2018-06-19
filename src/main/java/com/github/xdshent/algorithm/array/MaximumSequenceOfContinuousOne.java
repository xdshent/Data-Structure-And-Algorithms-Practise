package com.github.xdshent.algorithm.array;

/**
 * Find the maximum sequence of continuous 1's
 * that can be formed by replacing at most k
 * zeros by ones.
 * Given an Boolean array, find the maximum
 * sequence of continuous 1's that can be
 * formed by replacing at most k zeros by ones.
 * <p>
 * For example, consider below binary array
 * {1,1,0,1,1,0,1,1,1,1,0,0}
 * <p>
 * For k=0,
 * The length of longest sequence is 4(from index 6 to 9)
 * <p>
 * For k=1,
 * The length of longest sequence is 7(from index 3 to 9)
 * <p>
 * For k=2,
 * The length of longest sequence is 10(from index 0 to 9)
 * <p>
 * For k=3,
 * The length of longest sequence is 11(from index 0 to 10)
 * <p>
 * We can solve this problem by using sliding window technique. The idea
 * is to maintain a window containing at most k zeros at any point. We
 * add elements to the window from right until it becomes unstable. The
 * window becomes unstable if number of zeros in it becomes more than k.
 * Then we remove elements from its left side till it becomes stable
 * again (by removing left most zero). If the window is stable and
 * current window length is more than maximum window found so far, we
 * set the maximum window size to current window size.
 */
public class MaximumSequenceOfContinuousOne {
    /**
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param array
     * @param k
     */
    public static void longestSeq(int[] array, int k) {
        int left = 0;//left represents current window's starting index
        int count = 0;//stores number of zeros in current window
        int window = 0;//stores maximum number of continuous 1's found
        // so far(including k zeros)

        int leftIndex = 0;//store left index of max window found so far

        //maintain a window [left..right] containing at most k zeros.
        for (int right = 0; right < array.length; right++) {

            //if current element is 0, increase count of zeros in the
            // current window by 1
            if (array[right] == 0) {
                count++;
            }

            //window becomes unstable if number of zeros in it becomes
            // more than
            while (count > k) {
                //if we found zero, decrement number of zeros in the
                // current window by 1
                if (array[left] == 0) {
                    count--;
                }

                //remove elements from the window's left side till
                // window becomes stable again
                left++;
            }

            //when we reach here, the window [left..right] contains at
            // most k zeros and we update max window size and left most
            // index of the window
            if (right - left + 1 > window) {
                window = right - left + 1;
                leftIndex = left;
            }
        }

        System.out.println("The longest sequence has length " + window + " from index " + leftIndex + " to " + (leftIndex + window - 1));
    }
}
