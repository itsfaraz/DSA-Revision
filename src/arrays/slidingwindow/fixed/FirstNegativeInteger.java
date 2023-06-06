package arrays.slidingwindow.fixed;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInteger {

    /*
        Given an array find out first negative integers from the subarray of size k
        ex :
        arr = [12,-1,-7,8,-15,30,13,28]
        k = 4

        12 -1 -7 8  = -1
        -1 -7 8 -15 = -1
        -7 8 -15 30 = -7
        8 -15 30 13 = -15
       -15 30 13 28 = -15



     */
    public void printFirstNegativeV1(int []arr,int k){
        for(int i = 0; i <= arr.length-k;i++){
            boolean isFound = false;
            for (int j = i; j < i+k; j++){
                if (arr[j] < 0) {
                    isFound = true;
                    System.out.print(arr[j]+" ");
                    break;
                }
            }
            if (!isFound){
                System.out.println("0 ");
            }
        }
    }

    public void printFirstNegativeV2(int []arr,int k){
        int i = 0;
        int j = 0;

        Queue<Integer> queue = new LinkedList<>();
        while(j < arr.length){
            int windowSize = (j-i)+1;

            if (arr[j] < 0)
                queue.add(arr[j]);

            if (windowSize < k){
                j++;
            }else if (windowSize == k){
                if (queue.isEmpty())
                    System.out.print("0 ");
                else
                    System.out.print(queue.peek()+" ");

                if (!queue.isEmpty()){
                    if (arr[i] == queue.peek()){
                        queue.poll();
                    }
                }

                i++;
                j++;
            }
        }

    }


}
