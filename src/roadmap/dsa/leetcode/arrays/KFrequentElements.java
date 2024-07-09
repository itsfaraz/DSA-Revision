package roadmap.dsa.leetcode.arrays;

import java.util.*;

public class KFrequentElements {

    public static void main(String[] args) {
        int []nums = {4,3,3,3,2,2,1,4,5,4};
        int k = 3;
        System.out.println(Arrays.toString(new KFrequentElements().topKFrequent(nums,k)));
    }

    private class Pair{
        private Integer first;
        private Integer second;
        public Pair(Integer first,Integer second){
            this.first = first;
            this.second = second;
        }

        public Integer getFirst(){
            return this.first;
        }

        public Integer getSecond(){
            return this.second;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx++){
            int no = nums[idx];
            map.put(no,map.getOrDefault(no,0)+1);
        }

        Iterator<Integer> iterator = map.keySet().iterator();

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> b.second - a.second);
        while (iterator.hasNext()){
            int key = iterator.next();
            maxHeap.add(new Pair(key,map.get(key)));
        }
        int idx = 0;
        int []result = new int[k];
        while (idx < k){
            if (!maxHeap.isEmpty())
                result[idx] = maxHeap.poll().first;
            idx++;
        }


        return result;
    }

}
