package dsa.dp;

public class BinaryKnapsack {
    // 0-1 Knapsack

    public static void main(String[] args) {
        int []weight = {1,3,4,5};
        int []prices = {1,4,5,7};
        int capacity = 7;
//        int []weight = new int[100000];
//        int []prices = new int [100000];
//        for (int i = 0; i < weight.length; i++){
//            weight[i] = i+1;
//            prices[i] = i+1;
//        }
//        int capacity = 1000;
//        System.out.println(new BinaryKnapsack().knapsack(prices,weight,capacity,0));
        System.out.println(new BinaryKnapsack().knapsackA2(prices,weight,capacity,0,new int[prices.length][capacity+1]));
        System.out.println(new BinaryKnapsack().knapsackA3(prices,weight,capacity));
    }

    public int knapsack(int []prices,int []weight,int capacity,int vidx){
        if (vidx == prices.length)
            return 0;

        if (capacity - weight[vidx] < 0)
            return 0;


        // include
        int result1 = knapsack(prices, weight,capacity - weight[vidx], vidx + 1) + prices[vidx];
        // exclude
        int result2 = knapsack(prices,weight,capacity,vidx+1);
        int max = Math.max(result1,result2) ;

        return max;
    }


    // Top Down
    public int knapsackA2(int []prices,int []weight,int capacity,int vidx,int [][]storage){
        if (vidx == prices.length)
            return 0;

        if (capacity - weight[vidx] < 0)
            return 0;

        if (storage[vidx][capacity] != 0)
            return storage[vidx][capacity];

        // include
        int result1 = knapsackA2(prices, weight,capacity - weight[vidx], vidx + 1,storage) + prices[vidx];
        // exclude
        int result2 = knapsackA2(prices,weight,capacity,vidx+1,storage);
        int max = Math.max(result1,result2) ;
        storage[vidx][capacity] = max;

        return max;
    }

    // Bottom Up
    public int knapsackA3(int []prices,int []weight,int capacity){
        int [][]storage = new int [weight.length+1][capacity+1];

        for (int row = weight.length-1; row >= 0; row--){
            for (int col = 1; col <= capacity; col++){

                // include
                int exclude = storage[row+1][col];
                int include = 0;
                if (col > weight[row])
                    include = storage[row+1][col-weight[row]] + prices[row];
                storage[row][col] = Math.max(include,exclude);

            }
        }
        return storage[0][capacity];
    }

}
