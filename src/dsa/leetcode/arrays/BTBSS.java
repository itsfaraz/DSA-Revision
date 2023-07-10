package dsa.leetcode.arrays;

// Best Time To Buy And Sell Stocks
public class BTBSS {

    public static void main(String[] args) {
        int []prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++){
            min = Math.min(prices[i],min);
            profit = Math.max(profit,prices[i]-min);
        }
        return profit;
    }

}
