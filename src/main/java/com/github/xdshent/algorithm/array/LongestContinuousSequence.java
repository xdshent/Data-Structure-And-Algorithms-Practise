package com.github.xdshent.algorithm.array;

/**
 * Length of longest continuous sequence with same sum in given binary arrays
 * <p>
 * Given two Boolean arrays X and Y, find the length of longest continuous sequence that starts and
 * ends at same index in both arrays and have same sum. In other words, find max(j-i+1) for every
 * j>=i where sum of sub-array X[i,j] is equal to sum of sub-array Y[i,j].
 * <p>
 * For example, consider below Boolean arrays X[] and Y[]
 * X: {0,0,1,1,1,1}
 * Y: {0,1,1,0,1,0}
 * <p>
 * The length of longest continuous sequence with same sum is 5 as
 * X[0,4]: {0,0,1,1,1} (sum=3)
 * Y[0,4]: {0,1,1,0,1} (sum=3)
 * <p>
 * Naive solution would be to consider every sub-array[i,j] where (j>i) and check if sum of X[i,j]
 * where(j>i) and check if sum of X[i,j] is equal to sum of Y[i,j] or not. If sum is found to be
 * equal and length of the sub-array is more than maximum found so far, we update the result. The
 * time complexity of above solution is O(N^2) assuming that sum of each sub-array is computed in
 * constant time.
 * <p>
 * We can solve this problem in linear time. The idea is to traverse the array and maintain sum of
 * elements of X[] and Y[] till current index and calculate difference between the two sums.
 * <p>
 * If the difference is seen for the first time, then we store the difference and current
 * index in a map.
 * If difference is seen before and index of previous occurence is i, then we have found
 * sub-array X[i+1,j] and Y[i+1,j] ending at current index j, whose sum of elements is equal.
 * If length of the sub-array is more than maximum found so far, we update the result.
 * <p>
 * How does this works?
 * Claim: If difference is seen before and index of previous occurrence is i,
 * then X[i+1,j] = Y[i+1,j]
 * We can write previous difference di = X[0,i] - Y[0,i]
 * Similarly, current difference dj = X[0,j] - Y[0,j] or
 * dj=(X[0,i]+X[i+1,j])-(Y[0,i]+Y[i+1,j])
 * <p>
 * If difference is seen before i.e. (dj=di), then
 * (X[0,i]+X[i+1,j])-(Y[0,i]+Y[i+1,j])=X[0,i]-Y[0,i]
 * X[i+1,j]-Y[i+1,j]=0 or X[i+1,j] == Y[i+1,j]
 */
public class LongestContinuousSequence {

}
