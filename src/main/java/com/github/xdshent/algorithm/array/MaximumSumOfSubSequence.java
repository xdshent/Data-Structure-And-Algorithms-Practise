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
}
