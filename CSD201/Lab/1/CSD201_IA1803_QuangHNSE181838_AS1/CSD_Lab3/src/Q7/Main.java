/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q7;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        // Example usage
        int base = 2;
        int exponent = 5;

        int result = power(base, exponent);

        System.out.println(base + " raised to the power of " + exponent + " is: " + result);
    }

    // Recursive method to calculate the power of a number
    static int power(int base, int exponent) {
        // Base case: any number raised to the power of 0 is 1
        if (exponent == 0) {
            return 1;
        }

        // Recursive case: base^exponent = base * base^(exponent - 1)
        return base * power(base, exponent - 1);
    }
}
