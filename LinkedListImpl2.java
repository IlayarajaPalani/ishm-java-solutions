package com.ishm.codingchallenge.collections;

public class LinkedListImpl2 {
    Node head;

    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public LinkedListImpl2 insert(LinkedListImpl2 list, int data){
        Node new_node = new Node(data);
        new_node.next = null;
        if(list.head == null){
            list.head = new_node;
        }else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static void printList(LinkedListImpl2 list){
        Node currNode = list.head;
        while(currNode!=null){
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
    }

    void deleteNode(int key)
    {
        // Store head node
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key)
        {
            head = temp.next; // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != key)
        {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null) return;

        // Unlink the node from linked list
        prev.next = temp.next;
    }
    public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    public static void main(String[] args) {
        LinkedListImpl2 llist = new LinkedListImpl2();

        llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);

        System.out.println("\nCreated Linked list is:");
        printList(llist);

        llist.deleteNode(1); // Delete node with data 1

        printList(llist);

    }

}
