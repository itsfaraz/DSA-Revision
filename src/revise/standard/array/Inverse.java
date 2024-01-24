package revise.standard.array;

import java.util.Arrays;

public class Inverse {
    public static void inverse(int []arr){
        int result[] = new int[arr.length];
        for (int idx = 0; idx < arr.length;idx++){
            result[idx] = arr[arr[idx]];
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int []arr = {3,0,4,1,2};
        inverse(arr);
    }
}
