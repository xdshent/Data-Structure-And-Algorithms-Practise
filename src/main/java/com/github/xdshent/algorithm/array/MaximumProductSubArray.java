package com.github.xdshent.algorithm.array;

/**
 * Find maximum product sub array in a given array
 * Given an array of integers, find maximum product sub array. In other words,
 * find a sub array that has maximum product of its elements.
 * <p>
 * For example:
 * Input: {-6,4,-5,8,-10,0,8}
 * Output: The maximum product sub array is {4,-5,8,-10} having product 1600
 * <p>
 * Input: {40,0,-20,-10}
 * Output: The maximum product sub array is {-20,-10} having product 200
 */
public class MaximumProductSubArray {
    /**
     * Naive solution would be to consider every sub array and find product of their elements.
     * Finally, we return the maximum product found among all sub arrays.
     * <p>
     * time complexity: O(N^2)
     * auxiliary space used: O(1)
     *
     * @param array
     * @return
     */
    public static int maxProduct1(int[] array) {
        int maxProductSoFar = 0;

        for (int i = 0; i < array.length; i++) {

            //to store current sub array product
            int product = 1;
            for (int j = i; j < array.length - 1; j++) {
                //product of elements so far
                product *= array[j];

                //update max product if required
                if (product > maxProductSoFar) {
                    maxProductSoFar = product;
                }
            }
        }
        return maxProductSoFar;
    }

    /**
     * A better solution will be to maintain two variables to store the maximum and minimum product
     * ending at current position. Then we traverse the array once and for every index i in the array,
     * we update maximum and minimum product ending at array[i]. We update the result if maximum product
     * ending at any index if more than maximum product found so far.
     *
     * @param array
     * @return
     */
    public static int maxProduct2(int[] array) {
        //maintain two variables to store maximum and minimum product ending at current index.
        int maxEnding = 0, minEnding = 0;

        //to store maximum product sub array found so far
        int maxProductSoFar = 0;

        //traverse the given array
        for (int i : array) {
            int temp = maxEnding;

            //update maximum product ending at current index
            maxEnding = Integer.max(i, Integer.max(i * maxEnding, i * minEnding));

            //update minimum product ending at current index
            minEnding = Integer.min(i, Integer.min(i * temp, i * minEnding));

            maxProductSoFar = Integer.max(maxProductSoFar, maxEnding);
        }
        return maxProductSoFar;
    }
}
