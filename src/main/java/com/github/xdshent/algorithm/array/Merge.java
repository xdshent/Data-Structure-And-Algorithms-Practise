package com.github.xdshent.algorithm.array;

/**
 * Inplace merge two sorted arrays
 * <p>
 * Given two sorted arrays X[] and Y[] of size
 * m and n each, merge elements of X[] with
 * elements of array Y[] by maintaining the
 * sorted order. i.e. fill X[] with first m
 * smallest elements and fill Y[] with remaining
 * elements.
 * <p>
 * The conversion should be done in-place and without using any other data
 * structure.
 * <p>
 * For example:
 * Input:
 * X[]={1,4,7,8,10}
 * Y[]={2,3,9}
 * <p>
 * Output:
 * X[]={1,2,3,4,7}
 * Y[]={8,9,10}
 * <p>
 * The idea is very simple. We consider each element of array X[] and
 * ignore the element if it is already in correct order(i.e. the element
 * smallest among all remaining elements) else we swap it with smallest
 * element which happens to be first element of Y. After swapping, we move
 * the element(now present at Y[0]) to its correct position in Y[] to
 * maintain the sorted order. The merge process is almost similar to merge
 * routine of merge sort algorithm. The only  difference is that we are
 * not using auxiliary array for merging.
 */
public class Merge {
    public static void merge(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;

        for (int i = 0; i < m; i++) {

            //compare current element of X[] with first element of Y[]
            if (X[i] > Y[0]) {
                int temp = X[i];
                X[i] = Y[0];
                Y[0] = temp;

                int first = Y[0];

                //move Y[0] to its correct position to maintain sorted
                //order of Y[]. Note: Y[1..n-1] is already sorted
                int k;
                for (k = 1; k < n && Y[k] < first; k++) {
                    Y[k - 1] = Y[k];
                }
                Y[k - 1] = first;
            }
        }
    }
}
