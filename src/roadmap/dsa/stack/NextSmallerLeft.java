package roadmap.dsa.stack;

import java.util.Stack;

public class NextSmallerLeft {
    public static void main(String[] args) {
        int []arr = {1,3,0,0,1,2,4};
        arr = new int[]{4,5,2,10,8};
        printLeftSmallerA1(arr);
        printLeftSmallerA2(arr);
    }

    private static void printLeftSmallerA1(int[] arr) {
        System.out.print(-1+" ");
        for (int idx = 1; idx < arr.length; idx++){
            boolean flag = true;
            for (int j = idx-1; j >= 0; j--){
                if (arr[j] < arr[idx]){
                    System.out.print(arr[j]+" ");
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.print(-1+" ");
            }
        }
        System.out.println();
    }

    private static void printLeftSmallerA2(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        while (idx < arr.length){
            if (stack.isEmpty()){
                System.out.print(-1+" ");
                stack.push(arr[idx]);
                idx++;
            }else if(stack.peek() < arr[idx]){
                System.out.print(stack.peek()+" ");
                stack.push(arr[idx]);
                idx++;
            }else if (stack.peek() >= arr[idx])
                stack.pop();
        }
    }
}
