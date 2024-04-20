/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

/**
 *
 * @author ASUS
 */
class DoublyLinkedList {

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Add a node to the head of the list
    public void addToHead(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add a node to the tail of the list
    public void addToTail(int x) {
        Node newNode = new Node(x);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Add a node with value x after the node p
    public void addAfter(Node p, int x) {
        if (p == null) {
            System.out.println("Error: Node cannot be null");
            return;
        }
        Node newNode = new Node(x);
        newNode.next = p.next;
        if (p.next != null) {
            p.next.prev = newNode;
        }
        p.next = newNode;
        newNode.prev = p;
    }

    // Traverse and display info of all nodes in the list
    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Count and return the number of nodes in the list
    public int count() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Delete the head and return its info
    public int deleteFromHead() {
        if (head == null) {
            System.out.println("Error: List is empty");
            return -1; // Assuming -1 as an invalid value
        }
        int data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // List is empty after deletion
        }
        return data;
    }

    // Delete the tail and return its info
    public int deleteFromTail() {
        if (tail == null) {
            System.out.println("Error: List is empty");
            return -1; // Assuming -1 as an invalid value
        }
        int data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // List is empty after deletion
        }
        return data;
    }

    // Delete the node after the node p and return its info
    public int deleteAfter(Node p) {
        if (p == null || p.next == null) {
            System.out.println("Error: Invalid node");
            return -1; // Assuming -1 as an invalid value
        }
        int data = p.next.data;
        p.next = p.next.next;
        if (p.next != null) {
            p.next.prev = p;
        } else {
            tail = p; // Node after p was the tail, update tail
        }
        return data;
    }

    // Delete the first node whose info is equal to x
    public void deleteNode(int x) {
        Node current = head;
        while (current != null && current.data != x) {
            current = current.next;
        }
        if (current != null) {
            if (current.prev != null) {
                current.prev.next = current.next;
            } else {
                head = current.next;
            }

            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }
        }
    }

    // Search and return the reference to the first node having info x
    public Node search(int x) {
        Node current = head;
        while (current != null && current.data != x) {
            current = current.next;
        }
        return current;
    }
}
