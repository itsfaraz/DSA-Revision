package dsa.linkedlist;


import dsa.customdatastructure.list.linkedlist.LinkedList;

// Given an array we have to find out intersecting point of linked list
public class IntersectingPoint {

    public LinkedList.Node intersectingPoint(LinkedList.Node first, LinkedList.Node second){
        LinkedList.Node headFirst = first;
        LinkedList.Node headSecond = second;
        int count = 0;
        while (count != 2){
            headFirst = headFirst.next;
            headSecond = headSecond.next;
            if (headFirst == null){
                headFirst = second;
                count++;
            }
            if (headSecond == null){
                headSecond = first;
                count++;
            }
        }
        while (headFirst != null || headSecond != null){
            if (headFirst == headSecond)
                return headFirst;
            headFirst = headFirst.next;
            headSecond = headSecond.next;
        }
        return null;
    }

}
