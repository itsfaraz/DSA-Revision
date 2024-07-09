package prep.slidingwindow.fixed;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumAllKSubarray {

    public void maximumKSubArray(int []arr,int k){
        // Maxheap syntax
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i =0;
        int j =0;
        while (j <= arr.length && i <= arr.length - k){
            int windowSize = (j-i)+1;
            if (windowSize <= k){
                maxHeap.add(arr[j]);
                j++;
            }else if(windowSize == k+1){
                if (!maxHeap.isEmpty()){
                    System.out.print(maxHeap.peek()+" ");
                }
                maxHeap.remove(arr[i]);
                i++;
            }
        }
    }

}
