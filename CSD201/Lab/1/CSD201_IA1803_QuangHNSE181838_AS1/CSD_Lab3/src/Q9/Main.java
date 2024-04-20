/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q9;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        // Example usage
        int n = 6;

        int result = fib(n);

        System.out.println("Fibonacci of " + n + " is: " + result);
    }

    // Recursive method to calculate the Fibonacci of a number
    static int fib(int n) {
        // Base case: Fibonacci of 0, 1, or 2 is 1
        if (n <= 2) {
            return 1;
        }

        // Recursive case: Fibonacci(n) = Fibonacci(n-1) + Fibonacci(n-2)
        return fib(n - 1) + fib(n - 2);
    }
}
