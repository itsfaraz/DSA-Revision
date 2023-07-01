package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreater {
    // Next largest element
    // Next greater to right

    public static void main(String[] args) {
        int []arr = {1,3,0,0,1,2,4};
        arr = new int[]{1,3,2,4};
        printNextGreaterA1(arr);
        printNextGreaterA2(arr);
    }

    // Brute for
    public static void printNextGreaterA1(int []elements){
        for (int i = 0; i < elements.length-1; i++){
            for (int j = i+1; j < elements.length; j++){
                if (elements[j] > elements[i]) {
                    System.out.print(elements[j] + " ");
                    break;
                }
            }
        }
        System.out.println("-1");
    }

    public static void printNextGreaterA2(int []elements){
        int []output = new int [elements.length];
        Stack<Integer> stack = new Stack();
        int idx = elements.length-1;

        while (idx >= 0){
            if (stack.isEmpty()){
                output[idx] = -1;
                stack.push(elements[idx]);
                idx--;

            }else if (stack.peek() > elements[idx]){
                output[idx] = stack.peek();
                stack.push(elements[idx]);

                idx--;
            }else if (stack.peek() < elements[idx]){
                stack.pop();
            }
        }
        System.out.println(Arrays.toString(output));
    }




}
