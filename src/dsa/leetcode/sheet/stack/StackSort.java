package dsa.leetcode.sheet.stack;

import java.util.Stack;

public class StackSort {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-3);
        stack.push(14);
        stack.push(18);
        stack.push(-5);
        stack.push(30);
        stackSort(stack);
        System.out.println(stack);
    }

    public static void stackSort(Stack<Integer> stack){
        if (stack.isEmpty())
            return;
        int poppedElement = stack.pop();
        stackSort(stack);
        sortInserted(stack,poppedElement);
    }

    private static void sortInserted(Stack<Integer> stack, int element) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty())
        {
            if (stack.peek() > element){
                temp.push(stack.pop());
            }else break;
        }
        stack.push(element);
        while (!temp.isEmpty())
            stack.push(temp.pop());
    }


}
