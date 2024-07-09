package prep.array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementNBy3 {

    public static void main(String[] args) {
        int[] data = {2,2};
        System.out.println(majorityElement(data));
    }

    public static List<Integer> majorityElement(int []nums){
        if(nums.length == 1)
        {
            return List.of(nums[0]);
        }
        int count1 = 0;
        int count2 = 0;
        int element1 = nums[0];
        int element2 = nums[0];
        int n = nums.length;
        for (int idx =0; idx < nums.length; idx++){
            if (count1 == 0 && element2 != nums[idx]){
                count1 = 1;
                element1 = nums[idx];
            }else if (count2 == 0 && element1 != nums[idx]){
                count2 = 1;
                element2 = nums[idx];
            }
            else if (element1 == nums[idx]){
                count1++;
            }else if(element2 == nums[idx]){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int ele : nums){
            if (ele == element1)
                count1++;
            if (ele == element2)
                count2++;
        }
        List<Integer> result = new ArrayList<>();
        if (element1 == element2){
            result.add(element1);
            return result;
        }
        if (count1 > n/3) {
            result.add(element1);
        }
        if (count2 > n/3) {
            result.add(element2);
        }
        return result;
    }

}
