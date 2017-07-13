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
        //log.info("Insert at End");
        lList.insertAtEnd(10);
        printList(lList);
        //insert at front
        //log.info("Insert at Front");
        lList.insertAtFront(30);
        printList(lList);
        //insert after a node
        //log.info("Insert after a node");
        lList.insertAfterNode(second, 54);
        printList(lList);
        // log.info("Delete a given");
        //lList.deleteNode(30);
        System.out.println("before  swapping");
        printList(lList);
        lList.swap(10, 30);
        System.out.println("after swapping");
        printList(lList);
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

    public void swap(int a, int b) {

        Node aNode = findNode(a);
        System.out.println("Node A: " + aNode.data);
        Node bNode = findNode(b);
        System.out.println("Node B: " + bNode.data);
        if (!(aNode == null || bNode == null)) {
            //If node one is the head: check::
            if (aNode == head) {
                System.out.println("A is at the head");
                //Find B:
                Node prevB = findPrev(b);
                Node temp = aNode.next;
                prevB.next = aNode;
                aNode.next = bNode.next;
                bNode.next = temp;
                head = bNode;

            } else if (bNode == head) {
                System.out.println("B is at the head");
                Node prevA = findPrev(a);
                Node temp = bNode.next;
                prevA.next = bNode;
                bNode.next = aNode.next;
                aNode.next = temp;
                head = aNode;
            } else {
                Node prevA = findPrev(a);
                Node prevB = findPrev(b);
                Node temp = bNode.next;
                prevA.next = bNode;
                bNode.next = aNode.next;
                aNode.next = temp;
                prevB.next = aNode;
            }
        }
    }

    private Node findNode(int data) {
        Node temp = head;
        while (temp != null && temp.data != data) {
            temp = temp.next;
        }
        return temp;
    }


    private Node findPrev(int d) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == d) {
                break;
            }
            temp = temp.next;
        }
        if (temp != null) {
            //temp = temp.next;
            System.out.println("Previous Node: " + temp.data);
            return temp;
        }
        return null;
    }
}
