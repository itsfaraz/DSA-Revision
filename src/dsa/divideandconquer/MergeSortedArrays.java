package dsa.divideandconquer;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
        int []merged = new MergeSortedArrays().mergeArrays(new int[]{10,30,50,80,100},new int[]{15,20,25,60,70});
        System.out.println(Arrays.toString(merged));
    }


    public int[] mergeArrays(int []one,int[] two){
        int []merged = new int[one.length + two.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < one.length && j < two.length){
            if (one[i] <= two[j]){
                merged[k] = one[i];
                i++;
                k++;
            }else if (one[i] > two[j]){
                merged[k] = two[j];
                j++;
                k++;
            }
        }
        while (i < one.length){
            merged[k] = one[i];
            i++;
            k++;
        }
        while (j < two.length){
            merged[k] = two[j];
            j++;
            k++;
        }
        return merged;
    }

}
