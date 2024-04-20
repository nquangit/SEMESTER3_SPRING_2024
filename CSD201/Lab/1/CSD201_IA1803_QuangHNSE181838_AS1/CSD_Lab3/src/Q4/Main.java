/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q4;

import java.util.Arrays;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        // Example usage
        char[] array = {'r', 'a', 'c', 'e', 'c', 'a', 'r'};
        int size = array.length;

        if (ispalindrome(array, size) == 1) {
            System.out.println("The array is a palindrome.");
        } else {
            System.out.println("The array is not a palindrome.");
        }
    }

    // Recursive function to check if an array is a palindrome
    static int ispalindrome(char a[], int n) {
        // Base case: If the array has 0 or 1 elements, it is a palindrome
        if (n <= 1) {
            return 1;
        }

        // Check if the first and last elements are the same
        if (a[0] != a[n - 1]) {
            return 0; // Not a palindrome
        }

        // Recursive call with the subarray excluding the first and last elements
        return ispalindrome(Arrays.copyOfRange(a, 1, n - 1), n - 2);
    }
}
