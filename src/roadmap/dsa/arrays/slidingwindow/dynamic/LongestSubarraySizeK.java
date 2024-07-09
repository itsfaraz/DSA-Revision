package roadmap.dsa.arrays.slidingwindow.dynamic;

public class LongestSubarraySizeK {

    /*
        Given array, We need to return longest subarray of sum k
        arr = [4,1,1,2,3,5]
        k = 5

        possible sub-roadmap.dsa.arrays :       size
        4 1                          = 2
        1 1 1 2                      = 4
        2 3                          = 2
        5                            = 1

        max = 4

     */


    public int subArrayOfSizeK(int []arr,int k){
        int i = 0;
        int j = 0;
        int sum = 0;
        int max = 0;
        while(j < arr.length && i < arr.length){

            sum += arr[j];
            if (sum < k)
                j++;
            else if (sum == k){
                max = Math.max(max,j-i+1);
                j++;
            }else if(sum > k){
                while (sum >= k){
                    sum = sum - arr[i];
                    i++;
                }
                j++;

            }
        }
        return max;
    }

}
