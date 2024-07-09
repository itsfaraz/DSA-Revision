package roadmap.dsa.dp;

public class Knapsack {

    public static void main(String[] args) {

        int []weight = {1,3,4,5};
        int []value = {1,4,5,6};
        int capacity = 7;
        int maxProfit = zeroOneRecursive(weight,value,0,capacity,0,0);
        System.out.println(maxProfit);
        System.out.println(Knapsack.maxProfit);

    }
    private static int maxProfit = 0;
    public static int zeroOneRecursive(int []weight,int []value,int vidx,int capacity,int currentCapacity,int total){
        if (vidx > value.length || currentCapacity > capacity){
            return 0;
        }


        if (vidx == value.length && currentCapacity <= capacity)
        {
            if (total > maxProfit)
                maxProfit = total;
            return total;
        }

//        Yes
        int result1 = zeroOneRecursive(weight, value, vidx+1, capacity, currentCapacity+weight[vidx], total+value[vidx]);
//        No
        int result2 = zeroOneRecursive(weight, value, vidx+1, capacity, currentCapacity, total);

        return Math.max(result1,result2);
    }

}
