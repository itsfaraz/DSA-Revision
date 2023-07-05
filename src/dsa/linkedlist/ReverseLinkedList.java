package dsa.linkedlist;

import dsa.customdatastructure.list.linkedlist.LinkedList;

import java.util.Stack;

public class ReverseLinkedList extends LinkedList{

    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//        list.addLast(10);
//        list.addLast(20);
//        list.addLast(30);
//        list.addLast(40);
//        System.out.println(list);
//        new ReverseLinkedList().reverseList(list.getHead());
//        list.size();
    }

    public Node reverseList(Node head){
        Stack<Node> stack = new Stack<>();
        LinkedList.Node lastNode = head;
        while (lastNode != null){
            stack.push(lastNode);
            lastNode = lastNode.next;
        }

        head = stack.pop();
        lastNode = head;
        while (!stack.isEmpty()){
            lastNode.next = stack.pop();
            lastNode = lastNode.next;
        }
        lastNode.next = null;
        return head;
    }

    public Node reverseListA2(Node head){
        Node previous = head;
        Node current = head.next;
        head.next = null;
        while (current.next != null){
            Node ahead = current.next;
            current.next = previous;
            previous = current;
            current = ahead;
        }
        current.next = previous;


        return current;
    }

}
