/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q10;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        // Example usage
        int n = 5;
        double result = addReciprocals(n);
        System.out.println("Sum of the first " + n + " reciprocals: " + result);
    }

    // Recursive method to calculate the sum of the first n reciprocals
    static double addReciprocals(int n) {
        // Base case: If n is 1, return 1.0
        if (n == 1) {
            return 1.0;
        }

        // Recursive call to add the reciprocal of the current n with the sum of the rest
        return 1.0 / n + addReciprocals(n - 1);
    }
}
