package com.github.xdshent.algorithm.array;

/**
 * Find index of 0 to be replaced to get maximum length sequence of
 * continuous ones.
 * <p>
 * For example:
 * Consider the array{0,0,1,0,1,1,1,0,1,1}
 * The index to be replaced is 7 to get continuous sequence of length
 * 6 containing all 1's.
 * <p>
 * We can efficiently solve this problem in linear time and constant
 * space. The idea is to traverse the given array and maintain index
 * of previous zero encountered. Then for each subsequent zeros, we
 * can easily find out number of 1's between current zero and last
 * zero. For each element we check if maximum sequence of continuous
 * 1's ending at that element(including last zero which is now
 * replaced by 1) exceeds maximum sequence found so far. If yes, we
 * update the maximum sequence to current sequence length and index
 * of optimal zero to index of last zero encountered.
 */
public class FindIndexOfZero {
    /**
     * Find index of 0 to replaced with 1 to get maximum sequence
     * of continuous 1's
     *
     * time complexity: O(N)
     * auxiliary space used: O(1)
     * @param array
     */
    public static int findIndexOfZero(int[] array) {
        int maxCount = 0;//stores maximum number of 1's
        int maxIndex = -1;//stores index of 0 to be replaced

        int prevZeroIndex = -1;//stores index of previous zero
        int count = 0;//stores current count of ones

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                count++;
            } else {
                count = i - prevZeroIndex;
                prevZeroIndex = i;
            }

            if (count > maxCount) {
                maxCount = count;
                maxIndex = prevZeroIndex;
            }
        }
        return maxIndex;
    }
}
