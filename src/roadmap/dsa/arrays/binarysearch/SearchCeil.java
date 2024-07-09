package roadmap.dsa.arrays.binarysearch;

public class SearchCeil {
 /*
        Given a sorted array, We have to search the floor of an element

        Ceil meaning in the problem, In below array 6 element is not present
        then we need to find the smallest element which is greater then 6 that is 9
        in the array then we have to return the index.

        input :
        arr = [5 9 12 14 20 25 35]
        ele = 6

        output :
        result = 1 (need to return index of element)
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
            }else if (arr[mid] > ele){
                    result = mid;
                end = mid-1;
            }else if (arr[mid] < ele){
                start = mid+1;
            }
        }
        return result;
    }

}
