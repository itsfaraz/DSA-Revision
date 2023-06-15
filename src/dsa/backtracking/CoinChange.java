package dsa.backtracking;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange coin = new CoinChange();
        coin.printCoinChange(new int[]{2,3,5,6},10,"",0);
    }
    public void printCoinChange(int []arr,int amount,String ans,int vidx){

        if (amount == 0){
            System.out.println(ans);
            return;
        }

        if (amount < 0)
            return;

        for (int idx = 0; idx < arr.length; idx++){
            if (amount >= arr[idx] && arr[idx] >= arr[vidx]){
                printCoinChange(arr,amount-arr[idx],ans+""+arr[idx],idx);
            }
        }
    }

}
