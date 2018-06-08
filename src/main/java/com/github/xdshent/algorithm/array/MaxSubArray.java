package com.github.xdshent.algorithm.array;

/**
 * Find largest sub-array formed by consecutive integers
 * <p>
 * Given an array of integers, find largest sub-array
 * formed by consecutive integers. The sub-array should
 * contain all distinct values.
 * <p>
 * For example:
 * Input: {2,0,2,1,4,3,1,0}
 * Output: The largest sub-array is {0,2,1,4,3}
 * <p>
 * The idea is to consider every sub-array and keep track
 * of largest sub-array found so far which is formed by
 * consecutive integers. In order for an sub-array to
 * contain consecutive integers,
 * <p>
 * The difference between maximum and minimum in it
 * should be exactly equal to length of the sub-array
 * minus one.
 * <p>
 * All elements in the array should be distinct(we can
 * check this by inserting the elements in set or using a
 * visited array.
 */
public class MaxSubArray {
}
