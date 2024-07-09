package roadmap.dsa.arrays.binarysearch;

public class CountElement {

    /*
        Given an array we have to find the count of an element in sorted array
        As array is sorted we can use Binary Search here

        arr = [2, 4, 10, 10, 10, 18, 20]
        ele = 10

        result = 3 (Because 10 is present 3 times in the array)
     */

    public int countOccurrences(int []arr,int ele){
        int first = conditionalBinarySearch(arr,ele,true);
        int last = conditionalBinarySearch(arr,ele,false);
        return last-first+1;
    }

    private int conditionalBinarySearch(int []arr,int ele,boolean isFirstOccurrence){
        int start = 0;
        int end = arr.length-1;
        int occurrence = 0;
        if (isFirstOccurrence){
            occurrence = Integer.MAX_VALUE;
        }else
            occurrence = Integer.MIN_VALUE;
        while (start <= end){
            int mid = (start + (end-start)/2);
            if (arr[mid] == ele){
                if (isFirstOccurrence){
                    if (mid < occurrence)
                        occurrence = mid;
                    end = mid-1;
                }else{
                    if (mid > occurrence)
                        occurrence = mid;
                    start = mid+1;
                }
            }else if (arr[mid] > ele){
                end = mid-1;
            }else
                start = mid+1;
        }
        return occurrence;
    }

}
