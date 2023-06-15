package dsa.basic;

import java.util.Scanner;
import java.util.Arrays;

public class Basic {

    private int []container = null;
    private Scanner scn = new Scanner(System.in);
    public void takeInput(int times){
        container = new int[times];
        for(int i = 0; i < times; i++){
            container[i] = scn.nextInt();
        }
    }

    public void display(){
        for(int val : container){
            System.out.print(val+" ");
        }
        System.out.println();
    }

    public int max(){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < container.length;i++){
            if (container[i] > max)
                max = container[i];
        }
        return max;
    }

    public int find(int element){
        for(int i = 0; i < container.length;i++){
            if (container[i] == element)
                return i;
        }
        return -1;
    }

    public int search(int element){
        Arrays.sort(container);
        int low = 0;
        int max = container.length-1;
        while (low <= max){
            int mid = (low+max)/2;
            if (container[mid] == element)
                return mid;
            else if(container[mid] > element){
                max = mid-1;
            }else
                low = mid+1;
        }
        return -1;
    }

    public void reverse(){
        int i = 0;
        int j = container.length-1;
        while (i < j){
            int temp = container[i];
            container[i] = container[j];
            container[j] = temp;
            i++;
            j--;
        }

    }

    public void reverse(int i,int j){
        while (i < j){
            int temp = container[i];
            container[i] = container[j];
            container[j] = temp;
            i++;
            j--;
        }

    }

    public void rotate(int times){
        for(int i = 0; i < times;i++){
            singleRotate();
        }
    }

    private void singleRotate(){
        int temp = container[container.length-1];
        for(int idx = container.length-1; idx >= 1; idx--){
            container[idx] = container[idx-1];
        }
        container[0] = temp;
    }

    public void rotateEnhanced(int times){
        int index = times%container.length;
        reverse(container.length-index,container.length-1);
        reverse(0,container.length-index-1);
        reverse();
    }

    public void sort(){
        Arrays.sort(container);
    }

}
