/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

/**
 *
 * @author ASUS
 */
public class SinglyLinkedList {

    Node<String> head, tail;

    public SinglyLinkedList() {
        head = tail = null;
    }

    // Inserts a new node at front of the list.
    public void addToHead(String newData) {
        Node<String> newNode = new Node(newData);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    //Inserts a new node at the end of a list
    public void addToTail(String newData) {
        Node<String> newNode = new Node(newData);
        if (count() == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Inserts a new node after the given prev_node
    void addAfter(Node prevNode, String newData) {
        /* 1. Check if the given Node is null */
        if (prevNode == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        /* 2. Allocate the Node & 3. Put in the data*/
        Node<String> newNode = new Node(newData);
        /* 4. Make next of new Node as next of prev_node */
        newNode.next = prevNode.next;
        /* 5. make next of prev_node as new_node */
        prevNode.next = newNode;
    }

    // This function prints contents of linked list starting 
    // from the given node
    public void traverse() {
        Node<String> tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        System.out.println();
    }

    // Return number of nodes in the list
    public int count() {
        Node<String> p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    // Delete a node from the beginning of a list
    public void deleteFromHead() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    // Delete a node from the end of a list
    public void deleteFromTail() {
        Node<String> p = head;
        if (p == null) {
            return;
        }
        //if head in not null and next of head is null, delete the head
        if (p.next == null) {
            p = null;
        } else { //else, traverse to the second last element of the list
            Node<String> temp = new Node();
            temp = p;
            while (temp.next.next != null) {
                temp = temp.next; // temp is the second last node 
            }            //change the next of temp to null and delete the last node
            Node<String> lastNode = temp.next;
            temp.next = null;
            lastNode = null;
        }
    }

    void deleteAter(Node p) {
        Node<String> prev = p, temp = p.next;
        if (temp == null) {
            return;
        }
        // Unlink the node from linked list
        prev.next = temp.next;
    }

    // Given a key, deletes the first occurrence of key in linked list
    public void deleteNode(String key) {
        // Store head node
        Node<String> temp = head, prev = null;
        // If head node itself holds the key to be deleted
        if (temp != null && temp.data.equals(key)) {
            head = temp.next; // Changed head
            return;
        }
        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data.equals(key)) {
            prev = temp;
            temp = temp.next;
        }
        // If key was not present in linked list
        if (temp == null) {
            return;
        }
        // Unlink the node from linked list
        prev.next = temp.next;
    }

    // Return the first node which data=x, otherwise return null
    Node<String> search(String x) {
        Node<String> p = head;
        while (p != null) {
            if (p.data.equals(x)) {
                break;
            }
            p = p.next;
        }
        return p;
    }

    // Delete a node from the list
    void delete(Node p) {
        if (p == null) {
            return;
        }
        // find prev where prev.next = p
        Node<String> f = head, prev = null;
        while (f != null && f != p) {
            prev = f;
            f = f.next;
        }
        if (prev == null) { // remove head
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            prev.next = p.next;
            if (p == tail) {
                tail = prev;
            }
        }
        p.next = null;
    }

    // Delete an i-th node on the list
    public void deleteNode2(int i) {
        Node<String> p = head;
        int count = 0;
        while (p != null && count < i) {
            count++;
            p = p.next;
        }
        delete(p);
    }

    void addBefore(Node given_ptr, String new_data) {
        // First check if the given pointer is the address of head
        if (head == given_ptr) {
            Node<String> n = new Node(new_data); // Create a new node
            n.next = head; // Point to next to current head
            head = n; // Update the head pointer
            // Otherwise, traverse the list to find previous node of given node
        } else {
            Node<String> prev = null;
            // This loop will return p with previous pointer of given node
            for (Node n = head; n != given_ptr; prev = n, n = n.next);
            // Create a new node
            Node<String> m = new Node(new_data);
            // Update the m.next
            m.next = prev.next;
            // Update previous node' s next
            prev.next = m;
        }
    }

    // Sort the list ascending 
    public void sort() {
        int n = count();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Node<String> pi = get(i), pj = get(j);
                if (pi.data.compareTo(pj.data) > 0) {
                    String temp = pi.data;
                    pi.data = pj.data;
                    pj.data = temp;
                }
            }
        }
    }

    // Reverse a list
    public void reverse() {
        int n = count();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            Node<String> pi = get(i), pj = get(j);
            String temp = pi.data;
            pi.data = pj.data;
            pj.data = temp;
        }
    }

    public String[] toArray() {
        String[] strList = new String[count()];
        Node<String> p = head;
        int count = 0;
        while (p != null) {
            strList[count] = p.data;
            count++;
            p = p.next;
        }
        return strList;
    }

    public void attachSinglyLinkedList(SinglyLinkedList otherList) {
        if (otherList == null) {
            return;
        }
        if (head == null) {
            head = otherList.head;
            tail = otherList.tail;
        } else {
            Node<String> p = otherList.head;
            while (p != null) {
                addToTail(p.data);
                p = p.next;
            }
        }
    }

    public void mergeOrderedSinglyLinkedList(SinglyLinkedList otherList) {
        // We can attach that list to current list
        // Then sort it
        attachSinglyLinkedList(otherList);
        sort();
    }

    public String max() {
        sort();
        return tail.data;
    }

    public String min() {
        sort();
        return head.data;
    }

    public boolean sorted() {
        int n = count();
        for (int i = 0; i < n - 1; i++) {
            Node<String> pi = get(i), pj = get(i + 1);
            if (pi.data.compareTo(pj.data) > 0) {
                return false;
            }
        }
        return true;
    }

    public void insert(String x) {
        // Or
        Node<String> p = head;
        while (p != null) {
            if (x.compareTo(p.data) < 0 ) {
                addBefore(p, x);
                break;
            }
            p = p.next;
        }
    }

    public boolean haveTheSameContent(SinglyLinkedList otherList) {
        // If the size of both list is not equal
        // So, it is not have the same content
        if (count() != otherList.count()) {
            return false;
        }
        // Sort my list and the other list to have the same order for compare
        sort();
        otherList.sort();
        Node<String> p = head;
        Node<String> po = otherList.head;
        while (p != null && po != null) {
            if (p.data != po.data) {
                return false;
            }
            p = p.next;
        }
        return true;
    }

    /*
    *
    *
    * These are some bonus method 
    *
    *
     */
    void deleteBefore(Node p) {
        if (p == null || p == head) {
            return;
        }
        Node<String> tmp = null;
        Node<String> n = head;
        while (n != null && n.next != p) {
            tmp = n;
            n = n.next;
        }
        if (n == null) {
            return;
        } else if (n == head) {
            head = p;
        } else {
            tmp.next = p;
        }
    }

    // Return a node at position i
    Node<String> get(int i) {
        Node<String> p = head;
        int count = 0;
        while (p != null && count < i) {
            count++;
            p = p.next;
        }
        return p;
    }

}
