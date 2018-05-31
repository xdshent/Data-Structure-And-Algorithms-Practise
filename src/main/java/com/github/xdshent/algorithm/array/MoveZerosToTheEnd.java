package com.github.xdshent.algorithm.array;

/**
 * Move all zeros present in the array to the end
 * <p>
 * Given an array of integer, move all zeros present in the array to the
 * end. The solution should maintain the relative order of items in the
 * array.
 * <p>
 * For example:
 * Inout: {6,0,8,2,3,0,4,0,1}
 * Output: {6,8,2,3,4,0,0,0}
 * <p>
 * The idea is very simple. If the current element is non-zero, we can
 * place the element at next available position in the array. After all
 * elements in the array are processed, we fill all remaining indicates by
 * 0.
 */
public class MoveZerosToTheEnd {
    /**
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param array
     */
    public static void reorder1(int[] array) {
        //store index of next available position
        int k = 0;
        for (int i : array) {
            if (i != 0) {
                array[k++] = i;
            }
        }

        for (int i = k; i < array.length; i++) {
            array[i] = 0;
        }
    }

    /**
     * Using partition logic of quick sort
     * <p>
     * We can also solve this problem in one
     * scan of array by modifying  partitioning
     * logic of quick sort. The idea is to use
     * 0 as a pivot element and make one pass of
     * partition process. The partitioning
     * logic will read all elements and each
     * time we encounter a non-pivot element,
     * that element is swapped with the first
     * occurrence of pivot.
     *
     * @param array
     */
    public static void reorder2(int[] array) {
        int j = 0;

        //each time we encounter a non-zero, j is incremented and the
        //element is placed before the pivot
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                swap(array, i, j);
                j++;
            }
        }

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
