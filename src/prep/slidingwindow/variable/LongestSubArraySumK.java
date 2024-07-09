package prep.slidingwindow.variable;

public class LongestSubArraySumK {

    public int longestSubArraySize(int []arr,int k){

        int i = 0;
        int j = 0;
        int sum = 0;
        int maxSubArraySize = Integer.MIN_VALUE;
        while (j < arr.length){
            sum += arr[j];
            if(sum < k){
                j++;
            }else if(sum == k){
                maxSubArraySize = Math.max(maxSubArraySize,(j-i)+1);
                j++;
            }else{
                while (sum > k){
                    sum -= arr[i];
                    i++;
                }
                j++;
            }

        }
        return maxSubArraySize;
    }

}
