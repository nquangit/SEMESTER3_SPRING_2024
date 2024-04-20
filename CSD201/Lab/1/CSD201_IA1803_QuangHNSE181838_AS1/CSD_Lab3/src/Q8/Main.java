/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q8;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        // Example usage
        int number = 5;

        int result = fact(number);

        System.out.println("Factorial of " + number + " is: " + result);
    }

    // Recursive method to calculate the factorial of a number
    static int fact(int n) {
        // Base case: factorial of 0 is 1
        if (n == 0) {
            return 1;
        }

        // Recursive case: n! = n * (n-1)!
        return n * fact(n - 1);
    }
}
