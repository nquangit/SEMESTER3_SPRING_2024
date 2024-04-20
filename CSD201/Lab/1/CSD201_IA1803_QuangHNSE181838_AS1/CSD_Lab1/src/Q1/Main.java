/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] argv) {
        SinglyLinkedList myList = new SinglyLinkedList();
        // Function 1: void addToHead(int x) - add a node with value x at the head of a list.
        System.out.println("addToHead");
        myList.addToHead(10);
        myList.addToHead(8);
        myList.addToHead(4);
        myList.addToHead(2);
        myList.traverse();
        System.out.println();
        // Function 2: void addToTail(int x) - add a node with value x at the tail of a list.
        System.out.println("addToTail");
        myList.addToTail(20);
        myList.addToTail(25);
        myList.addToTail(40);
        myList.addToTail(60);
        myList.traverse();
        System.out.println();
        // Function 3: void addAfter(Node p, int x) - add a node with value x after the node p.
        System.out.println("addAfter");
        Node n = myList.head;
        myList.addAfter(n, 0);
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
        int x = 10;
        myList.deleteNode(x);
        myList.traverse();
        System.out.println();
        // Function 10: Node search(int x) - search and return the reference to the first node having info x.
        System.out.println("search");
        Node search = myList.search(20);
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
        myList.addBefore(add, index);
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
        int[] arrayInt = myList.toArray();
        for (int i = 0; i < arrayInt.length; i++) {
            System.out.print(Integer.toString(arrayInt[i]) + " ");
        }
        System.out.println();
        // Function 17: Merge two ordered singly linked lists of integers into one ordered list.
        System.out.println("mergeOrderedSinglyLinkedList");
        SinglyLinkedList otherList = new SinglyLinkedList();
        otherList.addToHead(-6);
        otherList.addToTail(33);
        otherList.addToTail(65);
        otherList.addToTail(92);
        otherList.mergeOrderedSinglyLinkedList(myList);
        otherList.traverse();
        System.out.println();
        // Function 18: Attach a singly linked list to the end of another singly linked list.
        System.out.println("attachSinglyLinkedList");
        SinglyLinkedList jotherList = new SinglyLinkedList();
        jotherList.addToHead(-9);
        jotherList.addToTail(37);
        jotherList.addToTail(63);
        jotherList.addToTail(97);
        jotherList.attachSinglyLinkedList(myList);
        jotherList.traverse();
        System.out.println();
        // Function 19: int max() - find and return the maximum value in the list.
        System.out.println("max");
        int maxVal = myList.max();
        System.out.println(maxVal);
        // Function 20: int min() - find and return the minimum value in the list.
        System.out.println("min");
        int minVal = myList.min();
        System.out.println(minVal);
        // Function 21: int sum() - return the sum of all values in the list.
        System.out.println("sum");
        int sumVal = myList.sum();
        System.out.println(sumVal);
        // Function 22: int avg() - return the average of all values in the list.
        System.out.println("avg");
        int avgVal = myList.avg();
        System.out.println(avgVal);
        // Function 23: boolean sorted() - check and return true if the list is sorted, return false if the list is not sorted.
        System.out.println("sorted");
        SinglyLinkedList myOtherList = new SinglyLinkedList();
        myOtherList.addToHead(10);
        myOtherList.addToHead(8);
        myOtherList.addToHead(99);
        myOtherList.addToHead(55);
        myOtherList.traverse();
        boolean sorted = myOtherList.sorted();
        String check = (sorted) ? "Sorted" : "Not Sorted";
        System.out.println(check);
        // Try sort then check again
        myOtherList.sort();
        myOtherList.traverse();
        sorted = myOtherList.sorted();
        check = (sorted) ? "Sorted" : "Not Sorted";
        System.out.println(check);
        // Function 24: void insert(int x) - insert node with value x into sorted list so that the new list is sorted.
        System.out.println("insert");
        x = 29;
        myList.insert(x);
        myList.traverse();
        System.out.println();
        // Function 25: Check whether two singly linked list have the same contents.
        System.out.println("haveTheSameContent");
        boolean same = myList.haveTheSameContent(otherList);
        check = (same) ? "Same" : "Not Same";
        System.out.println(check);
        myList.traverse();
        System.out.println();
    }
}
