package com.github.xdshent.algorithm.array;

import java.util.List;

/**
 * Find all distinct combinations of given length with repetition allowed
 * Given an array of integers, find all distinct combinations of given
 * length where repetition of elements is allowed.
 * <p>
 * For example:
 * Input: {1,2,3}
 * Output:{1,1},{1,2},{1,3},{2,2},{2,3},{3,3}
 * <p>
 * Input:{1,2,1}
 * Output:{1,1},{1,2},{2,2}
 * <p>
 * The program should print only distinct combinations.
 * For example, for last input, either {1,2} or {2,1} should be considered.
 * <p>
 * We can use recursion to solve this problem. The idea is to add each
 * element of the array in the output starting from last element
 * considered and recurse for remaining elements. To avoid printing
 * permutations, each combination will be considered in same order as
 * array elements. If combination of given size if found, we print it.
 */
public class DistinctCombinationPrint {

    /**
     * time complexity: O(2^N)
     * auxiliary space used: O(N)
     *
     * @param array
     * @param out
     * @param k
     * @param i
     * @param n
     */
    public static void recurse1(int[] array, List<Integer> out, int k, int i, int n) {
        //base case: if combination size is k, print it
        if (out.size() == k) {
            System.out.println(out);
            return;
        }

        for (int j = 0; j < n; j++) {
            //add current element array[j] to the solution and recurse
            // with same index j(as repeated elements are allowed in
            // combinations)
            out.add(array[j]);
            recurse1(array, out, k, j, n);

            //backtrack remove current element from solution
            out.remove(out.size() - 1);
        }
    }

    /**
     * If array contains repeated elements, above code will print
     * duplicate combinations. To print only distinct combinations in
     * case input contains repeated elements, the idea is to sort the
     * array and recurse for only one occurrence of adjacent duplicate
     * elements.
     * <p>
     * time complexity: O(2^N)
     * auxiliary space used: O(N)
     *
     * @param array
     * @param out
     * @param k
     * @param i
     * @param n
     */
    public static void recurse2(int[] array, List<Integer> out, int k, int i, int n) {

        //base case: if combination size is k, print it
        if (out.size() == k) {
            System.out.println(out);
            return;
        }

        //start from previous element in the current combination till
        // last element
        for (int j = 0; j < n; j++) {
            //add current element array[j] to the solution and recurse
            // with same index j (as repeated elements are allowed in
            // combinations)
            out.add(array[j]);
            recurse2(array, out, k, j, n);

            //backtrack remove current element from solution
            out.remove(out.size() - 1);

            //code to handle duplicates skip adjacent duplicate element
            while (j < n - 1 && array[j] == array[j + 1]) {
                j++;
            }
        }
    }
}
