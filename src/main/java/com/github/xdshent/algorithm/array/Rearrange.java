package com.github.xdshent.algorithm.array;

/**
 * Rearrange the array while alternate high and low elements
 * <p>
 * Given an array of integers, rearrange the array such that every second element of the array
 * is greater than its left and right elements. Assume no duplicate elements are present in the array.
 * <p>
 * For example,
 * Input: {1,2,3,4,5,6,7}
 * Output: {1,3,2,5,4,7,6}
 * <p>
 * A simple solution would be to sort the array in ascending order first.
 * Then we take an another auxiliary array and fill it with elements starting
 * from the two end-points of the stored array in alternate order.
 * <p>
 * Below is the complete algorithm.
 * <p>
 * rearrangeArray(int[] array, int n)
 * 1: Sort the array in ascending order.
 * 2: Take two index variables i and j to that points to two end-points of the array(i.e. i=0 and j=n-1)
 * 3: Create an auxiliary array A[] & initialize an index k with 0
 * 4: while(i<j)
 * A[k++]=arr[i++]
 * A[k++]=arr[j--]
 * 5: Print A[]
 * <p>
 * The time complexity of this solution would be O(NlogN)
 * <p>
 * An efficient solution doesn't involve sorting the array or use auxiliary space.
 * We start from the second element of the array and increment index by 2 for each iteration of loop.
 * If previous element is greater than the current element, we swap the elements.
 * Similarly if next element is greater than the current element, we swap both elements.
 * At the end of loop, we will get the desired array that statisfies given constraints.
 */
public class Rearrange {
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Function to rearrange the array such that every second element of the array
     * is greater than its left and right elements
     *
     * @param array
     */
    public static void rearrangeArray(int[] array) {
        for (int i = 1; i < array.length; i+=2) {
            if (array[i - 1] > array[i]) {
                swap(array, i - 1, i);
            }

            if (i + 1 < array.length && array[i + 1] > array[i]) {
                swap(array, i, i + 1);
            }
        }
    }

}
