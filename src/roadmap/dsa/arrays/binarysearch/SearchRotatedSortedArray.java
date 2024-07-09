package roadmap.dsa.arrays.binarysearch;

public class SearchRotatedSortedArray {

    /*
        Given a sorted array which is in rotated form
        we have to find out the element give in O(log n base 2)

        arr = [11, 12, 15, 18, 2 ,5 ,6 ,8]
        ele = 15
        result = 2
     */
    public int search(int []arr,int ele){
        return this.search(arr,ele,0,arr.length-1,true);
    }
    private int search(int []arr,int ele,int start,int end,boolean isAdvanced){
        while (start <= end){
            int mid = (start + (end-start)/2);

            if (isAdvanced){
                int next = (mid+1)%arr.length;
                int prev = ((mid+arr.length)-1)%arr.length;

                if (arr[mid] < arr[prev] && arr[mid] < arr[next]){
                    int searchLeft = search(arr,ele,0,mid-1,false);
                    int searchRight = search(arr,ele,mid,arr.length-1,false);
                    if (searchLeft != -1)
                        return searchLeft;
                    else if (searchRight != -1)
                        return searchRight;
                    else return -1;
                }else if(arr[mid] > arr[0]){
                    start = mid+1;
                }else if (arr[mid] < arr[arr.length-1]){
                    end = mid-1;
                }

            }else{
                if (arr[mid] == ele)
                    return mid;
                else if (arr[mid] > ele){
                    end = mid-1;
                }else if (arr[mid] < ele)
                    start = mid+1;
            }
        }
        return -1;
    }

}
