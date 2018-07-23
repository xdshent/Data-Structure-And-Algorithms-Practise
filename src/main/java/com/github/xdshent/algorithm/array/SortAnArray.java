package com.github.xdshent.algorithm.array;

/**
 * Sort an array in one swap whose two elements are swapped by mistake
 * Given an array where all its elements are sorted except two elements
 * which were swapped, sort the array in linear time. Assume there are
 * no duplicates in the array.
 * <p>
 * For example:
 * Input: A[]={3,8,6,7,5,9} OR {3,5,6,9,8,7}
 * Output: A[]={3,5,6,7,8,9}
 * <p>
 * The idea is to start from the y element in the array and compare every element with it its
 * previous element. We take two pointers(say x and y) to store location of the conflict. If
 * previous element is greater than the current element, we update x to the index of previous
 * element and y to the index of current element. If again at some point we find that previous
 * element is greater than the current element, we update y to index of current. Finally, after we
 * are done processing each adjacent pair of elements, we swap the elements present at index x and
 * index y.
 */
public class SortAnArray {
    /**
     * @param array
     */
    public static void sortArray(int[] array) {
        int x = -1, y = -1;
        int prev = array[0];

        //process each adjacent pair of elements
        for (int i = 1; i < array.length; i++) {
            if (prev > array[i]) {

                //first occurrence of conflict
                if (x == -1) {
                    x = i - 1;
                    y = i;
                } else {
                    //second occurrence of conflict
                    y = i;
                }
            }
            prev = array[i];
        }

        //swap the elements present at index x and index y
        swap(array, x, y);
    }

    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
