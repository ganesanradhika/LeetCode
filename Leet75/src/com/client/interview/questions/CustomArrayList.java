package com.client.interview.questions;

/**
 * Custom Array List
 */
public class CustomArrayList {

    Node head;
    int size = 0;
    // Node Class

    class Node{
        int data;
        Node next;

        Node(int x) // parameterized constructor
        {
            data = x;
            next = null;
        }
    }

    public void insert(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
            head = newNode;
        else{

            newNode.next = head;
            head = newNode;
            size++;
        }

    }
    public void insert(int pos, int data) {
       int i=0;
       Node n = head;
       Node prev = head;
       while(i < pos){
           prev = n;
           n = n.next;
           i++;
       }

       Node newNode = new Node(data);

       newNode.next = n;
       prev.next = newNode;
       size++;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        Node n = head;
        while(n != null){
            sb.append(n.data).append(" ");
            n = n.next;
        }
        return sb.toString();
    }


    public static void main(String args[])
    {
        CustomArrayList arrayList = new CustomArrayList();
        arrayList.insert(1);
        arrayList.insert(2);
        arrayList.insert(3);

        System.out.println(arrayList);

        arrayList.insert(1,6);
        System.out.println(arrayList);

    }

}
