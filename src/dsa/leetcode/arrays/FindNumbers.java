package dsa.leetcode.arrays;

public class FindNumbers {
    public int findNumbers(int[] nums) {
        int evenNo = 0;
        for(int i =0; i < nums.length; i++){
            int no = nums[i];
            int count = 0;
            while(true){
                count++;
                no = no/10;
                if(no == 0)
                    break;
            }
            if(count%2 == 0){
                evenNo++;
            }
        }
        return evenNo;
    }
}
