package dsa.arrays.binarysearch;

public class PeakElement {

    /*
        Note : Unsorted array
        Given an unsorted array we have to find the peak element
        A element is called peak element if and only if its both neighbour
        are smaller that its.

        input :
        arr = [5, 10, 20, 15]

        output :
        2 (need to return index of peak element 20)
     */

    public int searchPeak(int []arr){
        if (arr.length == 1)
            return 0;

        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            int mid = (start + (end-start)/2);
            if (mid == 0 && arr[mid] > arr[mid+1]){
                return mid;
            }else if (mid == arr.length-1 && arr[mid] > arr[mid-1]){
                return mid;
            }else if (mid >= 1 && mid <= arr.length-2 && arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }else if (mid <= arr.length-2 && arr[mid] > arr[mid+1])
                end = mid-1;
            else if (mid >= 1 && arr[mid] > arr[mid-1])
                start = mid+1;

        }
        return -1;
    }

}
