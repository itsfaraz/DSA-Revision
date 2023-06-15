package dsa.leetcode.arrays;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int []nums){

        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int start = 0; start < nums.length-2;start++){
            int middle = start+1;
            int end = nums.length-1;
            while (middle > start && middle < end){
                int sum = nums[start] + nums[middle] + nums[end];
                if (sum == 0){
                    ArrayList triplets = new ArrayList();
                    triplets.add(nums[start]);
                    triplets.add(nums[middle]);
                    triplets.add(nums[end]);
                    result.add(triplets);
                    middle++;
                }else if (sum < 0) {
                    middle++;
                }
                else if (sum > 0) {
                    end--;
                }
            }
        }

        return toList(result);
    }

    private List<List<Integer>> toList(Set<List<Integer>> result) {
        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> data : result){
            list.add(data);
        }
        return list;
    }

}
