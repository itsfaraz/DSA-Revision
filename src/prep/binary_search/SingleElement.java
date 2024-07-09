package prep.binary_search;

public class SingleElement {
    /*Single Element in a Sorted Array*/




    public int singleElement(int []arr,int left,int right){
       return binarySearchIndex(arr,left,right);
    }

//    3,3,7,7,10,11,11
    private int binarySearchIndex(int []arr,int left,int right){
        int mid = left + (right-left)/2;
        if (left == right)
            return -1;
        while (left <= right){
            if (mid > 0 && mid < arr.length-1 && arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1])
                return mid;
            else{
                int leftResult = -1;
                leftResult = binarySearchIndex(arr,left,mid-1);
                if (leftResult != -1)
                    return leftResult;
                return binarySearchIndex(arr,mid+1,left);
            }
        }
        return -1;
    }
}
