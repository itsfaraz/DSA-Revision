package dsa.linkedlist;

import dsa.customdatastructure.list.linkedlist.LinkedList;

public class MidPoint {

    public static LinkedList.Node midPoint(LinkedList.Node head){

        LinkedList.Node slow = head;
        LinkedList.Node fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;
    }

}
