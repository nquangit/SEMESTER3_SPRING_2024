/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q4;

/**
 *
 * @author ASUS
 */
class CircularLinkedList {
    private Node head;

    public CircularLinkedList() {
        this.head = null;
    }

    // Add a node with value x at the head of the list
    public void addToHead(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            newNode.next = head;
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            head = newNode;
        }
    }

    // Add a node with value x at the tail of the list
    public void addToTail(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Add a node with value x after the node p
    public void addAfter(Node p, int x) {
        if (p == null) {
            System.out.println("Error: Node p cannot be null");
            return;
        }

        Node newNode = new Node(x);
        newNode.next = p.next;
        p.next = newNode;
    }

    // Traverse from head to tail and display info of all nodes in the list
    public void traverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Count and return the number of nodes in the list
    public int count() {
        int count = 0;
        Node temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    // Delete the head and return its info
    public int deleteFromHead() {
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }

        int deletedData = head.data;
        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
        }
        return deletedData;
    }

    // Delete the tail and return its info
    public int deleteFromTail() {
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }

        int deletedData;
        if (head.next == head) {
            deletedData = head.data;
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            deletedData = temp.next.data;
            temp.next = head;
        }
        return deletedData;
    }

    // Delete the node after the node p and return its info
    public int deleteAfter(Node p) {
        if (p == null || p.next == null) {
            System.out.println("Error: Node p cannot be null, and it should have a next node");
            return -1;
        }

        int deletedData = p.next.data;
        p.next = p.next.next;
        return deletedData;
    }

    // Delete the first node whose info is equal to x
    public void deleteNode(int x) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == x) {
            deleteFromHead();
            return;
        }

        Node temp = head;
        while (temp.next != head && temp.next.data != x) {
            temp = temp.next;
        }

        if (temp.next == head) {
            System.out.println("Node with value " + x + " not found");
        } else {
            temp.next = temp.next.next;
        }
    }

    // Search and return the reference to the first node having info x
    public Node search(int x) {
        if (head == null) {
            return null;
        }

        Node temp = head;
        do {
            if (temp.data == x) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);

        return null;
    }

    // Delete node p if it exists in the list
    public void delete(Node p) {
        if (head == null || p == null) {
            return;
        }

        if (p == head) {
            deleteFromHead();
            return;
        }

        Node temp = head;
        while (temp.next != head && temp.next != p) {
            temp = temp.next;
        }

        if (temp.next == head) {
            System.out.println("Node not found");
        } else {
            temp.next = p.next;
        }
    }

    // Delete an i-th node in the list (1-indexed)
    public void deleteNode2(int i) {
        if (head == null || i < 1) {
            System.out.println("Invalid index");
            return;
        }

        if (i == 1) {
            deleteFromHead();
            return;
        }

        Node temp = head;
        for (int j = 1; j < i - 1; j++) {
            temp = temp.next;
            if (temp == head) {
                System.out.println("Invalid index");
                return;
            }
        }

        temp.next = temp.next.next;
    }

    // Add a node with value x before the node p
    public void addBefore(Node p, int x) {
        if (p == null) {
            System.out.println("Error: Node p cannot be null");
            return;
        }

        Node newNode = new Node(x);
        if (p == head) {
            addToTail(x);
            return;
        }

        Node temp = head;
        while (temp.next != head && temp.next != p) {
            temp = temp.next;
        }

        if (temp.next == head) {
            System.out.println("Node not found");
        } else {
            temp.next = newNode;
            newNode.next = p;
        }
    }
}