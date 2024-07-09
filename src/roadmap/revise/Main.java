package roadmap.revise;

import java.util.Arrays;

public class Main {
    public static int findOptimized(int ele,int []arr){
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            int mid = (end+start)/2;
            int curr = arr[mid];
            if (curr == ele)
                return mid;
            else if (curr >= ele){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return -1;
    }

    public static void bubbleSort(int []arr){
        for (int i = 0; i < arr.length;i++){
            for (int j = 0; j < arr.length-1; j++){
                if (arr[j+1] < arr[j]){
                    swap(j,j+1,arr);
                }
            }
        }
    }

    public static void swap(int a,int b, int []arr){
        int c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

    public static void main(String[] args) {
        int []arr = {0,6,3,5};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(findOptimized(6,arr));
    }
}
