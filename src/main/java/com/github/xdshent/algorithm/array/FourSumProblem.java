package com.github.xdshent.algorithm.array;

import java.util.*;

/**
 * 4 sum problem. Quadruplets with given sum.
 * Given an unsorted array of integers, check if it contains four elements tuple(Quadruplets) having
 * given sum.
 * <p>
 * For example,
 * Input: arr={2,7,4,0,9,5,1,3}
 * sum=20
 * <p>
 * Output: Quadruplet exists.
 * Below are quadruplets with given sum 20
 * {0,4,7,9}
 * {1,3,7,9}
 * {2,4,5,9}
 */
public class FourSumProblem {
    /**
     * Naive recursive approach
     * The idea is similar to 0-1 Knapsack problem and use recursion to solve this problem. For
     * each item, we either consider current item or exclude it and recurse for remaining elements.
     * We return true if we get desired sum by including current item.
     *
     * @param array
     * @param n
     * @param sum
     * @param count
     * @return
     */
    public static boolean quadTuple1(int[] array, int n, int sum, int count) {
        //if desired sum is reached with 4 elements, return true
        if (sum == 0 && count == 4) {
            return true;
        }

        //return false if sum is not possible with current configuration
        if (count > 4 || n < 0) {
            return false;
        }

        //recursion with
        //1. including current element
        //2. excluding current element
        return quadTuple1(array, n - 1, sum - array[n - 1], count + 1)
                || quadTuple1(array, n - 1, sum, count);
    }

    /**
     * Efficient solution using hashing
     * The idea is to consider every pair of elements in the array one by one and insert it into a
     * map. For each pair of element(i,j), we calculate the remaining sum. If remaining sum exists
     * in the map and elements involved in previous occurrence don't overlap with the current pair
     * i.e.((i,j,i,y) or (i,j,x,i) or (i,j,j,y) or (i,j,x,j)), we print the quadruplet and return.
     *
     * @param array
     * @param n
     * @param sum
     * @return
     */
    public static boolean quadTuple2(int[] array, int n, int sum) {
        //create an empty map
        //key -> sum of a pair of elements in the array
        //value -> list storing index of every pair having that sum
        Map<Integer, List<Pair>> map = new HashMap<>();

        //consider each element except last element
        for (int i = 0; i < n - 1; i++) {
            //start from i'th element till last element
            for (int j = i + 1; j < n; j++) {
                //calculate remaining sum
                int val = sum - (array[i] + array[j]);

                //if remaining sum is found in the map,
                //we have found a quadruplet
                if (map.containsKey(val)) {
                    //check every pair having sum equal to remaining sum
                    for (Pair pair : map.get(val)) {
                        int x = pair.x;
                        int y = pair.y;

                        //if quadruplet don't overlap, print it and return true
                        if ((x != i && x != j) && (y != i && y != j)) {
                            System.out.println("Quadruplet Found(" + array[i] + "," + array[j] + "," + array[x] + "," + array[y]);
                            return true;
                        }
                    }
                }

                //insert current pair into map
                //null check
                map.putIfAbsent(array[i] + array[j], new ArrayList<>());
                map.get(array[i] + array[j]).add(new Pair(i, j));
            }
        }
        return true;
    }

    /**
     * Print all quadruplets with given sum
     * <p>
     * For example,
     * Input:
     * array = {2,7,4,0,9,5,1,3}
     * sum=20
     * <p>
     * Output:
     * Below are the quadruplets with sum 20
     * {0,4,7,9}
     * {1,3,7,9}
     * {2,4,5,9}
     * <p>
     * We start by sorting the given array in ascending order and then for each pair (array[i],array[j]) in the array where (i<j),
     * we check if a quadruplet is formed by current pair and a pair from sub-array array[j+1..n).
     * Refer this post to find pairs with given sum in a sorted array in linear time.
     *
     * @param array
     * @param sum
     */
    public static void quadTuple(int[] array, int sum) {
        //sort the array in ascending order
        Arrays.sort(array);

        //check if Quadruplet is formed by array[i], array[j] and a pair
        //from sub-array array[j+1..n]
        for (int i = 0; i <= array.length - 4; i++) {
            for (int j = i + 1; j <= array.length - 3; j++) {
                //k stores remaining sum
                int k = sum - (array[i] + array[j]);

                //check for sum k in sub-array array[j+1..n]
                int low = j + 1, high = array.length - 1;

                while (low < high) {
                    if (array[low] + array[high] < k) {
                        low++;
                    } else if (array[low] + array[high] > low) {
                        high--;
                    } else {
                        //Quadruplet with given sum found
                        System.out.println("(" + array[i] + "," + array[j] + "," + array[low] + "," + array[high]);
                        low++;
                        high--;
                    }
                }
            }
        }
    }

    static class Pair {
        public int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
