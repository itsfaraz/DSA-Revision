package dsa.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public int[] getSum(int[]arr,int target){
        if(arr.length == 2){
            return new int[]{0,1};
        }
        int start = 0;
        int end = arr.length-1;
        HashMap<Integer,Integer> map = getIndexes(arr);
        Arrays.sort(arr);
        int []result = new int[2];
        while (start < end){
            int sum = arr[start] + arr[end];
            if (sum == target){
               result[0] = map.get(arr[start]);
               result[1] = map.get(arr[end]);
               return result;
            }else if (sum > target){
                end--;
            }else if (sum < target)
                start++;
        }
        return new int []{0,1};
    }

    private HashMap<Integer, Integer> getIndexes(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0; i < arr.length;i++){
            map.put(arr[i],i);
        }
        return map;
    }

}
