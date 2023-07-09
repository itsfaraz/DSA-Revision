package dsa.divideandconquer;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int []arr = {50,40,80,90,70,10,30,60,120};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int []arr,int low,int high){
        if (low >= high)
            return;

        int pivot = arr[low + ((high-low)/2)];
        int left = low;
        int right = high;
        while (left <= right){
            if (arr[left] < pivot){
                left++;
            }else if (arr[right] > pivot){
                right--;
            }else {
                // problem
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        // left
        quickSort(arr,low,right);
        // right
        quickSort(arr,left,high);
    }

}
