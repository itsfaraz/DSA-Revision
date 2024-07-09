package roadmap.dsa.leetcode.arrays;

public class BarGraph {

    public void print(int []arr){

        int max = findMax(arr);
        for (int row = 0; row < max; row++){
            for (int col = 0; col < arr.length; col++){
                if (max - row <= arr[col]){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    private int findMax(int []arr){
        int max = Integer.MIN_VALUE;
        for(int i =0; i < arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }

}
