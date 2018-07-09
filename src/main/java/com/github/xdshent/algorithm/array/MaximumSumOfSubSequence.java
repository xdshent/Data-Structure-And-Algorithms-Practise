package com.github.xdshent.algorithm.array;

/**
 * Find maximum sum of sub sequence with no adjacent elements
 * Given an array of integers, find the maximum sum of sub sequence of
 * given array where sub sequence contains no adjacent elements.
 * <p>
 * For example:
 * Input: {1,2,9,4,5,0,4,11,6}
 * Output: Maximum sum is 26
 * <p>
 * The maximum sum is formed by sub sequence {1,9,5,11}
 * <p>
 * The problem is similar 0/1 Knapsack problem where for every item, we
 * have two choices - to include that element in the solution or to
 * exclude that element from solution. We can solve this problem by
 * following the same logic. The only difference is that we include
 * current element only if it is not adjacent to previous element
 * considered.
 */
public class MaximumSumOfSubSequence {

    /**
     * time complexity: O(N)
     * auxiliary space used: O(N)
     *
     * @param arr
     * @param i
     * @param n
     * @param prev
     * @return
     */
    public static int maxSumSubSeq(int[] arr, int i, int n, int prev) {

        //base case: all elements are processed
        if (i == n) {
            return 0;
        }

        //recurse by excluding current element
        int excl = maxSumSubSeq(arr, i + 1, n, prev);

        int incl = 0;

        //include current element only if it is not adjacent to previous element considered
        if (prev + 1 != i) {
            incl = maxSumSubSeq(arr, i + 1, n, i) + arr[i];
        }

        //return maximum sum we get by including or excluding current item
        return Integer.max(incl, excl);
    }
}
