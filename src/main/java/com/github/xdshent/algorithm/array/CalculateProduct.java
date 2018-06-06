package com.github.xdshent.algorithm.array;

/**
 * Replace each element of the array with product of every other element
 * without using division operator.
 * <p>
 * Given an array of integers, replace each element of the array with
 * product of every other element in the array without using division
 * operator.
 * <p>
 * For example:
 * Input: {1,2,3,4,5}
 * Output: {120,60,40,30,24}
 * <p>
 * Input:{5,3,4,2,6,8}
 * Output: {1152,1920,1440,2880,960,720}
 * <p>
 * Naive approach would be to calculate product of all element in the
 * left sub-array and right sub-array for each element of the array. The
 * time complexity of above solution is O(N^2).
 * <p>
 * We can solve this problem in linear time by using two auxiliary
 * arrays left[] and right[] where left[i] stores the product of all
 * elements in the sub-array array[0,i-1] and right[i] stores the
 * product of all elements in sub-array array[i+1,n-1]. Now for each
 * element array[i], we simply replace it with product of its left
 * sub-array and right sub-array (i.e. array[i]=left[i]*right[i]).
 */
public class CalculateProduct {
    /**
     * time complexity: O(N)
     * auxiliary space used: O(N)
     *
     * @param array
     */
    public static void calculateProduct1(int[] array) {

        //use two auxiliary arrays
        int[] left = new int[array.length];
        int[] right = new int[array.length];

        //left[i] stores the product of all elements in sub-array[0,i-1]
        left[0] = 1;
        for (int i = 1; i < array.length; i++) {
            left[i] = array[i - 1] * left[i - 1];
        }

        //right stores the product of all elements in sub-array[i+1,n-1]
        right[array.length - 1] = 1;
        for (int j = array.length - 2; j >= 0; j--) {
            right[j] = array[j + 1] * right[j + 1];
        }

        //replace each element with product of its left and right
        // sub-array
        for (int i = 0; i < array.length; i++) {
            array[i] = left[i] * right[i];
        }
    }

    /**
     * We can use recursion to solve this problem in linear time and
     * constant space. The idea is to recursively calculate the product
     * of all elements in the right sub-array and pass left sub-array
     * product in function arguments.
     *
     * @param array
     */
    public static int calculateProduct2(int[] array, int n, int left, int i) {
        //base case: no elements left on right side
        if (i == n) {
            return 1;
        }

        //take back-up of current element
        int curr = array[i];

        //calculate product of the right sub-array
        int right = calculateProduct2(array, n, left * array[i], i + 1);

        //replace current element with product of left and right sub-array
        array[i] = left * right;

        //return product of right sub-array including current element
        return curr * right;
    }
}
