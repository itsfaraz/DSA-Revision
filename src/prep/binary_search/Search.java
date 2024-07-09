package prep.binary_search;

public class Search implements BinarySearch{
    public boolean bSearch(int []arr,int searchX){
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int mid = left + ((right-left)/2);
            int midValue = arr[mid];
            if (midValue == searchX){
                return true;
            }else if(midValue < searchX){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return false;
    }
}
