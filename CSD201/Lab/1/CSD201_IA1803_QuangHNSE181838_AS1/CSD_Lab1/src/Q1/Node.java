/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

/**
 *
 * @author ASUS
 * @param <ObjectType>
 */
public class Node<ObjectType> {

    ObjectType data; //data of Node
    Node next;

    //create a new Node 
    public Node() {
    }

    public Node(ObjectType data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(ObjectType data) {
        this(data, null);
    }

}
