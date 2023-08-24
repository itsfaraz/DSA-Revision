package dsa.leetcode.sheet.array;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {50,40,80,90,70,10,30,60,120};
        new QuickSort().quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /*
        Partitioning Method
        * We will consider based on pivot, we need to arrange all element which are smaller
        then pivot in left side and greater then pivot on right side
        * Once left and right will cross, We need to make recursive call to achive divide and conquer
        strategy
     */

    public void quickSort(int []arr){
        quickSort(arr,0,arr.length-1);
    }

    private void quickSort(int[]arr,int low,int high){
        if (low >= high){
            return;
        }

        // partitioning
        int left = low;
        int right = high;
        int pivot = arr[(low+high)/2];
        while (left <= right){
            while (arr[left] < pivot){
                left++;
            }
            while (arr[right] > pivot){
                right--;
            }
            if (left > right)
                break;
            swap(left,right,arr);
            left++;
            right--;
        }
        quickSort(arr,low,right);
        quickSort(arr,left,high);
    }

    private void swap(int left,int right, int []arr){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
