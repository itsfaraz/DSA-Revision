package roadmap.revise.standard.array;

import static roadmap.revise.Main.swap;

public class Reverse {

    public static void reverse(int []arr){
        int i =0;
        int j = arr.length-1;
        while (i < j){
            swap(i,j,arr);
            i++;
            j--;
        }
    }

    public static void reverseRange(int []arr,int i,int j){
        while (i < j){
            swap(i,j,arr);
            i++;
            j--;
        }
    }

}
