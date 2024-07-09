package roadmap.dsa.leetcode.sheet.stack;

import java.util.HashMap;

public class NextGreater {



    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int idx = 0; idx <  nums2.length; idx++){
            map.put(nums2[idx],idx);
        }
        int []result = new int[nums1.length];
        for (int idx = 0; idx <  nums1.length; idx++){
            if (map.containsKey(nums1[idx])){
                int index = map.get(nums1[idx]);
                if (index+1 >= nums2.length){
                    result[idx] = -1;
                }else{
                    if (nums2[index+1] > nums1[idx]) {
                        result[idx] = nums2[index + 1];
                        continue;
                    }
                }
            }
            result[idx] = -1;

        }

        return result;
    }
}
