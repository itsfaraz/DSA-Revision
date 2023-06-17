package dsa.leetcode.arrays;

import java.util.Arrays;

public class TwoSumII {


    public static void main(String[] args) {
        int []arr = {-1,0};
        int target = -1;
        int[] result = new TwoSumII().twoSum(arr,target);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] numbers, int target) {
        int []result = new int[2];

        int start = 0;
        int end = numbers.length-1;

        while(start < end){
            int sum = numbers[start] + numbers[end];
            if (sum == target){
                result[0] = start+1;
                result[1] = end+1;
                break;
            }else if(sum > target){
                end -= 1;
            }else if (sum < target){
                start += 1;
            }
        }
        return result;
    }

}
