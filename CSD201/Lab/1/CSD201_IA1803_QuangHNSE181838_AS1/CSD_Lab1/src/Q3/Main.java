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
public class Main {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addToHead(1);
        list.addToTail(2);
        list.addToTail(3);
        list.addAfter(list.search(2), 4);

        System.out.println("List:");
        list.traverse();

        System.out.println("Number of nodes: " + list.count());

        System.out.println("Deleted from head: " + list.deleteFromHead());
        System.out.println("Deleted from tail: " + list.deleteFromTail());

        System.out.println("List after deletions:");
        list.traverse();

        int valueToDelete = 3;
        System.out.println("Deleting node with value " + valueToDelete);
        list.deleteNode(valueToDelete);
        System.out.println("List after deleting node with value " + valueToDelete + ":");
        list.traverse();

        int searchValue = 2;
        Node foundNode = list.search(searchValue);
        if (foundNode != null) {
            System.out.println("Node with value " + searchValue + " found!");
        } else {
            System.out.println("Node with value " + searchValue + " not found!");
        }
    }
}
