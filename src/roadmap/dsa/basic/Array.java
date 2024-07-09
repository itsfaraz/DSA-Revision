package roadmap.dsa.basic;

import java.util.Arrays;

public class Array {

    public void subarrayPrint(int []arr){
        for (int start = 0; start < arr.length; start++){
            for(int end = start; end < arr.length; end++){
                for (int printIdx = start; printIdx <= end;printIdx++){
                    System.out.print(arr[printIdx]+" ");
                }
                System.out.println();
            }
            System.out.println("--------------------------------------------------");
        }
    }

    public void subarraySumPrint(int []arr){
        for (int start = 0; start < arr.length; start++){
            int sum = 0;
            for(int end = start; end < arr.length; end++){
                sum += arr[end];
                System.out.print(sum+" ");
            }
        }
        System.out.println();
    }

    public int subarrayMaxSum(int []arr){
        int max = Integer.MIN_VALUE;
        for (int start = 0; start < arr.length; start++){
            int sum = 0;
            for(int end = start; end < arr.length; end++){
                sum += arr[end];
                max = Math.max(sum,max);
            }
        }

        return max;
    }

    public int kadaneAlgorithm(int []arr){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int idx = 0; idx < arr.length; idx++){
            sum = Math.max(arr[idx],sum+arr[idx]);
            max = Math.max(max,sum);
        }
        return max;
    }

    public void printMaximumSubarray(int []arr){
        int sum = arr[0];
        int max = sum;
        int endIdx = 0;
        int []start = new int[arr.length];
        start[0] = 0;
        for (int idx =1; idx < arr.length; idx++){

             if (arr[idx]+sum > arr[idx]){
                 start[idx] = start[idx-1];
                 sum = arr[idx]+sum;
             }else{
                 start[idx] = idx;
                 sum = arr[idx];
             }

             if (sum > max){
                 max = sum;
                 endIdx = idx;
             }
        }

        int startIdx = start[endIdx];
        for (int idx = startIdx; idx <= endIdx;idx++){
            System.out.print(arr[idx]+" ");
        }
        System.out.println();
    }

    public int circularMaximumSubArraySum(int []arr){
        Arrays.sort(arr);
        int kadaneMax = kadaneAlgorithm(arr);
        int endIdx = getArrayMaxIdx(arr);
        invertArray(arr);
        int ignoreIdx = getArrayMaxIdx(arr);
        invertArray(arr);
        System.out.println("0 -- "+ignoreIdx+" -- "+endIdx);
        return Math.max(kadaneMax,getCircularMax(ignoreIdx,endIdx,arr));
    }

    private int getCircularMax(int ignoreIdx, int endIdx, int[] arr) {
        int sum = 0;
        for (int i = 0; i < ignoreIdx; i++) {
            sum += arr[i];
        }

        for (int i = endIdx; i < arr.length;i++) {
            sum += arr[i];
        }
        return sum;
    }

    private void invertArray(int[] arr) {
        for (int i =0; i < arr.length;i++){
            arr[i] = -arr[i];
        }
    }

    private int getArrayMaxIdx(int[] arr) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int idx= 0; idx < arr.length;idx++){
            if (arr[idx] >= max) {
                max = arr[idx];
                index = idx;
            }
        }
        return index;
    }

    public void waveDisplay(int [][]arr){
        for (int col = 0; col < arr.length; col++){
            if (col%2 == 0){
                for (int rowIdx = 0; rowIdx < arr.length; rowIdx++){
                    System.out.print(arr[rowIdx][col]+" ");
                }
            }else{
                for (int rowIdx = arr.length-1; rowIdx >= 0;rowIdx--){
                    System.out.print(arr[rowIdx][col]+" ");
                }
            }
        }
    }

    public void spiralDisplay(int [][]arr){
        int colStart = 0;
        int rowStart = 0;



        int balancer = 0;
        while (rowStart < arr.length && colStart < arr[0].length){
            for (int rowIdx = rowStart; rowIdx < arr.length-balancer; rowIdx++){
                System.out.print(arr[rowIdx][colStart]+" ");
                rowStart++;
            }
            rowStart--;
            colStart++;
            for (int colIdx = colStart; colIdx < arr[0].length-balancer;colIdx++){
                System.out.print(arr[rowStart][colIdx]+" ");
                colStart++;

            }
            colStart--;
            rowStart--;
            for (int rowIdx = rowStart; rowIdx >= balancer; rowIdx--){
                System.out.print(arr[rowIdx][colStart]+" ");
                rowStart--;

            }
            rowStart++;
            balancer++;
            colStart--;
            for (int colIdx = colStart; colIdx >= balancer; colIdx--){
                System.out.print(arr[rowStart][colIdx]+" ");
                colStart--;

            }
            rowStart = balancer;
        }

    }
}
