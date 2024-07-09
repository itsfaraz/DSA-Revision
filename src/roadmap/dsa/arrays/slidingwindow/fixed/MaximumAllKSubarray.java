package roadmap.dsa.arrays.slidingwindow.fixed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumAllKSubarray {

    public void printKAllMaximumV1(int []arr,int k){
        for(int i = 0; i < arr.length-k; i++){
            int max = Integer.MIN_VALUE;
            for(int j = i; j <= i+k; j++){
                if (max < arr[j])
                    max = arr[j];
            }
            System.out.print(max+" ");
        }
        System.out.println();
    }

    // Max Heap Approach
    public void printKAllMaximumV2(int []arr,int k){
        int i = 0;
        int j = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int []result = new int[arr.length-k+1];
        int arrIdx = 0;
        while(j < arr.length){
            int windowSize = (j-i)+1;
            maxHeap.add(arr[j]);
            if (windowSize < k){
                j++;
            }else if(windowSize == k){
                result[arrIdx] = maxHeap.peek();
                System.out.print(maxHeap.peek()+" ");
                if (arr[i] == maxHeap.peek())
                    maxHeap.poll();
                i++;
                j++;
                arrIdx++;
            }

        }
        System.out.println();
    }

    // Custom List Approach
    public void printKAllMaximumV3(int []arr,int k){
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<Integer>();
        int arrIdx = 0;
        int []result = new int[arr.length-k+1];
        while(j < arr.length){
            int windowSize = (j-i)+1;
            if (list.isEmpty())
                list.add(arr[j]);
            else {
                removeUntilGreater(list,arr[j]);
                list.add(arr[j]);
            }


            if (windowSize < k){
                j++;
            }else if(windowSize == k){
                System.out.print(list.get(0)+" ");
                result[arrIdx] = list.get(0);
                if (list.get(0) == arr[i])
                    list.remove(list.get(0));
                i++;
                j++;
                arrIdx++;
            }

        }
        System.out.println();
    }

    private void removeUntilGreater(List<Integer> list, int value) {
        for(int i = list.size()-1; i >= 0; i--){
            if (list.get(i) < value)
                list.remove(i);
        }
    }
}
