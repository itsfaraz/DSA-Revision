package roadmap.dsa.leetcode.sheet.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {

    public static void main(String[] args) {
        String permutation = "125421";
        NextPermutation obj = new NextPermutation();
        System.out.println(obj.nextPermutation(permutation));

        int []nums = {3,2,1};
        obj.nextPermutationV2(nums);
        System.out.println(Arrays.toString(nums));

//        int []arr = {4,2,1,9,8,7,1,4,6};
//        Arrays.sort(arr,3,nums.length+1);
//        System.out.println(Arrays.toString(arr));
    }


    // Brute Force Approach
    /*
        * Generate all permutations
        * Search the next one
     */
    public String nextPermutation(String input){
        char []sort = input.toCharArray();
        Arrays.sort(sort);
        String question = new String(sort);
        List<String> permutations = new ArrayList<>();
        findPermutation(question,input,"",permutations);
        int index = permutations.indexOf(input);
        if (index == permutations.size()-1){
            return question;
        }
        return permutations.get(index+1);
    }

    private void findPermutation(String ques,String search,String ans,List<String> result){
        if (ques.isEmpty()){
            result.add(ans);
            return;
        }

        for (int idx = 0; idx < ques.length(); idx++){
            char c = ques.charAt(idx);
            findPermutation(ques.substring(0,idx) + ques.substring(idx+1),search,ans+c,result);
        }
    }

    public void nextPermutationV2(int []nums){

        int breakPointIndex = -1;
        for (int idx = nums.length-2; idx >= 0; idx--){
            if (nums[idx] < nums[idx+1]){
                breakPointIndex = idx;
                break;
            }
        }

        if (breakPointIndex == -1) {
            Arrays.sort(nums);
            return;
        }
        int foundedElement = nums[breakPointIndex];
        int swappedIdx = 0;
        int minValue = Integer.MAX_VALUE;
        for (int idx = nums.length-1; idx >= breakPointIndex+1; idx--){
            if (nums[idx] > foundedElement){
                if (nums[idx] < minValue){
                    minValue = nums[idx];
                    swappedIdx = idx;
                }
            }
        }
        swap(breakPointIndex,swappedIdx,nums);
        Arrays.sort(nums,breakPointIndex+1,nums.length);
    }

    public void swap(int idx1,int idx2,int []nums){
        int temp = nums[idx1];
        nums[idx1] =  nums[idx2];
        nums[idx2] = temp;
    }
}

