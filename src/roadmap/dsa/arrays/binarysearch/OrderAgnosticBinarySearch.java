package roadmap.dsa.arrays.binarysearch;

public class OrderAgnosticBinarySearch {
    /*
        Given an array we have to search an element
        but we don't know an array is sorted in which order it could
        be sorted in ascending order Or in descending order
     */
    public int binarySearch(int []arr,int ele){
        if (arr.length == 1 && arr[0] == ele)
        {
            return 0;
        }else if (arr[0] < arr[1]){
            return conditionalBinarySearch(arr,ele,true);
        }else if (arr[0] > arr[1]){
            // Descending Binary Search
            return conditionalBinarySearch(arr,ele,false);
        }
        return -1;
    }

    private int conditionalBinarySearch(int []arr,int ele,boolean isNormal){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = (start + ((end-start)/2));
            if (arr[mid] == ele)
                return mid;
            else if (arr[mid] > ele){
                if (isNormal){
                    end = mid-1;
                }else {
                    start = mid+1;
                }
            }else if (arr[mid] < ele){
                if (isNormal){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }

}
