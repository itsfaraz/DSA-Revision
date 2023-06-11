package dsa.arrays.binarysearch;

public class LastOccurrenceSearch {

    /*
        Given an array we have to search first occurrence of it
        arr = [2, 4, 10, 10, 10, 18, 20]
        ele = 10

        Then answer should be 4th index
     */

    public int lastOccurrence(int []arr,int ele){

        int start = 0;
        int end = arr.length-1;
        int resultIndex = Integer.MIN_VALUE;
        while (start <= end){
            int mid = (start + ((end-start)/2));
            if (arr[mid] == ele){
                if (resultIndex < mid)
                    resultIndex = mid;
                start = mid+1;
            }else if(arr[mid] > ele){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return resultIndex;
    }

}
