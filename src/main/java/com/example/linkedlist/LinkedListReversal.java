package com.example.linkedlist;

/**
 * Created by Anuj on 15-07-2017.
 */
class LinkedListReversal {
    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Function to iterativeReverse the linked list */
    Node iterativeReverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        node = prev;
        return node;
    }

    Node recursiveReverse(Node current, Node prev) {
        /* if current is the last node, mark it as head */
        if (current.next == null) {
            head = current;
            /*next of current will be previous node*/
            current.next = prev;
            return null;
        }
        Node temp = current.next;
        current.next = prev;

        recursiveReverse(temp, current);
        return head;
    }

    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedListReversal list = new LinkedListReversal();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.iterativeReverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
        System.out.println("");
        System.out.println("Recursive revered linked list");
        //divide the linked list into two parts: head and rest of the list.
        //recursively reverse the rest of the list
        Node res = list.recursiveReverse(head, null);
        list.printList(res);
    }
}
