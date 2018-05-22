package com.github.xdshent.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, check if array contains a sub-array having 0 sum.
 * <p>
 * For example,
 * <p>
 * Input: {3,4,-7,3,1,-4,-2,-2}
 * Output: Sub-array with 0 sum exists
 * <p>
 * The sub-arrays with 0 sum are:
 * {3,4,-7}
 * {4,-7,3}
 * {-7,3,1,3}
 * {3,1,-4}
 * {3,1,3,1,-4,-2,-2}
 * {3,4,-7,3,1,3,1,-4,-2,-2}
 * <p>
 * We can easily solve this problem in liner time by using hashing.
 * The idea is to use set to check if sub-array with zero sum is present in the given array or not. We traverse the given array, and maintain sum of elements seen so far. If sum is seen before(i.e. sum exists in set), we return true as there exists at least one sub-array with zero sum which ends at current index else we insert the sum into the set.
 */
public class ZeroSumSubarray {

    /**
     * time complexity: O(N)
     * auxiliary space used: O(N)
     *
     * @param array
     */
    public static boolean zeroSumSubarray(int[] array) {
        //create an empty set to store sum of each sub-array array[0..i] 0<=i<array.length
        Set<Integer> set = new HashSet<Integer>();

        //insert 0 into set to handle the case when sub-array with 0 sum starts from index 0
        set.add(0);

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            if (set.contains(sum)) {
                return true;
            }//1 3 -3 -1 3

            set.add(sum);
        }
        return false;
    }
}
