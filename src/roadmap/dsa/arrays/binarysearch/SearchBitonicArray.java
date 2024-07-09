package roadmap.dsa.arrays.binarysearch;

public class SearchBitonicArray {

    /*
        Given a bitonic array we have to search the index of the element
        Bitonic = Monotonically increasing then Monotonically decreasing

        input :
        arr = 1 3 8 12 4 2
        key = 4

        output :
        result = 4
     */


    public int search(int []arr,int ele){
        // here first we need to find the peak element
        // after finding peak element we can search


        int peak = searchPeak(arr);
        int ascSearch = search(arr,ele,0,peak-1,true);
        int dscSearch = search(arr,ele,peak,arr.length-1,false);
        if (ascSearch != -1)
            return ascSearch;
        else if (dscSearch != -1)
            return dscSearch;
        else return -1;
    }

    private int search(int []arr,int ele,int start,int end,boolean isASC){
        while (start <= end){
            int mid = (start + (end-start)/2);
            if (arr[mid] == ele)
                return mid;
            else if (arr[mid] > ele){
                if (isASC){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else if (arr[mid] < ele){
                if (isASC){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }
    private int searchPeak(int []arr){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = (start + (end-start)/2);
            if (mid == 0 && arr[mid] > arr[mid+1])
                return mid;
            else if(mid == arr.length-1 && arr[mid] > arr[mid-1])
                return mid;
            else if (mid > 0 && mid <= arr.length-2 && arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1])
                return mid;
            else if (mid > 0 & arr[mid] > arr[mid-1])
                start = mid+1;
            else if (mid <= arr.length-2 && arr[mid] > arr[mid+1])
                end = mid-1;
        }
        return -1;
    }

}
