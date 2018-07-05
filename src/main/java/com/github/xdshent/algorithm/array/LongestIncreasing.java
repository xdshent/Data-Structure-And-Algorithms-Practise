package com.github.xdshent.algorithm.array;

/**
 * Longest Increasing Sub Sequence
 * The longest increasing sub sequence problem is to
 * find a sub sequence of a given sequence in which
 * the sub sequence's elements are stored order,
 * lowest to highest, and in which the sub sequence is
 * as long as problem. This sub sequence is not
 * necessarily contiguous, or unique.
 * <p>
 * For example,
 * consider sub sequence {0,8,4,12,2,10,6,14,1,9,5,13,
 * 3,11,7,15}
 * The longest increasing sub sequence is{0,2,6,9,11,15}
 * <p>
 * This sub sequence has length 6; the input sequence
 * has no 7-member
 * increasing sub sequence. The longest increasing sub
 * sequence in this
 * example is not unique: for instance,
 * {0,4,6,9,11,15} or
 * {0,4,6,9,13,15}
 * are other increasing sub sequence of equal length
 * in the same input
 * sequence.
 * <p>
 * We have already discussed a O(N^2) time complexity
 * solution of LIS here which uses Dynamic Programming
 * .In this post, a O(NlogN) time
 * Non-DP solution is discussed.
 * <p>
 * Let S[i] be defined as the smallest integer that
 * ends an increasing sequence of length i. Now
 * iterate through every integer X of the
 * input set and do the following:
 * <p>
 * If X is more than the last element in S, then
 * append X to the end of S. This essentially means we
 * have found a new largest LIS.
 * <p>
 * Otherwise find the smallest element in S, which is
 * more than or equal to X, and replace it with X.
 * Because S is sorted at any time, the element can be
 * found using binary search in log(N) time.
 * <p>
 * Let's illustrate this with the help of a example.
 * Consider below
 * array of integers
 * {2,6,3,4,1,2,9,5,8}
 * Below are the steps followed by the algorithm:
 * Initialize to an empty set S = {}
 * <p>
 * Inserting 2: S = {2} New largest LIS
 * Inserting 6: S = {2,6} New largest LIS
 * Inserting 3: S = {2,3} Replace 6 with 3
 * Inserting 4: S = {2,3,4} New largest LIS
 * Inserting 1: S = {1,3,4} Replace 2 with 1
 * Inserting 2: S = {1,2,4} Replace 3 with 2
 * Inserting 9: S = {1,2,4,9} New largest LIS
 * Inserting 5: S = {1,2,4,5} Replace 9 with 5
 * Inserting 8: S = {1,2,4,5,8} New largest LIS
 * <p>
 * So, the length of the LIS is 5(the size of S).
 * Please note than here
 * S[i] is defined as the smallest integer that ends
 * an increasing
 * sequence of length i. Therefore, S does not
 * represent an actual
 * sequence but the size of S represents the length of
 * the LIS.
 */
public class LongestIncreasing {
    /**
     * time complexity: O(N^2)
     * auxiliary space used: O(N)
     *
     * @param array
     */
    public static int findLISLength1(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int[] c = new int[array.length];
        c[0] = 1;
        int maxLength = 1;

        for (int i = 1; i < array.length; i++) {
            int tmp = 1;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    tmp = Math.max(c[j] + 1, tmp);
                }
            }
            c[i] = tmp;
            maxLength = Math.max(maxLength, c[i]);
        }
        return maxLength;
    }

    /**
     * time complexity: O(Nlog(N))
     * auxiliary space used: O(N)
     * @param array
     * @return
     */
    public static int findLISLength2(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int[] b = new int[array.length + 1];
        int end = 1;
        b[end] = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > b[end]) {
                end++;
                b[end] = array[i];
            } else {
                int index = binarySearch(b, array[i], end);
                b[index] = array[i];
            }
        }
        return end;
    }

    private static int binarySearch(int[] b, int key, int end) {
        int low = 0, high = end;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (key > b[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
