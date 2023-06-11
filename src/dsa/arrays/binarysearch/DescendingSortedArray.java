package dsa.arrays.binarysearch;

public class DescendingSortedArray {

    /*
        Given an array we have to search an element
        but an array is sorted in reverse order

        arr = [20, 17, 15, 14, 13, 12, 10, 9, 8, 4]
        ele = 4
        We have to search 4
     */

    public int binarySearch(int []arr,int ele){

        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            int mid = (start + ((end-start)/2));
            if(arr[mid] == ele)
                return mid;
            else if(arr[mid] > ele)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }

}
