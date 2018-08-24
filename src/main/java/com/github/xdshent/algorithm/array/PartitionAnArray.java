package com.github.xdshent.algorithm.array;

import java.util.Arrays;

/**
 * Partition an array into two sub-arrays with the same sum
 * Given an array of integers, partition the array into two sub-arrays having the same sum of elements.
 * For example:
 * Input: {6,-4,-3,2,3}
 * Output: The two sub arrays are{6,-4} and {-3,2,3} having equal sum of 2
 * <p>
 * Input: {6,-5,2,-4,1}
 * Output: The two sub arrays are {} and {6,-5,2,-4,1} having equal sum of 0
 * <p>
 * Simple solution would to iterate the array and for each element of the array, we calculate sum of left sub array
 * and right sub array. The time complexity of this solution is O(N^2)
 */
public class PartitionAnArray {

    /**
     * time complexity: O(N^2)
     * auxiliary space used: O(1)
     *
     * @param array
     */
    public static void partitionArray1(int[] array) {
        int i = partition1(array);

        if (i != -1) {
            printArray(array, 0, i - 1);

            printArray(array, i, array.length - 1);
        } else {
            System.out.println("The array can't be partitioned");
        }
    }

    /**
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param array
     */
    public static void partitionArray2(int[] array) {
        int i = partition2(array);

        if (i != -1) {
            printArray(array, 0, i - 1);

            printArray(array, i, array.length - 1);
        } else {
            System.out.println("The array can't be partitioned");
        }
    }

    /**
     * We can also solve this problem in O(N) time and O(1) space. The idea is to pre-process the array and calculate
     * sum of all elements present in the array. Then for each element of the array, we can calculate its right sum in O(1)
     * time by using below formula:
     *
     * @param array
     */
    private static int partition2(int[] array) {
        //calculate sum of all elements present in the array
        int totalSum = Arrays.stream(array).sum();

        //variable to maintain sum of processed elements
        int sumSoFar = 0;

        //do for each element of the array
        for (int i = 0; i < array.length; i++) {
            //if sum of array[0..i-1] is equal to array[i,n-1]
            if (sumSoFar == totalSum - sumSoFar) {
                return i;
            }

            //update sumSoFar by including value of the current element
            sumSoFar += array[i];
        }
        return -1;
    }

    /**
     * Partition the array into two sub arrays with the same sum
     *
     * @param array
     * @return
     */
    public static int partition1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += array[i];
            }

            int rightSum = 0;
            for (int j = 0; j < array.length; j++) {
                rightSum += array[j];
            }

            //if sum of array[0..i-1] is equal to array[i,n-1]
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param array
     * @param i
     * @param j
     */
    private static void printArray(int[] array, int i, int j) {
        for (int k = 0; k <= j; k++) {
            System.out.print(array[k] + " ");
        }
        System.out.println();
    }
}
