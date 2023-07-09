package dsa.divideandconquer;

import dsa.customdatastructure.list.linkedlist.LinkedList.Node;
import dsa.linkedlist.MergeSortedList;
import dsa.linkedlist.MidPoint;

public class ListSort {

    public static void main(String[] args) {
        Node head = null;
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();
        Node node9 = new Node();

        head = node1;
        node1.data = 50;
        node1.next = node2;
        node2.data = 40;
        node2.next = node3;
        node3.data = 80;
        node3.next = node4;
        node4.data = 90;
        node4.next = node5;
        node5.data = 70;
        node5.next = node6;
        node6.data = 10;
        node6.next = node7;
        node7.data = 30;
        node7.next = node8;
        node8.data = 60;
        node8.next = node9;
        node9.data = 120;
        node9.next = null;
        printNode(head);
        printNode(new ListSort().sortList(head));


    }



    public static void printNode(Node head){
        while (head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }

    public  Node sortList(Node head){

        if (head == null || head.next == null)
            return head;

        Node mid = MidPoint.midPoint(head);
        Node middleNext = mid.next;
        mid.next = null;
        Node firstHalf = sortList(head);
        Node secondHalf = sortList(middleNext);

        return mergeSortedList(firstHalf,secondHalf);
    }

    private Node midPoint(Node head){

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;
    }
    
    private Node mergeSortedList(Node firstHalf, Node secondHalf){
        Node head = new Node();
        Node prev = head;
        boolean isFirst = false;
        while (firstHalf != null && secondHalf != null){
            Node node = new Node();

            prev.next = node;
            if (firstHalf.data <= secondHalf.data){
                node.data = firstHalf.data;
                firstHalf = firstHalf.next;
            }else{
                node.data = secondHalf.data;
                secondHalf = secondHalf.next;
            }
            prev = node;
            if (!isFirst){
                head.next = prev;
                isFirst = true;
            }
        }
        while (firstHalf != null){
            Node node = new Node();
            prev.next = node;
            node.data = firstHalf.data;
            firstHalf = firstHalf.next;
            prev = node;
        }
        while (secondHalf != null){
            Node node = new Node();
            prev.next = node;
            node.data = secondHalf.data;
            secondHalf = secondHalf.next;
            prev = node;
        }

        return head.next;
    }
}
