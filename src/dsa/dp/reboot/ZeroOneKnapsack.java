package dsa.dp.reboot;

public class ZeroOneKnapsack {

    public static void main(String[] args) {
        int[] weight = {1,3,4,5};//1,31,31,43,11,12,5,9,16,18,00,1,3,4,5,1,31,31,43,11,12,5,9,16,18,001,3,4,5,1,31,31,43,11,12,5,9,16,18,00,1,3,4,5,1,31,31,43,11,12,5,9,16,18};
        int[] price = {1,4,5,7};//32,121,53,53,12,454,65,01,12,98,00,1,3,4,5,1,31,31,43,11,12,5,9,16,18,00,1,4,5,7,32,121,53,53,12,454,65,01,12,98,00,1,3,4,5,1,31,31,43,11,12,5,9,16,18};
        int cap = 7;
        int [][]storage = new int[weight.length][cap+1];
//        int result = knapsack(weight,price,cap,0);
//        int result = knapsackV2(weight,price,cap,0,storage);
//        System.out.println(storage);
//        System.out.println(result);
    }

    public static int knapsack(int []weight,int []price,int capacity,int vidx){
        if (vidx == weight.length)
            return 0;

        if(capacity - weight[vidx] < 0)
            return 0;


        // include
        int value1 = knapsack(weight, price, capacity-weight[vidx], vidx+1) + price[vidx];
        // exclude
        int value2 = knapsack(weight, price, capacity, vidx+1);

        return Math.max(value1,value2) ;
    }

    public static int knapsackV2(int []weight,int []price,int capacity,int vidx,int[][]storage){
        if (vidx == weight.length)
            return 0;

        if(capacity - weight[vidx] < 0)
            return 0;

        if (storage[vidx][capacity] != 0)
            return storage[vidx][capacity];

        // include
        int value1 = knapsackV2(weight, price, capacity-weight[vidx], vidx+1,storage) + price[vidx];
        // exclude
        int value2 = knapsackV2(weight, price, capacity, vidx+1,storage);
        storage[vidx][capacity] = Math.max(value1,value2);
        return storage[vidx][capacity];
    }

//    public static int knapsackV3(int []weight,int []price,int capacity,int vidx){
//        int [][]storage = new int[vidx][capacity];
//
//    }

}
