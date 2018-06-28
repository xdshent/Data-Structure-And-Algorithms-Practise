package com.github.xdshent.algorithm.array;

/**
 * Trapping Rain Water within given set of bars
 * In trapping rain water problem, we need to find the
 * maximum amount of water that can be trapped within
 * given set of bars where width of each bar is 1 unit.
 */
public class TrappingRainWater {
    /**
     * The idea is to calculate maximum height bar on
     * the left and right of every bar. Then the amount
     * of water that can be stored on top of each bar
     * is equal to minimum among maximum bar to the
     * left and right minus height of current bar.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(N)
     *
     * @param bars
     * @return
     */
    public static int trap1(int[] bars) {

        int n = bars.length;
        int water = 0;

        //left[i] stores the maximum height of a bar to the left of
        // current bar
        int[] left = new int[n - 1];
        left[0] = Integer.MIN_VALUE;

        //process bars from left to right
        for (int i = 1; i < n - 1; i++) {
            left[i] = Integer.max(left[i - 1], bars[i - 1]);
        }

        //right stores the maximum height of a bar to the right of
        // current bar
        int right = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 1; i--) {
            right = Integer.max(right, bars[i + 1]);

            //check if it is possible to store water in current bar
            if (Integer.min(left[i], right) > bars[i]) {
                water += Integer.min(left[i], right) - bars[i];
            }
        }
        return water;
    }

    /**
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param bars
     * @return
     */
    public static int trap2(int[] bars) {

        //maintain two pointers left and right pointing to leftmost and
        //rightmost index of the input array
        int left = 0, right = bars.length - 1, water = 0;

        int maxLeft = bars[left];
        int maxRight = bars[right];

        while (left < right) {
            if (bars[left] <= bars[right]) {
                left++;
                maxLeft = Integer.max(maxLeft, bars[left]);
                water += (maxLeft - bars[left]);
            } else {
                right--;
                maxRight = Integer.max(maxRight, bars[right]);
                water += (maxRight - bars[right]);
            }
        }
        return water;
    }
}
