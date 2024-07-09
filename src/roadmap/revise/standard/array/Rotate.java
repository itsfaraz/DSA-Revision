package roadmap.revise.standard.array;

import java.util.Arrays;

public class Rotate {
    public static void singleRotate(int []arr){
        int last = arr[arr.length-1];
        for (int idx = arr.length-1; idx >= 1;idx--){
            arr[idx] = arr[idx-1];
        }
        arr[0] = last;
    }

    public static void rotate(int []arr,int times){
        for (int time = 1; time <= times;time++){
            singleRotate(arr);
        }
    }

    public static void rotateFast(int []arr,int times){
        times = times%arr.length;
        Reverse.reverseRange(arr,0, arr.length-times-1);
        Reverse.reverseRange(arr,arr.length-times, arr.length-1);
        Reverse.reverse(arr);
    }

    public static void main(String[] args) {
        int []arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
//        rotate(arr,3);
        rotateFast(arr,13);
        System.out.println(Arrays.toString(arr));
    }
}
