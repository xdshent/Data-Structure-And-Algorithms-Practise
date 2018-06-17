package com.github.xdshent.algorithm.array;

/**
 * Find all distinct combinations of given length -Part 1
 * Given an array of integers, find all distinct combinations of
 * given length.
 * <p>
 * For example:
 * Input: {1,2,3} k=2
 * Output: {1,2},{1,3},{2,3}
 * <p>
 * Input: {1,2,1} k=2
 * Output: {1,1},{1,2}
 * <p>
 * The program should print only distinct combinations. For example,
 * for above input, either {1,2} or {2,1} should be considered.
 * <p>
 * We can use recursion to solve this problem. The idea is to add
 * each element in the output and recurse for remaining elements with
 * one less element. To avoid printing permutations, each combination
 * will be constructed in same order as array elements. If combination
 * of given size is found, we print it. Below solution generates all
 * combinations by using above logic by traversing the array from
 * left to right. To print only distinct combinations in case input
 * contains repeated elements, we can sort the array and exclude all
 * adjacent duplicates from the array.
 */
public class DistinctCombinations {
    /**
     * time complexity：O(2^N)
     * auxiliary space used: O(N)
     *
     * @param array
     * @param out
     * @param i
     * @param n
     * @param k
     */
    public static void recurse1(int[] array, String out, int i, int n, int k) {
        //invalid input
        if (k > n) {
            return;
        }

        //base case: combinations size is k
        if (k == 0) {
            System.out.println(out);
            return;
        }

        //start from next index till last index
        for (int j = i; j < n; j++) {
            //add current element array[j] to solution & recurse for
            //next index (j+1) with one less element (k-1)
            recurse1(array, out + " " + (array[j]), j + 1, n, k - 1);

            //uncomment below code to handle duplicates
            while (j < n - 1 && array[j] == array[j + 1]) {
                j++;
            }
        }
    }

    /**
     * We can also process the elements of the array from right to
     * left. The idea is illustrated below:
     *
     * time complexity: O(2^N)
     * auxiliary space used: O(N)
     * @param array
     * @param out
     * @param n
     * @param k
     */
    public static void recurse2(int[] array, String out, int n, int k) {
        //invalid input
        if (k > n) {
            return;
        }

        //base case: combination size is k
        if (k == 0) {
            System.out.println(out);
            return;
        }

        for (int i = n - 1; i >= 0; i--) {

            //add current element array[i] to output and recurse for
            // next index (i-1) with one less element (k-1)
            recurse2(array, (array[i]) + " " + out, i, k - 1);

            //uncomment below code to handle duplicates
            while (i > 0 && array[i] == array[i - 1]) {
                i--;
            }
        }
    }
}
