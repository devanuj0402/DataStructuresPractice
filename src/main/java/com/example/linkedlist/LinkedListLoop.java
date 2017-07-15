package com.example.linkedlist;

/**
 * Created by Anuj on 15-07-2017.
 */
class LinkedListLoop {
    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    /* Check for a  loop using Flyod's cycle algorithm */
    boolean isLooping() {
        Node slow_p = head;
        Node fast_p = head;
        while (slow_p != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListLoop list = new LinkedListLoop();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);
        list.head.next.next.next = new Node(6);
        list.head.next.next.next.next = new Node(9);
        list.head.next.next.next.next.next = list.head.next;
        System.out.println("Linked list is: ");
        if (list.isLooping()) {
            System.out.println("Looping");
        } else {
            System.out.println("Not looping");
            list.printList(head);
        }

    }
}
