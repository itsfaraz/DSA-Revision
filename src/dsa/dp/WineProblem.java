package dsa.dp;

public class WineProblem {

    public static void main(String[] args) {

        int []prices = {1,4,3,2,5};
        int si = 0;
        int ei = prices.length-1;
        System.out.println(maxProfit(prices,si,ei,1));

        System.out.println(maxProfitV2(prices,0,prices.length-1,1,new int[prices.length][prices.length]));

    }

    public static int maxProfit(int []prices,int si,int ei,int year){

        if (si == ei){
            return prices[si]*year;
        }


        // leftmost
        int profit1 = maxProfit(prices,si+1,ei,year+1) + prices[si] * year ;
        // rightmost
        int profit2 = maxProfit(prices,si,ei-1,year+1) + prices[ei] * year;

        int result = Math.max(profit1,profit2);

        return result;
    }

    // Top Down
    public static int maxProfitV2(int []prices,int si,int ei,int year,int [][]storage){

        if (si == ei){
            return prices[si]*year;
        }

        if (storage[si][ei] != 0)
            return storage[si][ei];

        // leftmost
        int profit1 = maxProfitV2(prices,si+1,ei,year+1,storage) + prices[si] * year ;
        // rightmost
        int profit2 = maxProfitV2(prices,si,ei-1,year+1,storage) + prices[ei] * year;

        int result = Math.max(profit1,profit2);
        storage[si][ei] = result;
        return result;
    }

}
