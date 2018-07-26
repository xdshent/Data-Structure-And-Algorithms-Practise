package com.github.xdshent.algorithm.array;

/**
 * Length of longest continuous sequence with same sum in given binary arrays
 * <p>
 * Given two Boolean arrays X and Y, find the length of longest continuous sequence that starts and
 * ends at same index in both arrays and have same sum. In other words, find max(j-i+1) for every
 * j>=i where sum of sub-array X[i,j] is equal to sum of sub-array Y[i,j].
 *
 * For example, consider below Boolean arrays X[] and Y[]
 * X: {0,0,1,1,1,1}
 * Y: {0,1,1,0,1,0}
 *
 * The length of longest continuous sequence with same sum is 5 as
 * X[0,4]: {0,0,1,1,1} (sum=3)
 * Y[0,4]: {0,1,1,0,1} (sum=3)
 *
 * Naive solution would be to consider every sub-array[i,j] where (j>i) and check if sum of X[i,j]
 * where(j>i) and check if sum of X[i,j] is equal to sum of Y[i,j] or not. If sum is found to be
 * equal and length of the sub-array is more than maximum found so far, we update the result. The
 * time complexity of above solution is O(N^2) assuming that sum of each sub-array is computed in
 * constant time.
 *
 * We can solve this problem in linear time. The idea is to traverse the array and maintain sum of
 * elements of X[] and Y[] till current index and calculate difference between the two sums.
 *
 *      If the difference is seen for the first time, then we store the difference and current
 *      index in a map.
 *      If difference is seen before and index of previous occurence is i, then we have found
 *      sub-array X[i+1,j] and Y[i+1,j] ending at current index j, whose sum of elements is equal.
 *      If length of the sub-array is more than maximum found so far, we update the result.
 */
public class LongestContinuousSequence {

}
