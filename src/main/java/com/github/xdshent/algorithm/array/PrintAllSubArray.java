package com.github.xdshent.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers, print all sub-arrays with 0 sum.
 * <p>
 * For example,
 * <p>
 * Input: {4,2,-3,-1,0,4}
 * Sub-arrays with 0 sum are
 * {-3,-1,0,4}
 * {0}
 */
public class PrintAllSubArray {

    /**
     * Naive solution
     * Naive solution would be to consider all sub-arrays and find its sum. If sub-array sum is equal to 0, we print it.
     * The time complexity of naive solution is O(N^3) as there N^2 sub-arrays and it takes O(N) time to find sum of its elements.
     * The method can be optimized to run in O(N^2) time by calculating sub-array sum in constant time.
     *
     * @param array
     */
    public static void printAllSubarrays1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];

                if (sum == 0) {
                    System.out.println("SubArray [" + i + ".." + j + "]");
                }
            }
        }
    }

    /**
     * Using multimap to print all sub-arrays
     * <p>
     * We can use MultiMap to print all sub-arrays with 0 sum present in the given array.
     * The idea is to create an empty multimap to store ending index of all sub-arrays having given sum.
     * We traverse the given array, and maintain sum of elements seen so far. If sum is seen before,
     * there exists at-least one sub-array with 0 sum which ends at current index and we print all such sub-arrays.
     *
     * @param array
     */
    public static void printAllSubArrays2(int[] array) {
        //create an empty Multi-map to store ending index of all sub-arrays having same sum
        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        //insert (0,-1) pair into the map to handle the case when sub-array with 0 sum starts from index 0.
        insert(hashMap, 0, -1);

        int sum = 0;

        //traverse the given array
        for (int i = 0; i < array.length; i++) {
            //sum of elements so far
            sum += array[i];

            //if sum is seen before, there exists at-least one sub-array with 0 sum.
            if (hashMap.containsKey(sum)) {
                List<Integer> list = hashMap.get(sum);

                //find all sub-arrays with same sum
                for (Integer value : list) {
                    System.out.println("SubArray [" + (value + 1) + ".." + i + "]");
                }
            }

            insert(hashMap, sum, i);
        }
    }

    /**
     * Utility function to insert <key, value> into the Multimap
     *
     * @param hashMap
     * @param key
     * @param value
     * @param <K>
     * @param <V>
     */
    private static <K, V> void insert(Map<K, List<V>> hashMap, K key, V value) {
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, new ArrayList<>());
        }

        hashMap.get(key).add(value);
    }
}
