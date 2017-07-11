package com.example.linkedlist;


import java.util.logging.Logger;

/**
 * Created by Anuj on 11-07-2017.
 */
public class LinkedList {
    final static Logger log = Logger.getLogger(LinkedList.class.getName());
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    public static void main(String[] args) {
        LinkedList lList = new LinkedList();

        lList.head = new Node(2);
        Node second = new Node(5);
        Node third = new Node(1);

        //Join all the nodes to form a linkedlist
        lList.head.next = second;
        second.next = third;
        printList(lList);
        //insert at End
        log.info("Insert at End");
        lList.insertAtEnd(10);
        printList(lList);
        //insert at front
        log.info("Insert at Front");
        lList.insertAtFront(30);
        printList(lList);
        //insert after a node
        log.info("Insert after a node");
        lList.insertAfterNode(second, 54);
        printList(lList);
        log.info("Delete a given");
        lList.deleteNode(30);
    }

    private void deleteNode(int d) {
        //Find the previous node to the node we want to delete:
        Node current = head;
        Node previous = null;

        //if node to be deleted is the head. do the following:
        if (current != null && current.data == d) {
            head = current.next; // change the head
            return;
        }
        //If node to be deleted is somewhere in the linkedlist
        while (current.next != null && current.data != d) {
            previous = current;
            current = current.next;
        }
        if (current == null) return;
        //Next of previous should point next of current
        previous.next = current.next;

    }

    private static void printList(LinkedList lList) {
        //traversing the linkedlist
        Node travel = lList.head;
        while (travel != null) {
            if (travel.next != null)
                System.out.print(travel.data + "---->");
            else
                System.out.print(travel.data);
            travel = travel.next;
        }
        System.out.println();
    }

    public void insertAtEnd(int data) {
        //create a new node
        Node end = new Node(data);
        //Identify last of given linkedlist
        Node traversal = this.head;
        while (traversal.next != null) {
            traversal = traversal.next;
        }
        //make the next of last node the new node
        traversal.next = end;
        return;
    }

    public void insertAtFront(int data) {
        //1. Create a node
        Node front = new Node(data);
        //2. make the next of new node point to head of linkedlist
        front.next = this.head;
        //3. Make the head point to new node
        head = front;
        return;
    }

    public void insertAfterNode(Node given, int data) {
        //create a node
        Node afterGivenNode = new Node(data);
        //make next of given node, next of new node
        afterGivenNode.next = given.next;
        //make next of given node point to aftergiven node
        given.next = afterGivenNode;
    }
}
