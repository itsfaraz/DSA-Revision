package prep.binary_search;

public class FloorCiel {

    public int findFloor(int []arr,int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = Math.min(arr[mid],result);
                break;
            } else if (arr[mid] > target) {
                right = mid-1;
                result = Math.min(arr[right],result);
            } else {
                left = mid+1;
            }
        }
        return result;
    }

    public int findCiel(int []arr,int target){
        int left = 0;
        int right = arr.length-1;
        int result = Integer.MIN_VALUE;
        while (left <= right){
            int mid = left + (right-left)/2;

            if (arr[mid] == target){
                result = Math.max(result,arr[mid]);;
                break;
            }else if (arr[mid] > target){
                right = mid-1;
                result = Math.max(result,arr[left]);
            }else{
                left = mid+1;
            }
        }
        return result;
    }

}
