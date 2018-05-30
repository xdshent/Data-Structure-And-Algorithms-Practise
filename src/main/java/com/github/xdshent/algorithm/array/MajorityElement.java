package com.github.xdshent.algorithm.array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Find majority element in an array(Boyer-Moore majority vote algorithm)
 * <p>
 * Given an array of integers containing duplicates, return the majority
 * element in an array if present. A majority element appears more than
 * n/2 times where n is the size of the array.
 */
public class MajorityElement {

    /**
     * Naive solution would be to count frequency of each element present in
     * the first half of the array to check if it is majority element or not.
     * <p>
     * time complexity: O(N^2)
     * auxiliary space used: O(1)
     *
     * @param array
     * @return
     */
    public static int majorityElement1(int[] array) {
        for (int i = 0; i <= array.length / 2; i++) {
            int count = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == array[i]) {
                    count++;
                }
            }
            if (count > array.length / 2) {
                return array[i];
            }
        }
        return -1;
    }

    /**
     * O(N) solution
     * We can use hashing to solve this problem in liner time. The idea is
     * to store each element's frequency in a map and return the element
     * if its frequency becomes more than n/2. If no such element is
     * present, then majority element does not exists in the array and we
     * return -1.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(N)
     *
     * @param array
     * @return
     */
    public static int majorityElement2(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == null) {
                map.put(array[i], 0);
            }
            map.put(array[i], map.get(array[i]) + 1);
        }

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> pair = it.next();
            if (pair.getValue() > array.length / 2) {
                return pair.getKey();
            }
        }
        return -1;
    }

    /**
     * Boyer-Moore majority vote algorithm
     * We can find the majority element using linear time and constant
     * space using Boyer-Moore majority vote algorithm. The algorithm can
     * be expressed in pseudocode as the following steps:
     * <p>
     * Initialize an element x of the input sequence:
     * if i=0, then
     * assign m = x and i = 1
     * else
     * if m=x, then assign i=i+1
     * else
     * assign i=i-1
     * return m
     * <p>
     * The algorithm processes the each element of the sequence, one at a
     * time. When processing an element x,
     * <p>
     * 1. If the counter is 0, we set the current candidate to x and we set
     * the counter to 1.
     * 2. If the counter is not 0, we increment or decrement the counter
     * according to whether x is the current candidate.
     * <p>
     * At the end of this process, if the sequence has a majority, it will
     * be the element stored by the algorithm. If there is no majority
     * element, the algorithm will not detect that fact, and will still
     * output one of the elements. We can modify the algorithm to verify
     * that the element found is really is a majority element or not.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @return
     */
    public static int majorityElement3(int[] array) {

        int candidate = -1;
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            if (counter == 0) {
                candidate = array[i];
            } else if (array[i] == candidate) {
                counter++;
            } else {
                counter--;
            }
        }

        //verify
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == candidate) {
                j++;
            }
        }
        return (j > array.length / 2) ? candidate : -1;
    }
}
