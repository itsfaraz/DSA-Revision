package revise.standard.array;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int []arr = {12,31,25,8,32,17,40,42};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(mergeSort(arr,0,arr.length-1)));
    }

    public static int[] mergeSort(int []arr,int start,int end){
        if (start == end){
            return new int[]{arr[start]};
        }
        int mid = (start+end)/2;
        int []firstHalf = mergeSort(arr,start,mid);
        int []secondHalf = mergeSort(arr,mid+1,end);
        return mergeSorted(firstHalf,secondHalf);
    }

    public static int[] mergeSorted(int []arr1,int []arr2){
        int[] arr = new int [arr1.length + arr2.length];
        int i =0;
        int j =0;
        int curr = 0;
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] >= arr2[j]){
                arr[curr] = arr2[j];
                j++;
                curr++;
            }else{
                arr[curr] = arr1[i];
                i++;
                curr++;
            }
        }
        while (i < arr1.length){
            arr[curr] = arr1[i];
            i++;
            curr++;
        }
        while (j < arr2.length){
            arr[curr] = arr2[j];
            j++;
            curr++;
        }
        return arr;
    }

}
