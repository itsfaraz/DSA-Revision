package dsa.leetcode.arrays;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int []nums1 = {-1,0,0,3,3,3,0,0,0};
        int m = 4;
        int []nums2 = {1,2,2};
        int n = 3;
        new MergeSortedArray().merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));

    }
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int first = 0;
        int second = 0;
        int idx = 0;
        int []result = new int[m + n];
        while (first < nums1.length && second < nums2.length){
            if (nums1[first] <= nums2[second] && nums1[first] != 0){
                result[idx] = nums1[first];
                first++;
                idx++;
            }else if (nums1[first] == 0){
                first++;
            } else if (nums2[second] <= nums1[first] && nums2[second] != 0){
                result[idx] = nums2[second];
                second++;
                idx++;
            }else {
                second++;
            }
        }
        mergeRest(nums1,first,result,idx);
        mergeRest(nums2,second,result,idx);
        for(int i = 0; i < result.length;i++){
            nums1[i] = result[i];
        }
    }

    public void mergeRest(int []arr,int idx,int []result,int resultIdx){
        while(idx < arr.length){
            if (arr[idx] != 0){
                result[resultIdx] = arr[idx];
                resultIdx++;
            }
            idx++;
        }
    }
}
