package roadmap.revise.standard.array;

public class BarGraph {

    public static void plotGraph(int []arr){
        int max = Integer.MIN_VALUE;
        for (int val : arr){
            if (val > max)
                max = val;
        }

        for (int row = 0; row < max; row++){
            for (int col = 0; col < arr.length; col++){
                if (max - arr[col] <= row){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int []arr = {3,100,5,2,4};
        plotGraph(arr);
    }
}
