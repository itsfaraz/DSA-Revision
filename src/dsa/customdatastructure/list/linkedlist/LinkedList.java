package dsa.customdatastructure.list.linkedlist;

public class LinkedList {


    public static void main(String[] args) throws Exception{
       LinkedList list = new LinkedList();
       list.addLast(10);
       list.addLast(20);
       list.addFirst(50);
       list.addLast(240);
       list.addLast(120);
       list.addLast(100);
       list.addLast(40);
       list.addFirst(90);
       System.out.println(list.isEmpty());
       System.out.println(list);
       System.out.println(list.getFirst());
       System.out.println(list.getAt(0));
       Node node = list.getNodeAt(3);
       System.out.println(node.data);


    }

    private class Node{
        int data;
        Node next;

        public Node(){
            this.next = null;
        }
    }

    private Node head;
    private Node tail;


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
        return  displayList();
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
