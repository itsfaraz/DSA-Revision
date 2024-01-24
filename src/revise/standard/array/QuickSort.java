package revise.standard.array;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int []arr,int low,int high){
        if (low >= high)
            return;

        int mid = (low+high)/2;
        int pivot = arr[mid];
        int left = low;
        int right = high;

        while (left <= right){
            while (pivot > arr[left]) {
                left++;
            }
            while (pivot < arr[right]) {
                right--;
            }
            if (left <= right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        quickSort(arr,low,right);
        quickSort(arr,left,high);
    }

    public static void main(String[] args) {

//        int []arr= {40,20,90,30,70,10,80,60,50};
        int []arr= {12,31,25,8,32,17,40,42};
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

}
