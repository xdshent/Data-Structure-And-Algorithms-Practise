package com.github.xdshent.algorithm.array;

import java.util.Random;

/**
 * Quick Select Algorithm
 * Quick Select is a selection algorithm to find the kth smallest element in an unordered list. It is closely
 * related to the quick sort sorting algorithm. Like quick sort, it is efficient in practice and has good
 * average-case performance, but has poor worst-case performance.
 * <p>
 * Input: arr = {7,4,6,3,9,1}
 * k=2
 * Output: k'th smallest element in the array is 4
 * <p>
 * Input: arr={7,4,6,3,9,1}
 * k=0 (k starts from 0)
 * Output: k'th smallest element in the array is 1
 * <p>
 * Quick select uses the same overall approach as quick sort, choosing one element as a pivot and partitioning the data
 * in two based on the pivot, accordingly as less than or greater than the pivot. However, instead of recurse into both sides as in quick sort.,
 * quick select only recurse into one side-the side with the element is searching for. Since the pivot is in its final sorted position,
 * all those preceding it in an unsorted order and all those following it in an unsorted order. This reduces the average complexity from O(NlogN)
 * to O(N), with a worst case of O(N^2).
 */
public class QuickSelectAlgorithm {

    /**
     *
     * @param array
     * @param left
     * @param right
     * @param k
     * @return
     */
    public static int quickSelect1(int[] array, int left, int right, int k) {
        while (true) {
            if (left == right) {
                return array[left];
            }

            int pivotIndex = left + rand(left, right);

            pivotIndex = partition(array, left, right, pivotIndex);

            if (k == pivotIndex) {
                return array[k];
            } else if (k < pivotIndex) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
    }

    /**
     * @param array
     * @param left
     * @param right
     * @param k
     * @return
     */
    public static int quickSelect2(int[] array, int left, int right, int k) {

        // if the array contains only one element, return that element
        if (left == right) {
            return array[left];
        }

        int pivotIndex = rand(left, right);

        pivotIndex = partition(array, left, right, pivotIndex);

        if (k == pivotIndex) {
            return array[k];
        } else if (k < pivotIndex) {
            return quickSelect2(array, left, pivotIndex - 1, k);
        } else {
            return quickSelect2(array, pivotIndex + 1, right, k);
        }
    }


    /**
     * @param array
     * @param left
     * @param right
     * @param pivotIndex
     * @return
     */
    //partition using Lomuto partition scheme
    private static int partition(int[] array, int left, int right, int pivotIndex) {
        //pick pivotIndex as pivot from the array
        int pivot = array[pivotIndex];

        //move pivot to end
        swap(array, pivotIndex, right);

        int pIndex = left;
        int i;

        for (i = left; i < right; i++) {
            if (array[i] <= pivot) {
                swap(array, i, pIndex);
                pIndex++;
            }
        }

        swap(array, pIndex, right);

        //return pIndex (index of pivot element)
        return pIndex;
    }

    /**
     * @param min
     * @param max
     * @return
     */
    private static int rand(int min, int max) {
        if (min > max || (max - min) > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Invalid value");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    /**
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
