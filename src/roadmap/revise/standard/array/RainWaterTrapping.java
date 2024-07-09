package roadmap.revise.standard.array;

public class RainWaterTrapping {
    public static int trappedWater(int []arr){
        /*
            Approach :
                For every element find the min (left max and right max) and subtract
                it with current element

                TC : O(n^2)
                SC : O(1)
        */
        return 0;
    }
    public static int trappedWaterPrecalculation(int []arr){
        /*
            Approach :
                Precalculate all left max and all right max  in separate arrays
                Now calculate trapped water based on min (left,right) of that element

                TC : O(n)
                SC : O(n)
        */
        return 0;
    }
    public static int trappedWaterPrecalculationOptimized(int []arr){
        /*
            Approach :
                Instead of using extra array maintain leftMax and rightMax
                And make use of 2 pointer approach to calculate trapped water

                TC : O(n)
                SC : O(1)
        */

        int trappedWater = 0;
        int leftMax = arr[0];
        int rightMax = arr[arr.length-1];

        int left = 0;
        int right = arr.length-2;

        while (left <= right){
            if (Math.min(leftMax,rightMax) == leftMax){
                if (leftMax-arr[left] >= 0){
                    trappedWater += leftMax - arr[left];
                }else{
                    leftMax = arr[left];
                }
                left++;
            }else {
                if (rightMax-arr[right] >= 0){
                    trappedWater += rightMax - arr[right];
                }else{
                    rightMax = arr[right];
                }
                right--;
            }
        }
        return trappedWater;
    }
    public static void main(String[] args) {
    }
}
