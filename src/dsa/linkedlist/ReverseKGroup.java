package dsa.linkedlist;

import dsa.customdatastructure.list.linkedlist.LinkedList;

public class ReverseKGroup {

    public LinkedList.Node reverseKGroup(LinkedList.Node head,int k){
        LinkedList.Node slow = head;
        LinkedList.Node fast = head;
        LinkedList.Node finalHead = null;
        while(fast != null){
            int counter = 0;
            while (counter++ < k){
                fast = fast.next;
                if (fast.next == null)
                    break;
            }
            LinkedList.Node tempHead = reverseGroup(slow,fast);
            if (finalHead == null)
                finalHead = tempHead;
            slow = fast.next;
        }
        finalHead.next = head;
        head.next = null;
        return finalHead;
    }

    public LinkedList.Node reverseGroup(LinkedList.Node start, LinkedList.Node finalPoint){
        LinkedList.Node prev = start;
        LinkedList.Node curr = prev.next;

        while (curr != finalPoint){
            LinkedList.Node ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        start.next = finalPoint;
        return finalPoint;
    }
}
