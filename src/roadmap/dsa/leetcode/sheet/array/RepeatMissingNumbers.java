package roadmap.dsa.leetcode.sheet.array;

public class RepeatMissingNumbers {

    public static void main(String[] args) {
        int[]arr = {4,4,3,6,2,5};
        findRepeatMissing(arr);
    }

    public static void findRepeatMissing(int []nums){
        int[] helper = new int[nums.length+1];
        for (int idx = 0; idx < nums.length; idx++){
            helper[nums[idx]] += 1;
        }

        int repeated = 0;
        int missing = 0;
        for (int idx = 1; idx < helper.length; idx++){
            if (helper[idx] > 1){
                repeated = idx;
            }
            if (helper[idx] == 0){
                missing = idx;
            }
        }
        System.out.println("Repeated "+repeated+" Missing "+missing);
    }

    public static void findRepeatingMissingV2(int []nums){
        int n = nums.length;
        int sumNo = (n*(n+1))/2;
        int arraySum = 0;
        for (int idx = 0; idx < nums.length;idx++){
            arraySum += nums[idx];
        }
        int X = arraySum - sumNo;

    }

}
