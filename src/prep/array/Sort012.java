package prep.array;

import java.util.Arrays;

public class Sort012 {

    public static void sortDNF(int []arr){
        int low = 0;
        int mid = low+1;
        int high = arr.length-1;
        while (mid <= high){
            if (arr[mid] == 0){
                swap(low,mid,arr);
                low++;
                mid++;
            }else if (arr[mid] == 1){
                mid++;
            }else if (arr[mid] == 2){
                swap(mid,high,arr);
                high--;
            }
        }
    }

    private static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int []arr = {0,1,1,0,2,0,2,1,2,0};
        System.out.println("Original : "+Arrays.toString(arr));
        sortDNF(arr);
        System.out.println("Sorted  : "+Arrays.toString(arr));
    }

}
