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
    public static int maxSumSubSeq1(int[] arr, int i, int n, int prev) {

        //base case: all elements are processed
        if (i == n) {
            return 0;
        }

        //recurse by excluding current element
        int excl = maxSumSubSeq1(arr, i + 1, n, prev);

        int incl = 0;

        //include current element only if it is not adjacent to previous element considered
        if (prev + 1 != i) {
            incl = maxSumSubSeq1(arr, i + 1, n, i) + arr[i];
        }

        //return maximum sum we get by including or excluding current item
        return Integer.max(incl, excl);
    }

    /**
     * We can also solve this problem in bottom-up fashion using Dynamic
     * Programming(Tabulation). In the bottom-up approach, we solve
     * smaller sub-problems first, then solve larger sub-problems from
     * them. The idea is to create an auxiliary array lookup[] to store
     * solution of sub-problems where for each index i, lookup[i] stores
     * the maximum value that can be attained till index i. It uses
     * value of smaller values i already computed. It has the same
     * asymptotic run-time as Memoization but no recursion overhead.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(N)
     *
     * @param array
     * @return
     */
    public static int maxSumSubSeq2(int[] array) {

        int n = array.length;

        //base case
        if (n == array.length) {
            return array[0];
        }

        //create an auxiliary array to store solution of sub-problems
        int[] lookup = new int[n];

        //lookup[i] stores the maximum sum possible till index i

        //trivial case
        lookup[0] = array[0];
        lookup[1] = Integer.max(array[0], array[1]);

        for (int i = 2; i < n; i++) {
            //lookup[i] stores the maximum sum we get by
            //1: excluding current element & take maximum sum till index i-1
            //2: including current element array[i] and take maximum sum till index-2
            lookup[i] = Integer.max(lookup[i - 1], lookup[i - 2] + array[i]);

            lookup[i] = Integer.max(lookup[i], array[i]);
        }

        //return maximum sum
        return lookup[n - 1];
    }
}
