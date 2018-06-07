package com.github.xdshent.algorithm.array;

import java.util.stream.IntStream;

/**
 * Find a duplicate element in a limited range array
 * Given a limited range array of size n where array contains elements
 * between 1 to n-1 with one element repeating, find the duplicate
 * number in it.
 * <p>
 * For example:
 * Input: {1,2,3,4,4}
 * Output: The duplicate element is 4
 */
public class FindDuplicate {
    /**
     * Approach 1:
     * <p>
     * The idea is to use hashing to solve this problem. We can use a
     * visited boolean array to mark if an element is seen before or
     * not. If the element is already encountered before, the visited
     * array will return true.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(N)
     *
     * @param array
     */
    public static int findDuplicate1(int[] array) {
        //create an visited array of size n+1
        //we can also use map instead of visited array
        boolean[] visited = new boolean[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            if (visited[array[i]]) {
                return array[i];
            }
            visited[array[i]] = true;
        }
        return -1;
    }

    /**
     * Approach 2:
     * <p>
     * We can solve this problem in constant space. Since the array
     * contains all distinct elements except one and all elements lies
     * in range 1 to n-1, we can check for duplicate element by
     * marking array elements as negative by using array index as a
     * key. For each array element array[i], we get absolute value of
     * the element abs(array[i]) and invert the sign of element
     * present at index abs(array[i])-1. Finally, we traverse array
     * once again and if a positive number is found at index i, then
     * the duplicate element is i+1.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: (1)
     *
     * @param array
     * @return
     */
    public static int findDuplicate2(int[] array) {
        int duplicate = -1;

        for (int i = 0; i < array.length; i++) {
            int absValue = (array[i] < 0) ? -array[i] : array[i];

            if (array[absValue - 1] >= 0) {
                array[absValue - 1] = -array[absValue - 1];
            } else {
                duplicate = absValue;
                break;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = -array[i];
            }
        }
        return duplicate;
    }

    /**
     * Approach 3:
     * <p>
     * We can also solve this problem by taking xor of all array
     * elements with numbers from 1 to n-1. Since same elements will
     * cancel out each other as a^a=0,0^0=0 and 0^a=a, we will be left
     * with the duplicate element.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param array
     * @return
     */
    public static int findDuplicate3(int[] array) {
        int xor = 0;

        for (int i = 0; i < array.length; i++) {
            xor ^= array[i];
        }

        for (int i = 1; i <= array.length - 1; i++) {
            xor ^= i;
        }

        //xor will contain the missing number
        return xor;
    }

    /**
     * Approach 4:
     * <p>
     * Finally, the post is incomplete without this textbook
     * solution: find sum of all element and find difference between
     * it and all elements which are supposed to be there.
     * <p>
     * time complexity: O(N)
     * auxiliary space used: O(1)
     *
     * @param array
     * @return
     */
    public static int findDuplicate4(int[] array) {
        int actualSum = IntStream.of(array).sum();
        int expectedSum = array.length * (array.length - 1) / 2;

        return actualSum - expectedSum;
    }
}
