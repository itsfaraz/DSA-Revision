package roadmap.dsa.arrays.binarysearch;

public class NextAlphabet {

     /*
        Given a sorted array of characters, We have to search the next greater character of key

        input :
        arr = [a c f h]
        ele = f

        output :
        result = h
     */

    public char nextCharacter(char [] arr,char key){

        int start = 0;
        int end = arr.length-1;
        char result = '0';
        while (start <= end){
            int mid = (start + (end-start)/2);
            if (arr[mid] == key){
                start = mid+1;
            } else if (arr[mid] < key){
                start = mid+1;
            } else if (arr[mid] > key) {
                result = arr[mid];
                end = mid-1;
            }
        }
        return result;
    }

}
