package com.github.xdshent.algorithm.array;

/**
 * Find maximum sum path involving elements of given arrays
 * Given two sorted array of integers, find a maximum sum path involving
 * elements of both arrays whose sum is maximum. We can start from
 * either arrays but we can switch between arrays only through its
 * common elements.
 * <p>
 * For example:
 * Input:
 * X={3,6,7,8,10,12,15,18,100}
 * Y={1,2,3,5,7,9,10,11,15,16,18,25,50}
 * <p>
 * The maximum sum path is:
 * 1->2->3->6->7->9->10->12->15->16->18->100
 * The maximum sum path is: 199
 */
public class MaximumSumPath {
    /**
     * time complexity: O(N+M)
     * auxiliary space used: O(1)
     *
     * @param arrayX
     * @param arrayY
     * @return
     */
    public static int maxSum(int[] arrayX, int[] arrayY) {
        int sum = 0;
        int sumX = 0, sumY = 0;

        int m = arrayX.length, n = arrayY.length;

        //i and j denotes current index of X and Y respectively
        int i = 0, j = 0;

        //loop till arrayX and arrayY are not empty
        while (i < m && j < n) {

            //to handle duplicate elements in arrayX
            while (i < m - 1 && arrayX[i] == arrayX[i + 1]) {
                sumX += arrayX[i++];
            }

            //to handle duplicate elements in arrayY
            while (j < n - 1 && arrayY[j] == arrayY[j + 1]) {
                sumY += arrayY[j++];
            }

            //if current element of Y is less than current element of X
            if (arrayY[j] < arrayX[i]) {
                sumY += arrayY[j];
                j++;
            } else if (arrayX[i] < arrayY[j]) {
                //if current element of X is less than current element of Y
                sumX += arrayX[i];
                i++;
            } else {// if (arrayX[i] == arrayY[j])
                //consider maximum sum and include value of current cell
                sum += Integer.max(sumX, sumY) + arrayX[i];

                //move both indices by 1 position
                i++;
                j++;

                //reset both sums
                sumX = 0;
                sumY = 0;
            }
        }

        //process remaining elements of X (if any)
        while (i < m) {
            sum += arrayX[i++];
        }

        //process remaining elements of Y (if any)
        while (j < n) {
            sum += arrayY[j++];
        }
        return sum;
    }
}
