package roadmap.dsa.arrays.binarysearch;

public class BinarySearch {

    public int bSearch(int []arr,int ele){

        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            int mid = (start + ((end-start)/2));
            if(arr[mid] == ele)
                return mid;
            else if(arr[mid] > ele)
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }

}
