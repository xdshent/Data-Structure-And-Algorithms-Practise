package com.github.xdshent.algorithm.array;

public class FindInPartiallySortedMatrix {
    /**
     *
     * @param matrix
     * @param k
     * @return
     */
    public static boolean find(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean isFound = false;
        int row = 0;
        int column = columns - 1;

        while (row < rows && column >= 0) {

            if (matrix[row][column] == k) {
                isFound = true;
                break;
            } else if (matrix[row][column] < k) {
                ++row;
            } else {
                --column;
            }
        }
        return isFound;
    }
}
