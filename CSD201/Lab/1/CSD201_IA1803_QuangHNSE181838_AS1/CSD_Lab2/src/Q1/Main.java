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
import java.util.Scanner;

// Main.java
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        // Example usage
        stack.push(5);
        stack.push(10);
        stack.push(15);
        stack.traverse();

        System.out.println("Top element: " + stack.top());

        stack.pop();
        stack.traverse();

        System.out.println("Is stack empty? " + stack.isEmpty());

        stack.clear();
        System.out.println("Is stack empty after clearing? " + stack.isEmpty());

        // Convert decimal to binary
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimalNumber = scanner.nextInt();
        Stack.convertToBinary(decimalNumber);
    }
}

