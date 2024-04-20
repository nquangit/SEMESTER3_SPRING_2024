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
    public static void main(String[] args) {
        Queue queue = new Queue();

        // Test the operations
        System.out.println("Is Queue empty? " + queue.isEmpty());

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue after enqueue:");
        queue.traverse();

        try {
            System.out.println("Dequeue operation result: " + queue.dequeue());
            System.out.println("First element in the queue: " + queue.first());

            System.out.println("Queue after dequeue:");
            queue.traverse();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Convert a real number to binary
        double realNumber = 0.625;
        System.out.println("Binary representation of " + realNumber + ": " + Queue.convertToBinary(realNumber));
    }
}
