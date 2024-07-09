package prep.slidingwindow.fixed;

public class MaximumSumSubArrayK {

    public int maximumSumSubArrayK(int []arr,int k){
        int result = 0;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < arr.length){
            int checkCondition = (j - i) + 1;
            sum += arr[j];
            if (checkCondition < k){
                j++;
            }else if (checkCondition == k){
                result = Math.max(result,sum);
                sum -= arr[i];
                i++;
                j++;
            }

        }

        return result;
    }

}
