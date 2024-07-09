package roadmap.dsa.linkedlist;

import roadmap.dsa.customdatastructure.list.linkedlist.LinkedList;

public class MergeSortedList {

//    public static void main(String[] args) {
//        LinkedList.Node ele1 = new LinkedList.Node();
//        LinkedList.Node ele2 = new LinkedList.Node();
//        LinkedList.Node ele3 = new LinkedList.Node();
//        ele1.data = 1;
//        ele1.next = ele2;
//        ele2.data = 2;
//        ele2.next = ele3;
//        ele3.data = 3;
//        ele3.next = null;
//
//        LinkedList.Node ele11 = new LinkedList.Node();
//        LinkedList.Node ele12 = new LinkedList.Node();
//        LinkedList.Node ele13 = new LinkedList.Node();
//        LinkedList.Node ele14 = new LinkedList.Node();
//
//        ele11.data = 1;
//        ele11.next = ele12;
//        ele12.data = 2;
//        ele12.next = ele13;
//        ele13.data = 3;
//        ele13.next = ele14;
//        ele14.data = 4;
//        ele14.next = null;
//        LinkedList.Node sortedList = mergeSortedList(ele1,ele11);
//        System.out.println(sortedList);
//    }

    public static LinkedList.Node mergeSortedList(LinkedList.Node firstHalf, LinkedList.Node secondHalf){
        LinkedList.Node head = new LinkedList.Node();
        LinkedList.Node prev = head;
        boolean isFirst = false;
        while (firstHalf != null && secondHalf != null){
            LinkedList.Node node = new LinkedList.Node();

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
            LinkedList.Node node = new LinkedList.Node();
            prev.next = node;
            node.data = firstHalf.data;
            firstHalf = firstHalf.next;
            prev = node;
        }
        while (secondHalf != null){
            LinkedList.Node node = new LinkedList.Node();
            prev.next = node;
            node.data = secondHalf.data;
            secondHalf = secondHalf.next;
            prev = node;
        }

        return head.next;
    }
}
