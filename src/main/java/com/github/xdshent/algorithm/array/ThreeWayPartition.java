package com.github.xdshent.algorithm.array;

/**
 * Given an array containing only 0's, 1's and 2's, sort the array in
 * linear time and using constant space.
 * <p>
 * For example:
 * Input: {0,1,2,2,1,0,0,2,0,1,1,0}
 * Output: {0,0,0,0,0,1,1,1,1,2,2,2}
 * <p>
 * Simple solution would be to perform count sort.We count the number
 * of 0's, 1's and 2's and the put them in the array in their correct
 * order. The time complexity of above solution is O(N) but it
 * requires two traversal of the array.
 * <p>
 * We can rearrange the array in single traversal using an alternative
 * liner-time partition routine can be used that separates the values
 * into three groups:
 * <p>
 * values less than the pivot
 * values equal to the pivot and
 * values greater than the pivot.
 * <p>
 * To solve this particular problem, we consider 1 as a pivot. Below
 * linear-time partition routine is similar to three-way Partitioning
 * for Dutch national flag problem.
 */
public class ThreeWayPartition {

    public static void threeWayPartition(int[] array, int end) {
        int start = 0, mid = 0;
        int pivot = 1;

        while (mid <= end) {
            if (array[mid] < pivot) {
                swap(array, mid, start);
                ++mid;
                ++start;
            } else if (array[mid] > pivot) {
                swap(array, mid, end);
                --end;
            } else {
                ++mid;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
