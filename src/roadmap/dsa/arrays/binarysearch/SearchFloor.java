package roadmap.dsa.arrays.binarysearch;

public class SearchFloor {
 /*
        Given a sorted array, We have to search the floor of an element

        Floor meaning in the problem, In below array 5 element is not present
        then we need to find the greatest element which is less then 5 that is 4
        in the array then we have to return the index.

        input :
        arr = [1 2 3 4 8 10 10 12 19]
        ele = 5

        output :
        result = 3 (need to return index of element)
     */


    public int search(int []arr,int ele){

        int start = 0;
        int end = arr.length-1;
        int result = -1;
        while (start <= end){
            int mid = (start + (end-start)/2);
            if (arr[mid] == ele){
                result = mid;
                break;
            }else if (arr[mid] < ele){
                if (arr[mid] > result)
                    result = mid;
                start = mid+1;
            }else if (arr[mid] > ele){
                end = mid-1;
            }
        }
        return result;
    }

}
