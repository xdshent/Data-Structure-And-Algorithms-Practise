package com.github.xdshent.algorithm.array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find count of distinct elements in every sub-array of size k
 * Given an array and an integer k, find the count of distinct elements
 * in every sub-array of size k in the array
 * <p>
 * For example:
 * Input: {2,1,2,3,2,1,4,5}
 * k=5
 * <p>
 * Output:
 * The count of distinct elements in the sub-array {2,1,2,3,2} is 3
 * The count of distinct elements in the sub-array {1,2,3,2,1} is 3
 * The count of distinct elements in the sub-array {2,3,2,1,4} is 4
 * The count of distinct elements in the sub-array {3,2,1,4,5} is 5
 */
public class CountDistinctElements {
    /**
     * The naive solution would be to consider every sub-array in the given array and count all distinct elements in it
     * using two nested loops as shown below. The time complexity of this approach is O(NK^2)
     *
     * @param array
     * @param k
     */
    public static void findDistinctCount1(int[] array, int k) {
        //consider every sub-array of size k
        for (int i = 0; i <= array.length - k; i++) {
            //maintain counter for distinct elements in current sub-array
            int distinct = 0;

            //current sub-array is found by the sub-array[x,x+k)
            for (int j = i; j < i + k; j++) {
                //increase distinct count for array[i] in current sub-array
                distinct++;

                //check if array[i] is present in the sub-array array[x,i-1] or not
                for (int l = i; l < j; l++) {
                    //if duplicate element found in current sub-array
                    if (array[j] == array[l]) {
                        distinct--;
                        break;
                    }
                }
            }
            System.out.printf("The count of distinct elements in the sub-array [%d,%d] is %d\n", i, i + k - 1, distinct);
        }
    }

    /**
     * We know that a set doesn't store duplicate elements. We can take advantage of this fact and
     * insert all elements of the current sub-array in a set and then the set size would be the
     * distinct element count. This reduce the complexity to O(NK) but uses O(K) extra space. We
     * can even extend the solution to print the contents of the set as shown here.
     *
     * @param list
     * @param k
     */
    public static void findDistinctCount2(List<Integer> list, int k) {
        for (int i = 0; i < list.size() - (k - 1); i++) {
            Set<Integer> distinct = new HashSet<>();
            distinct.addAll(list.subList(i, i + k));

            System.out.println("The count of distinct elements in the sub-array[" + i + ", " + (i + k - 1) + "] is " + distinct.size());
        }
    }
}
