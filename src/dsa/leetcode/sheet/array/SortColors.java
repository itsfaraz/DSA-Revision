package dsa.leetcode.sheet.array;

import java.util.Arrays;

public class SortColors {
    /*
        Dutch National Flag
        All algorithm depends on mid value

        arr[mid] = 0 -> swap(mid,low) then mid++ and low++
        arr[mid] = 1 -> mid++
        arr[mid] = 2 -> swap(mid,high) then high--
     */

    public static void main(String[] args) {
        int []nums = {0,0,1,1,1,1,1,2,0,0,0,2};
        System.out.println(Arrays.toString(nums));
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }
    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while (mid <= high){
            int condition = nums[mid];
            if (condition == 0){
                swapPointer(low,mid,nums);
                low++;
                mid++;
            }else if (condition == 1){
                mid++;
            }else if (condition == 2){
                swapPointer(mid,high,nums);
                high--;
            }
        }
    }

    public static void swapPointer(int first,int second,int[]arr){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
