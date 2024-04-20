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
public class Queue {
    private Node front;
    private Node rear;

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

    public void enqueue(int x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        int value = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return value;
    }

    public int first() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return front.data;
    }

    public void traverse() {
        Node current = front;
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

