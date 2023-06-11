package dsa.arrays.slidingwindow.fixed;

public class MaximumKSubarraySum {

    /*
        Find the maximum sum of sub-array of size k
        ex :
        arr = 2 5 1 8 2 9
        k = 3
        possible k size subarray
        2 5 1 = 8
        5 1 8 = 14
        1 8 2 = 11
        8 2 9 = 19
        Maximum Sub-array is : 19
     */

    // Navie approach
    public int findSumV1(int []arr,int k){
        int result = -1;
        for(int i = 0; i < arr.length-k;i++){
            int sum = 0;
            for(int j = i; j < i+k; j++){
                sum += arr[j];
            }
            if (sum > result){
                result = sum;
            }
        }
        return result;
    }

    // Final Approach
    // Always try to minimize redundant work we are doing in navie approach
    public int findSumV2(int []arr,int k){
        int i = 0;
        int j = 0;
        int result = 0;
        int sum = 0;
        while(j < arr.length){
            int windowSize = (j-i)+1;
            sum += arr[j];
            if (windowSize < k){
                j++;
            }else if(windowSize == k){
                result = Math.max(result,sum);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return result;
    }

}
