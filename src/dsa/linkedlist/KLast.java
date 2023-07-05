package dsa.linkedlist;

import dsa.customdatastructure.list.linkedlist.LinkedList;

public class KLast {

    public int KFromLast(LinkedList.Node head,int k){
        LinkedList.Node slow = head;
        LinkedList.Node fast = head;
        if (k <= 0 )
            return slow.data;
        for (int i =0; i < k; i++){
            fast = fast.next;
        }


        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    public LinkedList.Node removeKLast(LinkedList.Node head,int n){
        LinkedList.Node prev = head;
        LinkedList.Node slow = head;
        LinkedList.Node fast = head;
        if (n <= 0 )
            return head;
        int counter = 0;
        for (int i = 0; i < n; i++){
            fast = fast.next;
            counter++;
        }

        if (counter == n && fast == null){
            head = head.next;
            return head;
        }


        while (fast != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (fast == null && slow == prev){
            return null;
        }
        prev.next = slow.next;
        return head;
    }

}
