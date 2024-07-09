package roadmap.dsa.leetcode.arrays;

import java.util.Arrays;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        for(int i =0 ;i < arr.length;i++){
            if(arr[i] == 0){
                if(i+1 < arr.length){
                    int no = arr[i+1];
                    arr[i+1] = 0;
                    if(i+2 < arr.length){
                        for(int idx = i+2; idx < arr.length;idx++){
                            int temp = arr[idx];
                            arr[idx] = no;
                            no = temp;
                        }
                    }
                }
                i = i+1;
            }
        }
        System.out.println(Arrays.toString(arr));


    }
}
