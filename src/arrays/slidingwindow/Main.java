package arrays.slidingwindow;

import arrays.slidingwindow.fixed.AnagramOccurrences;
import arrays.slidingwindow.fixed.MaximumAllKSubarray;
import arrays.slidingwindow.fixed.MaximumKSubarraySum;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        MaximumKSubarraySum sum = new MaximumKSubarraySum();
        int ans1 = sum.findSumV2(new int[]{2,5,1,8,2,9,1},3);
        System.out.println("Maximum sum of size k subarray V2 : "+ans1);


        // First Negative Integer
//        FirstNegativeInteger print = new FirstNegativeInteger();
//        System.out.println("First Negative Integer");
//        print.printFirstNegativeV1(new int[]{12,-1,-7,8,-15,30,13,28,30},4);
//        print.printFirstNegativeV2(new int[]{12,-1,-7,8,-15,30,13,28,30},4);

        // Count Occurrences of Anagram
        AnagramOccurrences anagram = new AnagramOccurrences();
        List<Integer> list = anagram.countAnagramOccurrences("baa","aa");
        System.out.println("Anagram Occurrences : "+list.size());

        // Print maximum of all sub-array of size k
        MaximumAllKSubarray allKSubarray = new MaximumAllKSubarray();
        System.out.println("Print maximum of all sub-array of size k");
        int []arr = {5,4,2,1,6};
        arr = new int[]{1,3,-1,-3,5,3,6,7};
        arr = new int[]{1,3,1,2,0,5};
        arr = new int[]{1,-1};
        arr = new int[]{9,10,9,-7,-4,-8,2,-6};
        int k = 5;

        allKSubarray.printKAllMaximumV1(arr,k);
        allKSubarray.printKAllMaximumV2(arr,k);
        allKSubarray.printKAllMaximumV3(arr,k);

    }
}
