package dsa.leetcode.arrays;

public class MostWaterContainer {

    public static void main(String[] args) {
        int []height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new MostWaterContainer().maxArea(height));
    }

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int max = Integer.MIN_VALUE;
        while(start < end){
            int total = Math.min(height[start],height[end]) * Math.abs((end-start));
            max = Math.max(total,max);
            if (height[start] < height[end]){
                start++;
            }else {
                end--;
            }
        }
        return max;
    }

}
