package com.github.xdshent.algorithm.array;

import java.util.List;

/**
 * Maximum Product Subset Problem
 * Given an array of integers, find a subset in it that has maximum product of its elements.
 * <p>
 * For example,
 * Input: A[] = {-6,4,-5,8,-10,0,8}
 * Output: The maximum product of a subset is 15360
 * The subset having maximum product of its elements is {-6,4,8,-10,8}
 * <p>
 * Input: A[]={4,-8,0,8}
 * Output: The maximum product of a subset is 32
 * The subset having maximum product of its elements is {4,8}
 */
public class MaximumProductSubset {
    /**
     * Naive Approach
     * Naive solution would be to consider every subset and find product of their elements.
     * Finally, we return the maximum product found among all subset. The implementation can be seen below.
     *
     * @param S
     * @param set
     * @param n
     * @param maximum
     * @return
     */
    public static int findPowerSet(List<Integer> S, List<Integer> set, int n, int maximum) {
        //if we have considered all elements, we have generated a subset
        if (n == 0) {
            //compute its product of elements & update maximum
            //product found so far
            return maxProduct(set, maximum);
        }

        //consider nth element
        set.add(S.get(n - 1));
        maximum = findPowerSet(S, set, n - 1, maximum);

        //or don't consider nth element
        set.remove(set.size() - 1);
        return findPowerSet(S, set, n - 1, maximum);
    }

    /**
     * @param set
     * @param maximum
     * @return
     */
    private static int maxProduct(List<Integer> set, int maximum) {
        int product = 1;

        for (int j : set) {
            product *= j;
        }

        //if the set is not empty, then update the product
        if (set.size() != 0) {
            maximum = Integer.max(maximum, product);
        }
        return maximum;
    }

    /**
     * Linear time solution
     * The time complexity of above solution is exponential. We can solve this problem in linear time by finding
     * a negative element in the set that has minimum absolute value. We also count the number of negative element
     * in the set that has minimum absolute value. We also count the number of negative elements present in the set.
     * If the count of negative elements is odd, then we exclude that negative element(having minimum absolute value)
     * from the subset, else we consider it(since multiplication of two negative numbers will give a positive number as output).
     * One more special case we need to handle is that 0 will never be part of subset if at-least one positive element or
     * two negative elements are present in the subset. Rest all elements willl form part of the subset.
     *
     * @param array
     * @param n
     * @return
     */
    public static int maxProduct2(int[] array, int n) {
        //base case
        if (n == 0) {
            return 0;
        }

        //if array contains only one element
        if (n == 1) {
            return array[0];
        }

        int product = 1; //to store maximum product subset

        //stores the negative element having minimum absolute value in the set
        int absMinSoFar = Integer.MAX_VALUE;

        //maintain count of negative elements in the set
        int negative = 0;

        //maintain count of positive elements in the set
        int positive = 0;

        boolean containsZero = false;

        //traverse the given array
        for (int i = 0; i < n; i++) {
            //if current element is negative
            if (array[i] < 0) {
                negative++;
                absMinSoFar = Integer.min(absMinSoFar, Math.abs(array[i]));
            }
            //if current element is positive
            else if (array[i] > 0) {
                positive++;
            }

            //if current element is zero
            if (array[i] == 0) {
                containsZero = true;
            } else {
                product *= array[i];
            }
        }

        //if odd number of negative elements are present, exclude the
        //negative element having minimum absolute value from the subset
        if ((negative & 1) != 0) {
            product = product / -absMinSoFar;
        }

        //special case - set contains one negative element and one or more zeros
        if (negative == 1 && positive == 0 && containsZero) {
            product = 0;
        }
        //return maximum product
        return product;
    }
}
