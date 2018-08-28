package com.github.xdshent.algorithm.array;

public class DuplicationInArray {
    /**
     * @param array
     * @return
     */
    public static boolean duplication1(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 || array[i] > array.length - 1) {
                return false;
            }
        }

        for (int i = 0; i < array.length; i++) {
            while (array[i] != i) {
                if (array[i] == array[array[i]]) {
                    return true;
                }

                //swap
                int temp = array[i];
                array[i] = array[temp];
                array[temp] = temp;
            }
        }
        return false;
    }

    /**
     * @param array
     * @return
     */
    public static int duplication2(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;

            int count = countRange(array, start, middle);

            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }

            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    /**
     * @param array
     * @param start
     * @param middle
     * @return
     */
    private static int countRange(int[] array, int start, int middle) {
        if (array == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= start && array[i] <= middle) {
                count++;
            }
        }
        return count;
    }
}
