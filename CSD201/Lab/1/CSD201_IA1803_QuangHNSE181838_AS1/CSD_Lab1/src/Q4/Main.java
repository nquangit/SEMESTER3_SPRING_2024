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
public class Main {
    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();

        circularLinkedList.addToHead(1);
        circularLinkedList.addToTail(3);
        circularLinkedList.addAfter(circularLinkedList.search(1), 2);

        System.out.print("Original List: ");
        circularLinkedList.traverse();

        System.out.println("Number of Nodes: " + circularLinkedList.count());

        System.out.println("Deleted from Head: " + circularLinkedList.deleteFromHead());
        System.out.print("List after deleting from Head: ");
        circularLinkedList.traverse();

        System.out.println("Deleted from Tail: " + circularLinkedList.deleteFromTail());
        System.out.print("List after deleting from Tail: ");
        circularLinkedList.traverse();

        Node nodeToSearch = circularLinkedList.search(2);
        if (nodeToSearch != null) {
            circularLinkedList.addAfter(nodeToSearch, 4);
        }

        System.out.print("List after adding 4 after node with value 2: ");
        circularLinkedList.traverse();

        circularLinkedList.deleteNode(2);
        System.out.print("List after deleting node with value 2: ");
        circularLinkedList.traverse();

        circularLinkedList.delete(nodeToSearch);
        System.out.print("List after deleting reference node: ");
        circularLinkedList.traverse();

        circularLinkedList.addBefore(circularLinkedList.search(1), 5);
        System.out.print("List after adding 5 before node with value 1: ");
        circularLinkedList.traverse();

        circularLinkedList.deleteNode2(2);
        System.out.print("List after deleting 2nd node: ");
        circularLinkedList.traverse();
    }
}
 
