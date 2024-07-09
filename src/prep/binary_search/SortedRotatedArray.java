package prep.binary_search;

public class SortedRotatedArray {

    public int rotatedSortedList(int []nums){
        int left = 0;
        int right = nums.length-1;
        int result = Integer.MAX_VALUE;
        while (left <= right){
            int mid = left + (right-left)/2;
            int midValue = nums[mid];
            result = Math.min(result,nums[mid]);
            if (midValue >= nums[left]){
                result = Math.min(result,nums[left]);
                left = mid+1;
            }else{
                result = Math.min(result,nums[right]);
                right = mid-1;
            }
        }
        return result;
    }

}
