/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q5;

import Q4.*;
import Q3.*;

/**
 *
 * @author ASUS
 * @param <ObjectType>
 */
public class Queue<ObjectType> {
    private Node<ObjectType> front;
    private Node<ObjectType> rear;

    public Queue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void clear() {
        front = null;
        rear = null;
    }

    public void enqueue(ObjectType x) {
        Node<ObjectType> newNode = new Node(x);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public ObjectType dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        ObjectType value = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return value;
    }

    public ObjectType first() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return front.data;
    }

    public void traverse() {
        Node<ObjectType> current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static String convertToBinary(double realNumber) {
        // Use Queue to convert real number to binary
        Queue binaryQueue = new Queue();

        while (realNumber > 0) {
            realNumber *= 2;
            int bit = (int) realNumber;
            binaryQueue.enqueue(bit);
            realNumber -= bit;
        }

        // Construct binary representation from the queue
        StringBuilder binaryRepresentation = new StringBuilder();
        while (!binaryQueue.isEmpty()) {
            try {
                binaryRepresentation.append(binaryQueue.dequeue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return binaryRepresentation.toString();
    }
}


