package com.github.xdshent.algorithm.array;

/**
 * Maximum profit earned by buying and selling shares
 * any number of items
 * Given a list containing future prediction of share
 * price, find maximum profit that can be earned by
 * buying and selling shares any number of times with
 * constraint that a new transaction can only start
 * after previous transaction is complete. i.e. we can
 * only hold at most one share at a time.
 * <p>
 * For example:
 * rate[]: {1,5,2,3,7,6,4,5}
 * Total profit earned is 10
 * <p>
 * Buy on day 1 and sell on day 2
 * Buy on day 3 and sell on day 5
 * Buy on day 7 and sell on day 8
 * <p>
 * The idea is very simple. We traverse the given list
 * of prices and find local minimum of every increasing
 * sequence. For example, in the array {1,5,2,3,7,6,4,5},
 * below are three increasing sequences of length 2 or
 * more.
 * <p>
 * {1,5}
 * {2,3,7}
 * {4,5}
 * <p>
 * The locale minimum of each sequence is 1,2 and 4
 * respectively. We can gain maximum profit if we buy
 * the shares at the starting of every increasing
 * sequence and sell them at the end of the increasing
 * sequence(local maximum)
 */
public class MaximumProfit {
    /**
     * @param rate
     * @return
     */
    public static int maxProfit(int[] rate) {
        //store maximum profit gained
        int profit = 0;

        //initialize local minimum to first element's index
        int j = 0;

        for (int i = 1; i < rate.length; i++) {
            //update local minimum if decreasing sequence is found
            if (rate[i - 1] > rate[i]) {
                j = i;
            }

            //sell shares if current element is peak
            //previous < current > next
            if (rate[i - 1] < rate[i] && (i + 1 == rate.length || rate[i] > rate[i + 1])) {
                profit += (rate[i] - rate[j]);
                System.out.printf("Buy on day %d and sell on day %d\n", j + 1, i + 1);
            }
        }
        return profit;
    }
}
