package com.github.xdshent.algorithm.array;

import java.util.Arrays;

/**
 * Find maximum product of two integers in an array
 * Given an array of integers, find maximum product of two integers in
 * an array.
 * <p>
 * For example, consider the array {-10,-3,5,6,-2}. The maximum
 * product is formed by the {-10,-3} or {5,6} pair.
 * <p>
 * Naive solution would be to consider every pair of elements and
 * calculate their product. We update maximum product found so far if
 * the product of current pair is greater. Finally, we print the
 * elements involved in maximum product.
 */
public class FindMaximumProduct {

    /**
     * Naive solution
     * time complexity: O(N^2)
     * auxiliary space used: O(1)
     *
     * @param array
     */
    public static void findMaximumProduct1(int[] array) {
        int maxProduct = Integer.MIN_VALUE;
        int maxI = -1;
        int maxJ = -1;

        //consider every pair of element
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] * array[j] > maxProduct) {
                    maxProduct = array[i] * array[j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        System.out.println("Pair is (" + array[maxI] + ", " + array[maxJ] + ")");
    }

    /**
     * Time complexity can be improved by sorting the array. Then the
     * maximum product is formed by maximum of
     * <p>
     * 1: product of maximum and second maximum integer in the array
     * which are last two elements in sorted array.
     * <p>
     * 2: product of minimum and second minimum integer in the array
     * which are first two elements in sorted array.
     * <p>
     * time complexity: O(Nlog(N))
     * auxiliary space used: O(1)
     *
     * @param array
     */
    public static void findMaximumProduct2(int[] array) {
        Arrays.sort(array);

        if (array[0] * array[1] > array[array.length - 1] * array[array.length - 2]) {
            System.out.println("Pair is(" + array[0] + ", " + array[1] + ")");
        } else {
            System.out.println("Pair is (" + array[array.length - 1] + ", " + array[array.length - 2]);
        }
    }

    /**
     * We can solve this problem in linear time as we need only
     * maximum, second maximum, minimum, minimum and second minimum
     * element to solve this problem. We can compute all these in
     * only single traversal of the array which accounts for O(N)
     * time complexity.
     *
     * @param array
     */
    public static void findMaximumProduct3(int[] array) {

        //to store maximum and second maximum element in an array
        int firstMax = array[0], secondMax = Integer.MIN_VALUE;

        int firstMin = array[0], secondMin = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            //if current element is more than the maximum element,
            //update maximum and second maximum element
            if (array[i] > firstMax) {
                secondMax = firstMax;
                firstMax = array[i];
            }
            //if current element is more than the second maximum,
            //but less than maximum, update second maximum element.
            else if (array[i] > secondMax) {
                secondMax = array[i];
            }

            //if current element is less than minimum but greater
            // than second minimum element, update second minimum
            // element
            if (array[i] < firstMin) {
                secondMin = firstMin;
                firstMin = array[i];
            }
            //if current element is less than second minimum but
            // greater than first minimum element, update second
            // minimum element
            else if (array[i] < secondMin) {
                secondMin = array[i];
            }
        }

        //Maximum product is formed by maximum of
        //1: product of maximum and second maximum element or
        //2: product of minimum and second minimum element
        if (firstMax * secondMax > firstMin * secondMin) {
            System.out.println("Pair is (" + firstMax + ", " + secondMax + ")");
        } else {
            System.out.println("Pair is (" + firstMin + ", " + secondMin + ")");
        }
    }
}
