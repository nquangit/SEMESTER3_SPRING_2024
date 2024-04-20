/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q6;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        // Example usage
        int num1 = 48;
        int num2 = 18;

        int gcd = calculateGCD(num1, num2);

        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
    }

    // Recursive method to calculate the GCD of two numbers
    static int calculateGCD(int m, int n) {
        // Base case: GCD(a, 0) = a
        if (n == 0) {
            return m;
        }

        // Recursive case: GCD(a, b) is the same as GCD(b, a % b)
        return calculateGCD(n, m % n);
    }
}
