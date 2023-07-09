package dsa.divideandconquer;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {80,10,50,30,60,20,70,25};
        System.out.println(Arrays.toString(mergeSort(arr,0,arr.length-1)));
    }

    public static int[] mergeSort(int []arr,int low,int high){
        if (low == high){
            return new int[]{arr[low]};
        }
        int mid = low+((high-low)/2);
        int []firstHalf = mergeSort(arr,low,mid);
        int []secondHalf = mergeSort(arr,mid+1,high);
        return new MergeSortedArrays().mergeArrays(firstHalf,secondHalf);
    }

}
