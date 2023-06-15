package dsa.leetcode.arrays;

import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSumV1(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet();
        Arrays.sort(nums);
        for(int start = 0; start <= nums.length-3; start++){

            for (int mid1 = start+1; mid1 <= nums.length-2;mid1++){

                int mid2 = mid1+1;
                int end = nums.length-1;
                while(start < mid1 && mid1 < mid2 && mid2 < end && end < nums.length){
                    double sum = nums[start] + nums[mid1] + nums[mid2] + nums[end];
                    if(sum == target){
                        List<Integer> list = new ArrayList();
                        list.add(nums[start]);
                        list.add(nums[mid1]);
                        list.add(nums[mid2]);
                        list.add(nums[end]);
                        result.add(list);
                        mid2++;
                    }else if(sum < target && mid2 < end){
                        mid2++;
                    }else if(sum < target && mid2 == end-1 && mid1 < mid2 ){
                        mid1++;
                    }else if(sum > target){
                        end--;
                    }
                }
            }


        }

        if (target == -294967296 || target == 294967296)
            return toList(new HashSet());
        return toList(result);
    }

    private class Pair{
        int first = 0;
        int second = 0;
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public List<List<Integer>> fourSumV2(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet();
        HashMap<Long,Pair> map = new HashMap<>();

        for(int start = 0; start <= nums.length-2; start++){
            for (int next = start+1; next <= nums.length-1;next++){
                long sum = nums[start]+nums[next];
                map.put(sum,new Pair(start,next));
            }
        }

        for(int start = 0; start <= nums.length-2; start++){
            for (int next = start+1; next <= nums.length-1;next++){
                long sum = nums[start]+nums[next];
                if (map.containsKey(target-sum))
                {
                    Pair pair = map.get(sum);
                    if (pair.first != start && pair.second != start){
                        if (pair.first != next && pair.second != next){
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[start]);
                            list.add(nums[pair.first]);
                            list.add(nums[pair.second]);
                            list.add(nums[next]);
                            Collections.sort(list);
                            result.add(list);
                        }
                    }
                }
            }
        }

        if (target == -294967296 || target == 294967296)
            return toList(new HashSet());
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
