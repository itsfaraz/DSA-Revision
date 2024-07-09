package roadmap.dsa.leetcode.strings;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
       int[] nums = {9,10,9,-7,-4,-8,2,-6};
       int k = 5;
       System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindowV1(nums,k)));
    }
    // TC : O(n) // failed for dulicate numbers
    public int[] maxSlidingWindowV1(int[] nums, int k) {
        if (nums.length == 0 || nums.length == 1)
            return nums;

        int result[] = new int[(nums.length-k)+1];
        int resultIdx = 0;

        int left = 0;
        int right = 0;
        int n = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        while (left < n && right < n){
            int window = (right-left)+1;
            maxHeap.add(nums[right]);
            if (window < k){
                right++;
            }else if (window == k){
                if (k == 1){
                    result[resultIdx] = maxHeap.peek();
                    maxHeap.poll();
                    left++;
                    resultIdx++;
                }else{
                    result[resultIdx] = maxHeap.peek();

                    if (nums[left] == maxHeap.peek())
                        maxHeap.poll();
                    left++;
                    resultIdx++;
                }
                right++;
            }
        }
        return result;
    }


    // TC : O(n*k) // TLE
    public int[] maxSlidingWindowV2(int[] nums, int k){
        if (nums.length == 0 || nums.length == 1)
            return nums;

        int result[] = new int[(nums.length-k)+1];
        int resultIdx = 0;
        for (int i = 0; i <= nums.length - k;i++){
            int max = nums[i];
            for (int j = 1; j < k; j++){
                max = Math.max(max,nums[i+j]);
            }
            result[resultIdx] = max;
            resultIdx++;
        }
        return result;
    }

    public int[ ]maxSlidingWindow(int[] nums, int k){
        if (nums.length == 0 || nums.length == 1)
            return nums;
        int result[] = new int[(nums.length-k)+1];
        int resultIdx = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int left = 0;
        int right = 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        while (left < n && right < n){
            int window = (right-left)+1;
            max = Math.max(nums[right],max);
            if (window < k){
                while (!deque.isEmpty() && deque.peek() < max){
                    deque.poll();
                }
                deque.add(max);
                right++;
            }else if (window == k){
                result[resultIdx] = deque.peek();
                if (!deque.isEmpty()){
                    if (nums[left] == deque.peek()){
                        int oldPeek = deque.poll();
                        if (!deque.isEmpty() && max == oldPeek){
                            max = deque.peek();
                        }
                    }
                }
                right++;
                left++;
                resultIdx++;
            }

        }

        return result;
    }
}
