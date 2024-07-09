package prep.binary_search;

public class Occurence implements BinarySearch{

    public int firstOccurrence(int []arr,int x){
        int left = 0;
        int right = arr.length-1;
        int result = -1;
        while (left <= right){
            int mid = left + ((right-left)/2);
            int midValue = arr[mid];
            if (midValue == x){
                result = mid;
                right = mid-1;
            }else if (midValue < x){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return result;
    }

    public int lastOccurrence(int []arr,int x){
        int left = 0;
        int right = arr.length-1;
        int result = -1;
        while (left <= right){
            int mid = left + ((right-left)/2);
            int midValue = arr[mid];
            if (midValue == x){
                result = mid;
                left = mid+1;
            }else if (midValue < x){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return result;
    }

}
