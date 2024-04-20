/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q4;

import Q3.*;
import java.util.EmptyStackException;

/**
 *
 * @author ASUS
 * @param <ObjectType>
 */
public class Stack<ObjectType> {
    private Node<ObjectType> top;

    public Stack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void clear() {
        top = null;
    }

    public void push(ObjectType x) {
        Node<ObjectType> newNode = new Node(x);
        newNode.next = top;
        top = newNode;
    }

    public ObjectType pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        ObjectType value = top.data;
        top = top.next;
        return value;
    }

    public ObjectType top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public void traverse() {
        Node<ObjectType> current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void convertToBinary(int decimalNumber) {
        Stack<Integer> stack = new Stack();

        while (decimalNumber > 0) {
            int remainder = decimalNumber % 2;
            stack.push(remainder);
            decimalNumber /= 2;
        }

        System.out.print("Binary representation: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}

