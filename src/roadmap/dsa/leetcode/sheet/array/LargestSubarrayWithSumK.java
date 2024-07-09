package roadmap.dsa.leetcode.sheet.array;

import java.util.HashMap;

public class LargestSubarrayWithSumK {

    public static void main(String[] args) {
        int []arr =  {10, 5, 2, 7, 1, 9};
        int k = 15;
        printLongestSubarrayWithSumK(arr,k);
//        System.out.println(subarraySum(arr,k));
    }


    // Return total number of sub array whose some equal to k
    public static int subarraySum(int []arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int sum = 0;
        for (int idx = 0; idx < arr.length; idx++){
            sum += arr[idx];

            if (map.containsKey(sum - k)){
                int freq = map.get(sum-k);
                count += freq;
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static void printLongestSubarrayWithSumK(int []arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int startIdx = 0;
        int endIdx = -1;
        int sum = 0;
        map.put(0,0);
        for (int idx = 0; idx < arr.length; idx++){
            sum += arr[idx];
            if (map.containsKey(sum - k)){
                int index = map.get(sum - k )+1;
                int size = (idx - index)+1;
                if (size > max){
                    max = size;
                    startIdx = index-1;
                    endIdx = idx;
                }
            }
            if (!map.containsKey(sum)){
                map.put(sum,idx+1);
            }
        }
        if (endIdx == -1)
            return;
        for (int idx = startIdx; idx <= endIdx; idx++){
            System.out.print(arr[idx]+" ");
        }
        System.out.println();
    }

}
