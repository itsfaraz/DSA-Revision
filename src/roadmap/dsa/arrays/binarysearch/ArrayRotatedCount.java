package roadmap.dsa.arrays.binarysearch;

public class ArrayRotatedCount {

    /*
        Given a sorted array we have to find out how many number of times
        array is rotated

        arr = 11 12 15 18 2 5 6 8
        result = 4 times
     */

    /*
        One observation the minimum element index is the rotation time
        we just need to find the minimum elment index
     */
    public int rotationCount(int []arr){

        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = (start + ((end-start)/2));
            int inext = (mid+1)%arr.length;
            int iprev = ((mid+arr.length)-1)% arr.length;
            if (arr[mid] < arr[inext] && arr[mid] < arr[iprev]){
                return mid;
            }else if (arr[0] < arr[mid])
                start = mid+1;
            else if (arr[arr.length-1] > arr[mid]){
                end = mid-1;
            }
        }

        return -1;
    }


}
