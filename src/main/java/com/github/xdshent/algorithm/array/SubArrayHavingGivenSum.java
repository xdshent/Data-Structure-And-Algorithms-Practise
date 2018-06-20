package com.github.xdshent.algorithm.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Find sub-array having given sum in given array of integers
 * Given an array of integers, find a sub-array having given sum in it.
 * <p>
 * For example:
 * Input: {2,6,0,9,7,3,1,4,1,10},sum=15
 * Output: Sub array {6,0,9} exists with sum 15
 * <p>
 * Input: {0,5,-7,1,-4,7,6,1,4,1,10}, sum 15
 * Output:
 * <p>
 * Sub array {1,-4,7,6,1,4} exists with sum 15
 * or
 * Sub array {4,1,10} exists with sum 15
 */
public class SubArrayHavingGivenSum {
    /**
     * Approach 1:(Using Sliding Window)
     * <p>
     * We can solve this problem by using a sliding window. The idea is
     * to maintain a window that starts from the current element and sum
     * of its elements is more than or equal to the given sum. If
     * current window's sum becomes less than the given sum, then the
     * windows is unstable and we keep on adding elements to the current
     * window from its right till the window becomes stable again. We
     * print the window if it's sum is equal to the given sum at any
     * point of time. This approach will only work on positive sum.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param array
     * @param sum
     */
    public static void findSubArray1(int[] array, int sum) {
        //maintains sum of current window
        int windowSum = 0;

        //maintain a window [low..high-1]
        int low = 0, high = 0;

        //consider every sub-array starting from low index
        for (low = 0; low < array.length; low++) {

            //if current window's sum is less than the given sum, then
            // add elements to current window from right
            while (windowSum < sum && high < array.length) {
                windowSum += array[high];
                high++;
            }

            if (windowSum == sum) {
                System.out.printf("Sub array found [%d-%d]\n", low, high - 1);
            }

            //At this point the current window's sum is more than the
            // given sum remove current element (leftmost element) from
            // the window
            windowSum -= array[low];
        }
    }

    /**
     * Approach 2:
     * Above solution will fail for negative numbers. We can use hashing
     * to check if sub-array with given sum exists in the array or not.
     * The idea is to traverse the given array and maintain sum of
     * elements seen so far. If the difference of current sum and given
     * sum is seen before(i.e. the difference exists in the set), we
     * return true as there exists at least one sub-array with given sum
     * which ends at current index else we insert the sum into the set.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(N)
     *
     * @param array
     * @param sum
     */
    public static boolean findSubArray2(int[] array, int sum) {
        //create an empty set
        Set<Integer> set = new HashSet<Integer>();

        //insert number 0 into the set to handle the case when sub-array
        // with given sum starts from index 0
        set.add(0);

        //maintains sum of elements so far
        int sumSoFar = 0;

        //traverse the given array
        for (int i : array) {
            //update sum of elements so far
            sumSoFar += i;

            //if (sumSoFar - sum) is seen before, we have found the
            // sub-array with sum
            if (set.contains(sumSoFar - sum)) {
                return true;
            }

            //else insert sum of elements so far into the set
            set.add(sumSoFar);
        }
        return false;
    }

    /**
     * We can also print the sub-array using hashing. The idea is to
     * use map instead of set that stores the ending index of sub-array
     * along with its sum.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param array
     * @param sum
     */
    public static void findSubArray3(int[] array, int sum) {
        //create an empty map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        //inset (0,-1) pair into the set to handle the case when
        // sub-array with given sum starts from index 0
        map.put(0, -1);

        //maintains sum of elements so far
        int sumSoFar = 0;

        //traverse the given array
        for (int i = 0; i < array.length; i++) {
            //update sumSoFar
            sumSoFar += array[i];

            //if (sumSoFar - sum) is seen before, we have found the
            // sub-array with sum
            if (map.containsKey(sumSoFar - sum)) {
                System.out.println("Sub array found [" + (map.get(sumSoFar - sum) + 1) + "-" + i + "]");
                return;
            }

            //insert current sum with index into the map
            map.put(sumSoFar, i);
        }
    }
}
