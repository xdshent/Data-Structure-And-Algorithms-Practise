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
}
