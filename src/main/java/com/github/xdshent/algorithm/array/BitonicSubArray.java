package com.github.xdshent.algorithm.array;

/**
 * Find Longest Bitonic Sub-Array in an array
 * <p>
 * The longest bitonic sub-array problem is to find a sub-array of a given
 * sequence in which the sub-array's elements are first sorted in increasing
 * order, then in decreasing order, and the sub-array is as long as possible.
 * Strictly ascending or descending sub-arrays are also accepted.
 * <p>
 * For example:
 * Longest Bitonic Sub-Array of sequence{3,5,8,4,5,9,10,8,5,3,4} is
 * {4,5,9,10,8,5,3}
 * <p>
 * The idea is to maintain two arrays I[] and D[]
 * I[i] stores the length of the longest increasing sub-array ending at
 * array[i]
 * D[i] stores the length of the longest decreasing sub-array starting from
 * array[i]
 * <p>
 * Finally, length of longest bitonic sub-array is maximum among all
 * (I[i]+D[i]-1). We can also keep track of two end-points of longest
 * bitonic sub-array found so far to print LBS.
 */
public class BitonicSubArray {
    /**
     * time complexity: O(N)
     * auxiliary space used: O(N)
     *
     * @param array
     * @return
     */
    public static int findBitonicSubArray1(int[] array) {
        int[] I = new int[array.length];
        I[0] = 1;

        for (int i = 1; i < array.length; i++) {
            I[i] = 1;

            if (array[i - 1] < array[i]) {
                I[i] = I[i - 1] + 1;
            }
        }

        int[] D = new int[array.length];
        D[array.length - 1] = 1;

        for (int j = array.length - 2; j >= 0; j--) {
            D[j] = 1;

            if (array[j] > array[j + 1]) {
                D[j] = D[j + 1] + 1;
            }
        }

        int lbsLen = 1;
        int begin = 0, end = 0;

        for (int i = 0; i < array.length; i++) {
            if (lbsLen < (I[i] + D[i] - 1)) {
                lbsLen = I[i] + D[i] - 1;
                begin = i - I[i] + 1;
                end = i + D[i] - 1;
            }
        }

        System.out.println("The length of longest bitonic sub-array is: " + lbsLen);
        System.out.println("The longest bitonic sub-array is [" + begin + ", " + end + "]");

        return lbsLen;
    }


    /**
     * @param array
     * @return
     */
    public static int findBitonicSubArray2(int[] array) {
        int maxLength = 0, endIndex = 0;

        int i = 0;
        while (i + 1 < array.length) {
            int len = 1;

            while (i + 1 < array.length && array[i] < array[i + 1]) {
                i++;
                len++;
            }

            while (i + 1 < array.length && array[i] > array[i + 1]) {
                i++;
                len++;
            }

            if (len > maxLength) {
                maxLength = len;
                endIndex = i;
            }
        }

        System.out.println("The length of longest bitonic sub-array is " + maxLength);
        System.out.println("The longest bitonic sub-array is [" + (endIndex - maxLength + 1) + ", " + endIndex + "]");
        return maxLength;
    }
}
