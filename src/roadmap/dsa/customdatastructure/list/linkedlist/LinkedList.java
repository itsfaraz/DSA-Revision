package roadmap.dsa.customdatastructure.list.linkedlist;

import roadmap.dsa.linkedlist.ReverseKGroup;

public class LinkedList {


    public static void main(String[] args) throws Exception{
       LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
//        list.addLast(60);
//        list.addLast(70);
//        list.addLast(80);



//       System.out.println(list.isEmpty());
//       System.out.println(list);
//       System.out.println(list.getFirst());
//       System.out.println(list.getAt(0));
//       Node node = list.getNodeAt(3);
//       System.out.println(node.data);
//        System.out.println(list);
//        list.head = new ReverseLinkedList().reverseListA2(list.head);
//        System.out.println(list);
//        System.out.println(new MidPoint().midPoint(list.head).data);
//        System.out.println(new KLast().KFromLast(list.head,2));
//        list.head = new KLast().removeKLast(list.head,2);
//        System.out.println(list);
        System.out.println(new ReverseKGroup().reverseKGroup(list.head,3));
    }

    public static class Node{
        public int data;
        public Node next;

        public Node(){
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public Node getHead(){
        return head;
    }

    public void addFirst(int data){
        if (head == null){
            head = new Node();
            head.data = data;
            tail = head;
            return;
        }
        Node tempNode = new Node();
        tempNode.data = data;
        tempNode.next = head;
        head = tempNode;
    }
    public void addLast(int data){
        if (head == null){
            head = new Node();
            head.data = data;
            tail = head;
            return;
        }
        Node tempNode = new Node();
        tempNode.data = data;
        tail.next = tempNode;
        tail = tempNode;
    }

    @Override
    public String toString() {
        return displayList();
    }

    private String displayList(){
        StringBuilder builder = new StringBuilder();
        Node tempNode = head;
        builder.append("[");
        while (tempNode != null){
            builder.append(tempNode.data+", ");
            tempNode = tempNode.next;
        }
        String data = builder.toString();
        if (data.length() == 1 || data.isEmpty()){
            return "[]";
        }
        return data.substring(0,data.length()-2)+"]";
    }

    public Boolean isEmpty(){
        return this.head == null;
    }

    public int size(){
        int countIdx = 1;
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            countIdx++;
        }
        return countIdx;
    }

    public int getFirst() throws Exception{
        if (head == null)
            throw new Exception("Linked List is Empty");
        return head.data;
    }

    public int getLast() throws Exception{
        if (head == null)
            throw new Exception("Linked List is Empty");
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        return temp.data;
    }

    public int getAt(int idx) throws Exception{
        if (isEmpty())
            throw new Exception("List is Empty");
        if (idx < 0 || idx > size())
            throw new Exception("Invalid Index");
        Node temp = head;
        int countIdx = 0;
        while(temp != null){
            if (countIdx == idx)
                return temp.data;
            countIdx++;
            temp = temp.next;
        }
        return -1;
    }

    private Node getNodeAt(int idx) throws Exception{
        if (isEmpty())
            throw new Exception("LinkedList is Empty");
        if (idx < 0 || idx > size())
            throw new Exception("Invalid Index");

        int countIdx = 0;
        Node temp = head;
        while (temp != null){
            if (countIdx == idx)
                return temp;
            countIdx++;
            temp = temp.next;
        }
        return null;
    }

    public int removeFirst() throws Exception{
        if (head == null)
            throw new Exception("List is empty");
        int data = head.data;
        head = head.next;
        return data;
    }




}
