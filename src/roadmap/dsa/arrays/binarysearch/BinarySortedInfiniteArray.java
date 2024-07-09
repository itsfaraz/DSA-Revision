package roadmap.dsa.arrays.binarysearch;

public class BinarySortedInfiniteArray {

    /*
        Given a sorted array of infinite binary elements
        we have to find the first index of the key in the infinite
        array

        input :
        arr = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,----∞]
        key = 1

        output :
        result = 14 ( Index of first occurrence of key )

     */

    public int searchElement(int []infiniteArray,int key){
        int result = 0;
        int start = 0;
        // Since the array is infinite we don't know the end
        // We have to find the end first
        int end = 1;
        while (infiniteArray[end] < key){
            start = end;
            end = end*2;
        }

        // First occurrence binary search
        while(start <= end){
            int mid = (start + (end-start)/2);
            if (infiniteArray[mid] == key){
                result = mid;
                end = mid-1;
            }else if (infiniteArray[mid] > key){
                end = mid-1;
            }else if (infiniteArray[mid] < key){
                start = mid+1;
            }
        }
        return result;
    }

}
