package roadmap.dsa.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    public static void main(String[] args) {

//        int []prices = {100,80,60,70,60,75,85};
        int []prices = {31,41,48,59,79};


//        stockSpanA1(prices);
        StockSpanner stockSpanner = new StockSpanner();
        for (int price : prices){
            System.out.print(stockSpanner.next(price)+" ");
        }

    }


    // Brute Force
    public static void stockSpanA1(int []stockPrice){
        int n = stockPrice.length;
        int []result = new int[n];
        result[0] = 1;
        for (int idx =1; idx < n; idx++){
            int count = 1;
            for (int j = idx-1; j >= 0; j--){
                if (stockPrice[j] > stockPrice[idx])
                    break;
                count++;
            }
            result[idx] = count;
        }
        System.out.println(Arrays.toString(result));
    }



    private static class StockSpanner{
        private static class Pair{
            int first;
            int second;
            public Pair(int first,int second){
                this.first = first;
                this.second = second;
            }
        }
        private Stack<Pair> stack;
        private ArrayList<Integer> list;
        private ArrayList<Integer> result;
        private int idx;
        public StockSpanner() {
            stack = new Stack<>();
            list = new ArrayList<>();
            result = new ArrayList<>();
            idx = 0;
        }

        public int next(int price) {
            return stockSpanValue(price);
        }

        private int stockSpanValue(int price){
            list.add(price);

            while (idx < list.size()){
                if (stack.isEmpty()){
                    result.add(-1);
                    stack.push(new Pair(price,idx));
                    idx++;
                    return idx;
                }else if (stack.peek().first > list.get(idx)){
                    result.add(stack.peek().second);
                    stack.push(new Pair(list.get(idx),idx));
                    idx++;
                }else if (stack.peek().first <= list.get(idx)){
                    stack.pop();
                }
            }

            return (idx-1) - result.get(idx-1);
        }

    }



}
