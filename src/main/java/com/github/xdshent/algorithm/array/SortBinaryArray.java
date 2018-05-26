package com.github.xdshent.algorithm.array;

/**
 * Given an binary array, sort it in linear time and constant space.
 * Output should print contain all zeros followed by all ones.
 * <p>
 * For example:
 * Input: {1,0,1,0,1,0,0,1}
 * Output: {0,0,0,0,1,1,1,1}
 * <p>
 * Simple solution would be to count number of 0's present in the
 * array(say k)and fill first k indicates in the array by 0
 * and all remaining indicates by 1.
 * <p>
 * Alternatively, we can also count number of 1's present in the
 * array(say k)and fill last k indicates in the array by 1 and all
 * remaining indicates by 0.
 */
public class SortBinaryArray {

    /**
     * function to sort binary array in linear time
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param array
     */
    public static void sort1(int[] array) {
        int zeros = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                zeros++;
            }
        }

        //put 0's in the beginning
        int k = 0;
        while (k < zeros) {
            array[k++] = 0;
        }

        //fill all remaining elements by 1
        while (k < array.length) {
            array[k++] = 1;
        }
    }

    /**
     * Instead of counting number of zeros, if the current element is 0,
     * we can place 0 at next available position in the array. After
     * all elements in the array are processed, we fill all remaining
     * indicates by 1.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param array
     */
    public static void sort2(int[] array) {
        int k = 0;

        //do for each element
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[k++] = 0;
            }
        }

        for (int i = k; i < array.length; i++) {
            array[i] = 1;
        }
    }

    /**
     * We can also solve this problem in liner time by using
     * partitioning logic of quick sort. The idea is to use 1 as pivot
     * element and make one pass of partition process. The resultant
     * array will be sorted.
     *
     * @param array
     */
    public static void sort3(int[] array) {

        int pivot = 1;
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < pivot) {
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
