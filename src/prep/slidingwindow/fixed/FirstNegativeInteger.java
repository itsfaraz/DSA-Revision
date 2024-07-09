package prep.slidingwindow.fixed;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInteger {

    public void firstNegativeIntegers(int []arr,int k){

        Queue<Integer> queue = new LinkedList<Integer>();
        int i =0;
        int j = 0;

        while (j < arr.length){
            int checkCondition = (j-i)+1;
            if (arr[j] < 0){
                queue.add(arr[j]);
            }
            if (checkCondition < k){
                j++;
            }else if (checkCondition == k){
                if (!queue.isEmpty())
                    System.out.print(" "+queue.peek());
                else System.out.print(" 0");
                int trashValue = arr[i];
                i++;
                j++;
                if (!queue.isEmpty() && queue.peek() == trashValue){
                    queue.poll();
                }
            }
        }
        System.out.println();
    }
}
