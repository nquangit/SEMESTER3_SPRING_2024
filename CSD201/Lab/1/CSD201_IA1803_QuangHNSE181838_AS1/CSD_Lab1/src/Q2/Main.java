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
public class Main {

    public static void main(String[] argv) {
        SinglyLinkedList myList = new SinglyLinkedList();
        // Function 1: void addToHead(int x) - add a node with value x at the head of a list.
        System.out.println("addToHead");
        myList.addToHead("abc");
        myList.addToHead("def");
        myList.addToHead("geh");
        myList.addToHead("agc");
        myList.traverse();
        System.out.println();
        // Function 2: void addToTail(int x) - add a node with value x at the tail of a list.
        System.out.println("addToTail");
        myList.addToTail("artg");
        myList.addToTail("fghb");
        myList.addToTail("bbvcbfg");
        myList.addToTail("e566");
        myList.traverse();
        System.out.println();
        // Function 3: void addAfter(Node p, int x) - add a node with value x after the node p.
        System.out.println("addAfter");
        Node n = myList.head;
        myList.addAfter(n, "urtr");
        myList.traverse();
        System.out.println();
        // Function 4: void traverse() - traverse from head to tail and dislay info of all nodes in the list.
        System.out.println("traverse");
        myList.traverse();
        System.out.println();
        // Function 5: int count() - count and return number of nodes in the list.
        System.out.println("count");
        System.out.println(myList.count());
        // Function 6: int deleteFromHead() - delete the head and return its info.
        System.out.println("deleteFromHead");
        myList.deleteFromHead();
        myList.traverse();
        System.out.println();
        // Function 7: int deleteFromTail() - delete the tail and return its info.
        System.out.println("deleteFromTail");
        myList.deleteFromTail();
        myList.traverse();
        System.out.println();
        // Function 8: int deleteAter(Node p) - delete the node after the node p and return its info.
        System.out.println("deleteAter");
        Node dn = myList.head;
        myList.deleteAter(dn);
        myList.traverse();
        System.out.println();
        // Function 9: void delete Node(int x) - delele the first node whose info is equal to x.
        System.out.println("deleteNode");
        String x = "urtr";
        myList.deleteNode(x);
        myList.traverse();
        System.out.println();
        // Function 10: Node search(int x) - search and return the reference to the first node having info x.
        System.out.println("search");
        Node search = myList.search("agc");
        if (search != null) {
            System.out.println(search.data);
        } else {
            System.out.println("Not Found");
        }
        // Function 11: void delete(Node p) - delete node p if it exists in the list.
        System.out.println("delete");
        Node don = myList.head;
        myList.delete(don);
        myList.traverse();
        System.out.println();
        // Function 12: void delete Node2(int i) - delete an i-th node on the list. Besure that such a node exists.
        System.out.println("deleteNode2");
        int index = 2;
        myList.deleteNode2(index);
        myList.traverse();
        System.out.println();
        // Function 13: void addBefore(Node p, int x) - add a node with value x before the node p.
        System.out.println("addBefore");
        Node add = myList.head.next;
        myList.addBefore(add, "e8ter89t7");
        myList.traverse();
        System.out.println();
        // Function 14: void sort() - sort the list by ascending order of info.
        System.out.println("sort");
        myList.sort();
        myList.traverse();
        System.out.println();
        // Function 15: Reverse a singly linked list using only one pass through the list.
        System.out.println("reverse");
        myList.reverse();
        myList.traverse();
        System.out.println();
        // Function 16: int [] toArray() - create and return array containing info of all nodes in the list.
        System.out.println("toArray");
        String[] arrayInt = myList.toArray();
        for (String arrayInt1 : arrayInt) {
            System.out.print(arrayInt1 + " ");
        }
        System.out.println();
        // Function 17: Merge two ordered singly linked lists of integers into one ordered list.
        System.out.println("mergeOrderedSinglyLinkedList");
        SinglyLinkedList otherList = new SinglyLinkedList();
        otherList.addToHead("45645654");
        otherList.addToTail("3423423");
        otherList.addToTail("6457fg");
        otherList.addToTail("nbvmc");
        otherList.mergeOrderedSinglyLinkedList(myList);
        otherList.traverse();
        System.out.println();
        // Function 18: Attach a singly linked list to the end of another singly linked list.
        System.out.println("attachSinglyLinkedList");
        SinglyLinkedList jotherList = new SinglyLinkedList();
        jotherList.addToHead("6ss65");
        jotherList.addToTail("sfet");
        jotherList.addToTail("6effdv");
        jotherList.addToTail("trgf");
        jotherList.attachSinglyLinkedList(myList);
        jotherList.traverse();
        System.out.println();
    }
}
