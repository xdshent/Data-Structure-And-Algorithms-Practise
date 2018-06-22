package com.github.xdshent.algorithm.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Find largest number possible from set of given numbers
 * Find largest number possible from set of given numbers.
 * The numbers should be appended to each other in any order
 * to from the largest number.
 * <p>
 * For example:
 * Input: {10,68,75,7,21,12}
 * Output: {77568211210}
 * <p>
 * The idea is to write our own custom comparator
 * function for the sorting routine. For two numbers X and Y,
 * the custom comparator function will not compare X and Y
 * with each other but it compares XY with YX and the greater
 * number will come first in sorted order.
 * Here, XY denotes number formed by appending Y to X and YX
 * denotes number formed by appending X to Y.
 * <p>
 * For example:
 * X=15 and Y = 4,XY =154 and YX =415.
 * As evident from above example, X>Y but XY < YX, so the comparator function will consider Y>X
 */
public class LargestNumberPossible {
    public static void largestNumber(String[] numbers) {
        List<String> numberList = Arrays.asList(numbers);

        //sort using a custom function object
        Collections.sort(numberList, (a, b) -> (b + a).compareTo(a + b));

        numberList.stream().forEach(System.out::print);
    }
}
