/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

/**
 *
 * @author ASUS
 * @param <ObjectType>
 */
public class Node<ObjectType> {

    ObjectType data;
    Node next;

    public Node(ObjectType data) {
        this.data = data;
        this.next = null;
    }
}

