package dsa.leetcode.linkedlist;

import dsa.customdatastructure.list.linkedlist.LinkedList;

import java.util.Stack;

public class ReverseLL {

    public LinkedList.Node reverseListOptimal(LinkedList.Node head){
        LinkedList.Node prev = head;
        LinkedList.Node curr = prev.next;
        LinkedList.Node next = null;
        while (curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        head.next = null;
        return prev;
    }
    public LinkedList.Node reverseList(LinkedList.Node head){
        LinkedList.Node curr = head;
        Stack<LinkedList.Node> stack = new Stack<>();
        while (curr != null){
            stack.push(curr);
            curr = curr.next;
        }
        LinkedList.Node first = stack.pop();
        LinkedList.Node prev = first;
        curr = prev;
        while (!stack.isEmpty()){
            curr = stack.pop();
            prev.next = curr;
            prev = curr;
        }
        prev.next = null;
        return first;
    }

}
