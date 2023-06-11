package dsa.arrays.binarysearch;

public class SearchNearlySortedArray {

    /*
        Given a nearly sorted array, We have to search the element
        Nearly sorted means
        i index supposed to be present at i,i+1 or i-1

        input :
        arr = [5 10 30 20 40]
        ele = 10

        output :
        result = 1 (need to return index of element)
     */

    public int search(int []arr,int ele){
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            int mid = (start + (end-start)/2);
            if (arr[mid] == ele){
                return mid;
            }else if (mid-1 > 0 && arr[mid-1] == ele)
                return mid-1;
            else if (mid+1 < arr.length && arr[mid+1] == ele)
                return mid+1;
            else if (arr[mid] > ele){
                end = mid-2;
            }else if (arr[mid] < ele)
                start = mid+2;
        }
        return -1;
    }

}
