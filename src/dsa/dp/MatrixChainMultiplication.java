package dsa.dp;

public class MatrixChainMultiplication {

    public static void main(String[] args) {

        int []arr = {4,2,3,5,1};
        System.out.println(MCMRecursion(arr,0, arr.length-1));
        System.out.println(MCMRecursion(arr));
    }


    public static int MCMRecursion(int []arr,int si,int ei){

        if (si+1 == ei)
            return 0;

        int min = Integer.MAX_VALUE;
        for (int k = si+1; k <= ei-1;k++){
            int fp = MCMRecursion(arr,si,k);
            int sp = MCMRecursion(arr,k,ei);

            int sw = arr[si] * arr[ei] * arr[k];
            int total = fp+sp+sw;
            min = Math.min(min,total);
        }
        return min;
    }


    // Bottom Up
    public static int MCMRecursion(int []arr){

        int n = arr.length;
        int [][]storage = new int [n][n];

        for (int slide = 1; slide <= n-1;slide++){
            for (int si = 0; si <= n-slide-1;si++){
                int ei = si+slide;
                if (si+1 == ei){
                    storage[si][ei] = 0;
                }else{
                    int min = Integer.MAX_VALUE;
                    for (int k = si+1; k <= ei-1;k++){
                        int fp = storage[si][k];
                        int sp = storage[k][ei];

                        int sw = arr[si] * arr[ei] * arr[k];
                        int total = fp+sp+sw;
                        min = Math.min(min,total);
                    }
                    storage[si][ei] = min;
                }
            }
        }
        return storage[0][n-1];
    }

}
