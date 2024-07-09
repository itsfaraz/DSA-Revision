package prep.array;

public class MajorityElementNBy2 {

    public int majorityElement(int []nums){
        int count = 0;
        int element = nums[0];
        int n = nums.length;
        for (int idx =0; idx < nums.length; idx++){
            if (count == 0){
                count = 1;
                element = nums[idx];
            }else if (element == nums[idx]){
                count++;
            }else{
                count--;
            }
        }
        count = 0;
        for (int ele : nums){
            if (ele == element)
                count++;
        }
        if (count > n/2) return element;
        return -1;
    }

}
