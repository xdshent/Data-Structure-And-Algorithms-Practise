package com.github.xdshent.algorithm.array;

/**
 * Rearrange array such that A[A[i]] is set to i for every element A[i]
 * Given an unsorted array of integers whose each element lies in range 0 to n-1 where n is the size
 * of the array, rearrange array such that A[A[i]] is set to i for every element A[i] in the array
 * <p>
 * Do this in linear time and without using any extra constant space.
 * <p>
 * For example,
 * Input: {1,3,4,2,0}
 * Output: {4,0,3,1,2}
 * <p>
 * Explanation:
 * A[0]=1, A[1] becomes 0
 * A[1]=3, A[3] becomes 1
 * A[2]=4, A[4] becomes 2
 * A[3]=2, A[2] becomes 3
 * A[4]=0, A[0] becomes 4
 * <p>
 * Simple solution would be to create an auxiliary array of size n and for each element A[i] of the
 * input array, we set value i at index A[i] in the auxiliary array.
 */
public class RearrangeArray {
    /**
     * time complexity: O(N)
     * auxiliary space used: O(N)
     *
     * @param array
     */
    public static void rearrange1(int[] array) {
        //create an auxiliary array of same size as array[]
        int[] aux = new int[array.length];

        //for each element array[i], set the value i at index array[i]
        //in the auxiliary array
        for (int i = 0; i < array.length; i++) {
            aux[array[i]] = i;
        }

        //update original array with auxiliary array elements
        for (int i = 0; i < array.length; i++) {
            array[i] = aux[i];
        }
    }

    /**
     * Above solution uses extra space that violates the problem constraints. We can solve this
     * problem without using any extra space by taking advantage of fact that array elements lies
     * in the range 0 to n-1. For each element array[i] present in the array, we increment value
     * present at index (array[i]%n) by i*n. Finally, we traverse the modified array and set
     * (array[i]=array[i]/n).
     * <p>
     * For example, consider array{1,3,4,2,0}. After incrementing value present at index ()
     * array[i]%n) for each element array[i] by i*n, the array becomes
     * <p>
     * {1+5*4,3,4+5*3,2+5*1,0+5*2}={21,3,19,7,10}
     * <p>
     * Now if we take(array[i]/n) for each index i, we get {4,0,3,1,2}
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param array
     * @param n
     */
    public static void rearrange2(int[] array, int n) {
        //for each element array[i] increment value present at index (array[i]%n) by i*n
        for (int i = 0; i < n; i++) {
            array[array[i] % n] += i * n;
        }

        //traverse the modified array and set array[i]=array[i]/n
        for (int i = 0; i < n; i++) {
            array[i] = array[i] / n;
        }
    }
}
