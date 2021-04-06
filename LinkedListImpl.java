package com.ishm.codingchallenge.collections;


public class LinkedListImpl {
    public static void main(String[] args) {
        Node root = null;
        Linked link = new Linked();
        root = link.add(1,root);
        root = link.add(12,root);
        root = link.add(15,root);

        link.show(root);
    }
}

class Node{
    int i;
    Node next;
}

class Linked{


    public Node add(int i, Node node) {
        if(node == null) {
            return getNewNode(i);
        }else{
            node.next = add(i,node.next);
        }
        return node;
    }

    public void show(Node node){

            if (node == null) {
                return;
            }
            System.out.println(node.i);
            show(node.next);
    }
    private Node getNewNode(int i) {
        Node node = new Node();
        node.i = i;
        node.next = null;
        return node;
    }
}
