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
    public static void main(String[] argv) {
        Stack<String> stack = new Stack();

        // Example usage
        stack.push("Quang");
        stack.push("Thuan");
        stack.push("SI");
        stack.traverse();

        System.out.println("Top element: " + stack.top());

        stack.pop();
        stack.traverse();

        System.out.println("Is stack empty? " + stack.isEmpty());

        stack.clear();
        System.out.println("Is stack empty after clearing? " + stack.isEmpty());
        
        // Queue
        Queue<String> queue = new Queue();

        // Test the operations
        System.out.println("Is Queue empty? " + queue.isEmpty());

        queue.enqueue("Quang");
        queue.enqueue("Tuan");
        queue.enqueue("Nguyen");

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
    }
}

