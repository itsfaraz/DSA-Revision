package prep.slidingwindow.fixed;

import prep.slidingwindow.variable.LongestSubStringKUnique;

public class Main {
    public static void main(String[] args) {
        int []arr = {2,3,5,2,9,7,1};
        int k = 3;
//        arr = new int[] {2, 5, 1, 8, 2 ,9};
//        MaximumSumSubArrayK maximumSumSubArrayK = new MaximumSumSubArrayK();
//        System.out.println(maximumSumSubArrayK.maximumSumSubArrayK(arr,k));
//


        arr = new int[] {12, -1, -7, 8, -15 ,30, 19, 28};
//        new FirstNegativeInteger().firstNegativeIntegers(arr,k);


//        String input = "forxxorfxdofr";
//        String key = "for";
//        AnagramOccurrence occurrence = new AnagramOccurrence();
//        int result = occurrence.anagramOccurrence(input,key);
//        System.out.println(result);


        arr = new int[] {12, -1, -7, 8, -15 ,30, 19, 28};
//        arr = new int[] {1,2,3,1,4,5,2,3,6};
//        MaximumAllKSubarray maximum = new MaximumAllKSubarray();
//        maximum.maximumKSubArray(arr,k);

        arr = new int[] {4,1,1,1,2,3,5};
        k = 5;
//        LongestSubArraySumK longestSubArraySumK = new LongestSubArraySumK();
//        int output = longestSubArraySumK.longestSubArraySize(arr,k);
//        System.out.println(output);



        String word = "pwwkew";
        k = 1;
        LongestSubStringKUnique longestSubStringKUnique = new LongestSubStringKUnique();
        int output = longestSubStringKUnique.longestSubstringKUniqueCharBrute(word,k);
        int  optOutput = longestSubStringKUnique.longestSubstringKUniqueChar(word,k);
        System.out.println(optOutput);

    }
}