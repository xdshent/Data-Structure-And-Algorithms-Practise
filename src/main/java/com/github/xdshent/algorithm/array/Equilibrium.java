package com.github.xdshent.algorithm.array;

import java.util.stream.IntStream;

/**
 * Find equilibrium index of an array
 * <p>
 * Given an array of integers, find equilibrium index in it.
 * <p>
 * For an array A consisting n elements, index i is an equilibrium index
 * if sum of elements of sub-array A[0..i-1] is equal to the sum of
 * elements of sub-array A[i+1..n-1] i.e.
 * <p>
 * (A[0]+A[1]..+A[i-1])=(A[i+1]+A[i+2]+...+A[n-1]) where 0<i<n-1
 * <p>
 * Similarly, 0 is an equilibrium index if(A[1]+A[2]+...+A[n-1])=0 and n-1
 * is an equilibrium index if (A[0]+A[1]+...+A[n-2])=0
 * <p>
 * For example, consider the array{0,-3,5,-4,-2,3,1,0}. The equilibrium
 * index found at index 0, 3 and 7.
 * <p>
 * Naive solution:
 * Naive approach is to calculate sum of elements to the left and sum of
 * elements to the right for each element of the array. If left sub-array
 * sum is same as right sub-array sum for an element, we print its index.
 * The time complexity of above solution is O(N^2).
 */
public class Equilibrium {
    /**
     * Liner time solution:
     * <p>
     * We can solve this problem in linear time by using extra space.
     * The idea is to create an auxiliary array left[] where left[i] stores
     * sum of elements of sub-array A[0..i-1]. After left[] is filled, we
     * traverse the array from right to left and update right sub-array
     * sum for each element encountered. Now if sum of elements of left
     * sub-array A[0..i-1] is equal to the sum of elements of right
     * sub-array A[i+1..n) for element A[i], we have found equilibrium
     * index at i.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(N)
     *
     * @param array
     */
    public static void equilibriumIndex1(int[] array) {
        //left[i] stores sum of elements of sub-array A[0..i-1]
        int[] left = new int[array.length];

        left[0] = 0;

        //traverse array from left to right
        for (int i = 1; i < array.length; i++) {
            left[i] = left[i - 1] + array[i - 1];
        }

        int right = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (left[i] == right) {
                System.out.println("Equilibrium index found at: " + i);
            }

            //new right = array[i]+(array[i+1]+array[i+2]+..+array[n-1])
            right += array[i];
        }
    }

    /**
     * Optimized solution
     * <p>
     * We can avoid using extra space. The idea is to calculate the sum of
     * all elements of the array. Then we start from the last element of
     * the array and maintain right sub-array sum. We can calculate left
     * sub-array sum in constant time by subtracting right sub-array sum
     * and current element from total sum. i.e.
     * <p>
     * Sum of left sub-array array[0..i-1] = total - (array[i] + sum of
     * right sub-array array[i+1..n-1])
     *
     * @param array
     */
    public static void equilibriumIndex2(int[] array) {
        //total stores sum of all elements of the array
        int total = IntStream.of(array).sum();//Java 8

        int right = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            if (right == total - (array[i] + right)) {
                System.out.println("Equilibrium index found at " + i);
            }

            right += array[i];
        }
    }
}
