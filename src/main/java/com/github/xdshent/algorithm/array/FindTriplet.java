package com.github.xdshent.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Find Triplet with given sum in an array
 * Given an unsorted array of integers, find a triplet with given sum in it.
 * <p>
 * The problem is a standard variation of 3SUM problem where instead of looking
 * for numbers whose sum is 0, we look for numbers whose sum is any constant C.
 * <p>
 * For example,
 * Input: {2,7,4,0,9,5,1,3}
 * sum=6
 * <p>
 * Output:
 * Triplet exists.
 * Below are triplets with given sum 6
 * (0,1,5),(0,2,4),(1,2,3)
 */
public class FindTriplet {
    /**
     * Naive Recursive Approach
     * The idea is similar to 0-1 Knapsack problem and uses recursion to solve this problem.
     * For each item, we either consider current item or exclude it and recurse for remaining elements.
     * We return true if we get desired sum by including or excluding current item.
     *
     * @param array
     * @param n
     * @param sum
     * @param count
     * @return
     */
    public static boolean tripletExists1(int[] array, int n, int sum, int count) {

        //if triplet has desired sum, return true
        if (count == 3 && sum == 0) {
            return true;
        }

        //return false if sum is not possible with current configure
        if (count == 3 || n == 0 || sum < 0) {
            return false;
        }

        //recurse with
        //1: including current element
        //2: excluding current element
        return tripletExists1(array, n - 1, sum - array[n - 1], count + 1)
                || tripletExists1(array, n - 1, sum, count);
    }

    /**
     * Using hashing
     * The idea is to insert each element of array in a map. Then we consider all pairs
     * present in the array and check if remaining sum exists in the map or not. If remaining
     * sum is seen before and triplet don't overlap with each other i.e.(i,j,i) or (i,j,j), we
     * print the triplet and return.
     * <p>
     * time complexity: O(N^2)
     * auxiliary space used: O(N)
     *
     * @param array
     * @param sum
     * @return
     */
    public static boolean tripletExists12(int[] array, int sum) {
        //create an empty map
        Map<Integer, Integer> map = new HashMap<>();

        //insert (element, index) pair in map for each element in the array
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }

        //consider each element except last element
        for (int i = 0; i < array.length - 1; i++) {

            //start from i'th element till last element
            for (int j = i + 1; j < array.length; j++) {
                //remaining sum
                int val = sum - (array[i] + array[j]);

                //if remaining sum is found, we have found a triplet
                if (map.containsKey(val)) {

                    //if triplet don't overlap, return true
                    if (map.get(val) != i && map.get(val) != j) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Print all distinct triplets
     * The idea is to sort the given array in ascending order and for each element array[i]
     * in the array, we check if triplet is formed by array[i] and a pair from sub-array array[i+1,n)
     * <p>
     * time complexity: O(N^2)
     * auxiliary space used: O(1)
     *
     * @param array
     * @param sum
     */
    public static void tripletPrint(int[] array, int sum) {
        //sort the array in ascending order
        Arrays.sort(array);

        //check if triplet is formed by array[i] and a pair from sub-array array[i+1,n)
        for (int i = 0; i <= array.length - 3; i++) {
            //remaining sum
            int k = sum - array[i];

            //maintain two indicates pointing to end-points of the sub-array arr[i+1,n)
            int low = i + 1, high = array.length - 1;

            //loop till low is less than high
            while (low < high) {
                //increment low index if total is less than the remaining
                if (array[low] + array[high] < k) {
                    low++;
                } else if (array[low] + array[high] > k) {
                    //decrement high index is total is more than the remaining sum
                    high--;
                } else {
                    //print the triplet
                    System.out.println("(" + array[i] + "," + array[low] + "," + array[high]);
                    low++;
                    high--;
                }
            }
        }
    }
}
