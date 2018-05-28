package com.github.xdshent.algorithm.array;

import java.util.Random;

/**
 * Shuffle a given array of elements(Fisher-Yates shuffle)
 * <p>
 * Given an array of integers, in-place shuffle it. The algorithm should
 * produce an unbiased permutation i.e. every permutation is equally likely.
 * <p>
 * Fisher-Yates shuffle is used to generate random permutations. It takes
 * time proportional to the number of items being shuffled and shuffled
 * them in place. At each iteration, the algorithm swaps the element with
 * one chosen at random amongst all remaining unvisited elements,
 * including the element itself. Below is complete algorithm.
 * <p>
 * To shuffle an array of n elements:
 * for i from n-1 downto 1 do
 * j=random integer such that 0<=j<=i
 * exchange a[j] and a[i]
 */
public class Shuffle {

    /**
     * Utility function to swap two elements array[i] and array[j]
     * in the array
     *
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param array
     */
    public static void shuffle1(int[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            Random random = new Random();

            //generate a random number j such that 0<=j<=i
            int j = random.nextInt(i + 1);

            //swap current element with randomly generated index
            swap(array, i, j);
        }
    }

    /**
     * An equivalent version which shuffles the array in the opposite
     * direction(from lowest index to highest) is:
     * <p>
     * To shuffle an array of n elements:
     *
     * @param array
     */
    public static void shuffle2(int[] array) {

        for (int i = 0; i <= array.length - 2; i++) {
            Random random = new Random();

            //generate a random number j such that i<=j<n
            int j = i + random.nextInt(array.length - i);

            //swap current element with randomly generated index
            swap(array, i, j);
        }
    }
}
