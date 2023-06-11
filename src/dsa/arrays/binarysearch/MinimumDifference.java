package dsa.arrays.binarysearch;

public class MinimumDifference {

    /*
        Given a sorted array with key based on the key we have
        to find the such element if we do the absolute difference with key
        then that absolute difference should be minimum

        input :
        arr = [4, 6, 10]
        key = 7

        Output :
        result = 6

        Reason :
        If we divide every element of array with 7 (key)
        [4, 6, 10]
         3  1  3
        after dividing we have all absolute difference the minimum one is
        1 which corresponds element 6
        Hence result = 6
     */

    public int minimumDifferenceElement(int []arr,int key){
        int start = 0;
        int end = arr.length-1;
        int minimumDifference = Math.abs(arr[arr.length-1]-key);

        while (start <= end){
            int mid = (start + (end-start)/2);
            int currentDifference = Math.abs(arr[mid] - key);
            if (currentDifference == minimumDifference){
                return arr[mid];
            }else if (minimumDifference > currentDifference){
                minimumDifference = currentDifference;
                end = mid-1;
            }else if (minimumDifference < currentDifference)
                start = mid+1;
        }
        return arr[minimumDifference];
    }


}
