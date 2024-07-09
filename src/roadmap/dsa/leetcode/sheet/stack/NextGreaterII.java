package roadmap.dsa.leetcode.sheet.stack;

import java.util.Collections;
import java.util.Stack;

public class NextGreaterII {

    public static void main(String[] args) {
        int []input = {2,10,12,1,11};
        Stack<Integer> stck = new Stack();
        for (int val : input)
            stck.push(val);
        Collections.sort(stck);
        System.out.println(stck);
//        System.out.println(Arrays.toString(nextGreaterElements(input)));

    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack();
        int []result = new int[nums.length];
        stack.push(nums[nums.length-1]);
        for (int idx = (nums.length*2)-1; idx >= 0; idx--){
            int value = -1;
            while (!stack.isEmpty()){
                if (stack.peek() > nums[idx % nums.length]){
                    value = stack.peek();
                    break;
                }else{
                    stack.pop();
                }
            }
            stack.push(nums[idx%nums.length]);
            if (idx < nums.length){
                result[idx] = value;
            }
        }
        return result;
    }

}
